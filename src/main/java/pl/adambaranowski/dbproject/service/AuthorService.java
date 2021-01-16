package pl.adambaranowski.dbproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import pl.adambaranowski.dbproject.model.Author;

import java.util.List;

@Service
public class AuthorService {

    private static final String ADD_AUTHOR = "INSERT INTO authors (author_name) VALUE (?);";
    private static final String DELETE_AUTHOR_BY_ID = "DELETE FROM authors WHERE author_id=?;";
    private static final String DELETE_AUTHOR_BY_NAME = "DELETE FROM authors WHERE author_name=?;";
    private static final String GET_AUTHOR_BY_ID = "SELECT * FROM  authors WHERE author_id=? LIMIT 1;";
    private static final String GET_AUTHOR_BY_NAME = "SELECT * FROM authors WHERE author_name=? LIMIT 1;";
    private static final String GET_ALL_AUTHORS = "SELECT * FROM authors;";


    private JdbcTemplate template;
    private RowMapper rowMapper = BeanPropertyRowMapper.newInstance(Author.class);

    @Autowired
    public AuthorService(JdbcTemplate template) {
        this.template = template;
    }

    public void addAuthor(String author_name){
        template.update(ADD_AUTHOR, author_name);
    }

    public void deleteAuthorById(int author_id){
        template.update(DELETE_AUTHOR_BY_ID, author_id);
    }

    public void deleteAuthorByName(String author_name){
        template.update(DELETE_AUTHOR_BY_NAME, author_name);
    }

    public Author getAuthorByName(String author_name){
        List<Author> query = template.query(GET_AUTHOR_BY_NAME, rowMapper, author_name);
        return query.get(0);
    }

    public Author getAuthorById(int author_id){
        List<Author> query = template.query(GET_AUTHOR_BY_ID, rowMapper, author_id);
        return query.get(0);
    }

    public List<Author> getAllAuthors(){
        List<Author> query = template.query(GET_ALL_AUTHORS, rowMapper);
        return query;
    }
}
