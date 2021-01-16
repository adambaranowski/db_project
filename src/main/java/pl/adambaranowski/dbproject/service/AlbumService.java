package pl.adambaranowski.dbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import pl.adambaranowski.dbproject.model.Album;

import java.util.List;

@Service
public class AlbumService {
    private static final String ADD_ALBUM_WITH_CATEGORY = "INSERT INTO albums (album_name, category_id) VALUES (?, ?);";
    private static final String ADD_ALBUM_WITHOUT_CATEGORY = "INSERT INTO albums (album_name) VALUE (?);";
    private static final String DELETE_ALBUM_BY_ID = "DELETE FROM albums WHERE album_id=?;";
    private static final String DELETE_ALBUM_BY_NAME = "DELETE FROM albums WHERE album_name=?;";
    private static final String GET_ALBUM_BY_ID = "SELECT * FROM albums WHERE album_id=? LIMIT 1;";
    private static final String GET_ALBUM_BY_NAME = "SELECT * FROM albums WHERE album_name=? LIMIT 1;";
    private static final String GET_ALL_ALBUMS = "SELECT * FROM albums LIMIT 1;";

    private JdbcTemplate template;
    private RowMapper rowMapper = BeanPropertyRowMapper.newInstance(Album.class);

    @Autowired
    public AlbumService(JdbcTemplate template) {
        this.template = template;
    }

    public void addAlbumWithCategory(String album_name, int category_id){
        template.update(ADD_ALBUM_WITH_CATEGORY, album_name, category_id);
    }

    public void addAlbumWithoutCategory(String album_name){
        template.update(ADD_ALBUM_WITHOUT_CATEGORY, album_name);
    }

    public void deleteAlbumById(int album_id){
        template.update(DELETE_ALBUM_BY_ID, album_id);
    }

    public void deleteAlbumByName(String album_name){
        template.update(DELETE_ALBUM_BY_NAME, album_name);
    }

    public Album getAlbumById(int album_id){
        List<Album> query = template.query(GET_ALBUM_BY_ID, rowMapper, album_id);
        return query.get(0);
    }

    public Album getAlbumByName(String album_name){
        List<Album> query = template.query(GET_ALBUM_BY_NAME, rowMapper, album_name);
        return query.get(0);
    }

    public List<Album> getAllAlbums(){
        List<Album> query = template.query(GET_ALL_ALBUMS, rowMapper);
        return query;
    }
}
