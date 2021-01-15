package pl.adambaranowski.dbproject.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adambaranowski.dbproject.model.Author;
import pl.adambaranowski.dbproject.model.Category;
import pl.adambaranowski.dbproject.model.Song;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;
import java.util.List;

@Service
@NamedNativeQuery(name = "addSong", query = "INSERT INTO songs (title, author_id, length_sec, is_single, album_id) VALUES ?, ?, ?, ?, ?;")
@NamedNativeQuery(name = "deleteSongById", query = "DELETE FROM songs WHERE song_id=?;")
@NamedNativeQuery(name = "deleteSongByTitle", query = "DELETE FROM songs WHERE title=?;")
@NamedNativeQuery(name = "deleteSongByAuthorId", query = "DELETE FROM songs WHERE author_id=?;")
@NamedNativeQuery(name = "getSongById", query = "SELECT FROM  songs WHERE song_id=? LIMIT 1;")
@NamedNativeQuery(name = "getSongByTitle", query = "SELECT FROM songs WHERE title=? LIMIT 1;")
@NamedNativeQuery(name = "getAllSongs", query = "SELECT * FROM songs;")
public class SongService {

    private EntityManager entityManager;

    @Autowired
    public SongService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addSong(String title, int author_id,int  length_sec, int is_single,int  album_id){
        Query query = entityManager.createNativeQuery("addSong");
        query.setParameter(1, title);
        query.setParameter(2, author_id);
        query.setParameter(3, length_sec);
        query.setParameter(4, is_single);
        query.setParameter(5, album_id);
        query.executeUpdate();
    }

    public void deleteSongById(int song_id){
        Query query = entityManager.createNativeQuery("deleteSongById");
        query.setParameter(1, song_id);
        query.executeUpdate();
    }

    public void deleteSongByTitle(String title){
        Query query = entityManager.createNativeQuery("deleteSongByTitle");
        query.setParameter(1, title);
        query.executeUpdate();
    }

    public void deleteSongByAuthorId(int author_id){
        Query query = entityManager.createNativeQuery("deleteSongByAuthorId");
        query.setParameter(1, author_id);
        query.executeUpdate();
    }

    public Song getSongById(int song_id){
        Query query = entityManager.createNativeQuery("getSongById", Song.class);
        query.setParameter(1, song_id);
        List resultList = query.getResultList();
        return (Song) resultList.get(0);
    }

    public Song getSongByTitle(String title){
        Query query = entityManager.createNativeQuery("getSongByTitle", Song.class);
        query.setParameter(1, title);
        List resultList = query.getResultList();
        return (Song) resultList.get(0);
    }

    public List<Song> getAllSongs(){
        Query query = entityManager.createNativeQuery("getAllSongs", Category.class);
        List<Song> resultList = query.getResultList();
        return resultList;
    }
}
