package pl.adambaranowski.dbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.adambaranowski.dbproject.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;
import java.util.List;

@Service
@NamedNativeQuery(name = "addAuthor", query = "INSERT INTO authors (author_name) VALUES ?;")
@NamedNativeQuery(name = "deleteAuthorById", query = "DELETE FROM authors WHERE author_id=?;")
@NamedNativeQuery(name = "deleteAuthorByName", query = "DELETE FROM authors WHERE author_name=?;")
@NamedNativeQuery(name = "getAuthorById", query = "SELECT FROM  authors WHERE author_id=? LIMIT 1;")
@NamedNativeQuery(name = "getAuthorByName", query = "SELECT FROM authors WHERE author_name=? LIMIT 1;")
@NamedNativeQuery(name = "getAllAuthors", query = "SELECT * FROM authors;")
public class AuthorService {

    private EntityManager entityManager;

    @Autowired
    public AuthorService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addAuthor(String author_name){
        Query query = entityManager.createNativeQuery("addAuthor");
        query.setParameter(1, author_name);
        query.executeUpdate();
    }

    public void deleteAuthorById(int author_id){
        Query query = entityManager.createNativeQuery("deleteAuthorById");
        query.setParameter(1, author_id);
        query.executeUpdate();
    }

    public void deleteAuthorByName(String author_name){
        Query query = entityManager.createNativeQuery("deleteAuthorByName");
        query.setParameter(1, author_name);
        query.executeUpdate();
    }

    public Author getAuthorByName(String author_name){
        Query query = entityManager.createNativeQuery("getAuthorByName", Author.class);
        query.setParameter(1, author_name);
        List resultList = query.getResultList();
        return (Author) resultList.get(0);
    }

    public Author getAuthorById(int author_id){
        Query query = entityManager.createNativeQuery("getAuthorById", Author.class);
        query.setParameter(1, author_id);
        List resultList = query.getResultList();
        return (Author) resultList.get(0);
    }

    public List<Author> getAllAuthors(){
        Query query = entityManager.createNativeQuery("getAuthorById", Author.class);
        List<Author> resultList = query.getResultList();
        return resultList;
    }
}
