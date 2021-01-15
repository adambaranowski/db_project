package pl.adambaranowski.dbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import pl.adambaranowski.dbproject.model.Album;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;
import java.util.List;

@Service
@NamedNativeQuery(name = "addAlbumWithCategory", query = "INSERT INTO albums (album_name, category_id) VALUES ?, ?;")
@NamedNativeQuery(name = "addAlbumWithoutCategory", query = "INSERT INTO albums (album_name) VALUES ?;")
@NamedNativeQuery(name = "deleteAlbumById", query = "DELETE FROM albums WHERE album_id=?;")
@NamedNativeQuery(name = "deleteAlbumByName", query = "DELETE FROM albums WHERE album_name=?;")
@NamedNativeQuery(name = "getAlbumById", query = "SELECT FROM  albums WHERE album_id=? LIMIT 1;")
@NamedNativeQuery(name = "getAlbumByName", query = "SELECT FROM albums WHERE album_name=? LIMIT 1;")
@NamedNativeQuery(name = "getAllAlbums", query = "SELECT * FROM albums;")
public class AlbumService {

    private EntityManager entityManager;
    private JdbcTemplate template;

    @Autowired
    public AlbumService(EntityManager entityManager, JdbcTemplate template) {
        this.entityManager = entityManager;
        this.template = template;
    }

    public void addAlbumWithCategory(String album_name, int category_id){
        template.update("INSERT INTO albums (album_name, category_id) VALUES (?, ?);", album_name, category_id);
    }

    public void addAlbumWithoutCategory(String album_name){
        int update = template.update("INSERT INTO albums (album_name) VALUE (?);", album_name);
    }

    public void deleteAlbumById(int album_id){
        Query query = entityManager.createNativeQuery("deleteAlbumById");
        query.setParameter(1, album_id);
        query.executeUpdate();
    }

    public void deleteAlbumByName(String album_name){
        Query query = entityManager.createNativeQuery("deleteAlbumByName");
        query.setParameter(1, album_name);
        query.executeUpdate();
    }

    public Album getAlbumById(int album_id){
        Album album = template.queryForObject("SELECT FROM  albums WHERE album_id=" + album_id + " LIMIT 1", Album.class);
        return album;
    }

    public Album getAlbumByName(String album_name){
        var rowMapper = BeanPropertyRowMapper.newInstance(Album.class);
        List<Album> query = template.query("SELECT * FROM albums WHERE album_name='" + album_name + "' LIMIT 1;", rowMapper);
        return query.get(0);
    }

    public List<Album> getAllAlbums(){
        Query query = entityManager.createNativeQuery("getAllAlbums", Album.class);
        List<Album> resultList = query.getResultList();
        return resultList;
    }
}
