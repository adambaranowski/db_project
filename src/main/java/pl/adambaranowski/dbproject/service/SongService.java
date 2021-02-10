package pl.adambaranowski.dbproject.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.adambaranowski.dbproject.model.Category;
import pl.adambaranowski.dbproject.model.Song;

import java.util.List;

@Service
public class SongService {

    private static final String ADD_SONG = "INSERT INTO songs (title, author_id, length_sec, is_single, album_id) VALUES (?, ?, ?, ?, ?);";
    private static final String DELETE_SONG_BY_ID = "DELETE FROM songs WHERE song_id=?;";
    private static final String DELETE_SONG_BY_TITLE = "DELETE FROM songs WHERE title=?;";
    private static final String DELETE_SONG_BY_AUTHOR_ID = "DELETE FROM songs WHERE author_id=?;";
    private static final String GET_SONG_BY_ID = "SELECT s.song_id, Count(s.song_id) as number_of_votes, s.title, s.author_id, s.length_sec, s.is_single, s.album_id FROM songs s LEFT JOIN votes v ON s.song_id=v.song_id AND s.song_id=? GROUP BY s.song_id ORDER BY Count(s.song_id) DESC LIMIT 1;";
    private static final String GET_SONG_BY_TITLE = "SELECT s.song_id, Count(s.song_id) as number_of_votes, s.title, s.author_id, s.length_sec, s.is_single, s.album_id FROM songs s LEFT JOIN votes v ON s.song_id=v.song_id AND s.title=? GROUP BY s.song_id ORDER BY Count(s.song_id) DESC LIMIT 1;";
    private static final String GET_ALL_SONG = "SELECT s.song_id, Count(s.song_id) as number_of_votes, s.title, s.author_id, s.length_sec, s.is_single, s.album_id FROM songs s LEFT JOIN votes v ON s.song_id=v.song_id GROUP BY s.song_id ORDER BY Count(s.song_id);";
    private static final String GET_SONGS_SORTED = "SELECT s.song_id, Count(s.song_id) as number_of_votes, s.title, s.author_id, s.length_sec, s.is_single, s.album_id FROM songs s LEFT JOIN votes v ON s.song_id=v.song_id GROUP BY s.song_id ORDER BY Count(s.song_id) DESC;";

    private JdbcTemplate template;
    private RowMapper rowMapper = BeanPropertyRowMapper.newInstance(Song.class);

    @Autowired
    public SongService(JdbcTemplate template) {
        this.template = template;
    }

    public void addSong(String title, Integer author_id,Integer  length_sec, Integer is_single,Integer  album_id){
        template.update(ADD_SONG, title, author_id, length_sec, is_single, album_id);
    }

    public void deleteSongById(Integer song_id){
        template.update(DELETE_SONG_BY_ID, song_id);
    }

    public void deleteSongByTitle(String title){
        template.update(DELETE_SONG_BY_TITLE, title);
    }

    public void deleteSongByAuthorId(Integer author_id){
        template.update(DELETE_SONG_BY_AUTHOR_ID, author_id);
    }

    public Song getSongById(Integer song_id){
        List<Song> query = template.query(GET_SONG_BY_ID, rowMapper, song_id);
        return query.get(0);
    }

    public Song getSongByTitle(String title){
        List<Song> query = template.query(GET_SONG_BY_TITLE, rowMapper, title);
        return query.get(0);
    }

    public List<Song> getAllSongs(){
        List<Song> query = template.query(GET_ALL_SONG, rowMapper);
        return query;
    }

    public List<Song> getSongsSorted(){
        List<Song> query = template.query(GET_SONGS_SORTED, rowMapper);
        return query;
    }
}
