package pl.adambaranowski.dbproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adambaranowski.dbproject.model.Song;
import pl.adambaranowski.dbproject.service.SongService;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    private SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    public ResponseEntity<Object> createNewSong(@RequestParam String title,
                                                @RequestParam(required = false) Integer author_id,
                                                @RequestParam(required = false) Integer  length_sec,
                                                @RequestParam(required = false) Integer is_single,
                                                @RequestParam(required = false) Integer  album_id){
        songService.addSong(title, author_id, length_sec, is_single, album_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/song_id")
    public ResponseEntity<Object> deleteSongById(@RequestParam Integer song_id){
        songService.deleteSongById(song_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/title")
    public ResponseEntity<Object> deleteSongByTitle(@RequestParam String title){
        songService.deleteSongByTitle(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/author_id")
    public ResponseEntity<Object> deleteSongByTitle(@RequestParam Integer author_id){
        songService.deleteSongByAuthorId(author_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/song_id")
    public ResponseEntity<Song> getSongById(@RequestParam Integer song_id){
        Song songById = songService.getSongById(song_id);
        return new ResponseEntity<>(songById, HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<Song> getSongByTitle(@RequestParam String title){
        Song songByTitle = songService.getSongByTitle(title);
        return new ResponseEntity<>(songByTitle, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Song>> getAllSongs(){
        List<Song> allSongs = songService.getAllSongs();
        return new ResponseEntity<>(allSongs, HttpStatus.OK);
    }
}
