package pl.adambaranowski.dbproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adambaranowski.dbproject.model.Album;
import pl.adambaranowski.dbproject.service.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/albums")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlbumController {
    private AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity<Object> addAlbum(@RequestParam String album_name, @RequestParam(required = false) Integer category_id){
        if(category_id != null){
            albumService.addAlbumWithCategory(album_name, category_id);
        }else {
            albumService.addAlbumWithoutCategory(album_name);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/album-id/{album_id}")
    public ResponseEntity<Object> deleteAlbumById(@PathVariable Integer album_id){
        albumService.deleteAlbumById(album_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/album-name/{album_name}")
    public ResponseEntity<Object> deleteAlbumByName(@PathVariable String album_name){
        albumService.deleteAlbumByName(album_name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/album-id/{album_id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Integer album_id){
        Album albumById = albumService.getAlbumById(album_id);
        return new ResponseEntity<>(albumById, HttpStatus.OK);
    }

    @GetMapping("/album-name/{album_name}")
    public ResponseEntity<Album> getAlbumByName(@PathVariable String album_name ){
        Album albumByName = albumService.getAlbumByName(album_name);
        return new ResponseEntity<>(albumByName, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Album>> getAllAlbums(){
        List<Album> allAlbums = albumService.getAllAlbums();
        return new ResponseEntity<>(allAlbums, HttpStatus.OK);
    }
}
