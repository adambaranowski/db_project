package pl.adambaranowski.dbproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.adambaranowski.dbproject.model.Author;
import pl.adambaranowski.dbproject.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping()
    public ResponseEntity<Object> createNewAuthor(@RequestParam String author_name){
        authorService.addAuthor(author_name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/author-id/{author_id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer author_id){
        Author authorById = authorService.getAuthorById(author_id);
        return new ResponseEntity<>(authorById, HttpStatus.OK);
    }

    @GetMapping("/author-name/{author_name}")
    public ResponseEntity<Author> getAuthorByName(@PathVariable String author_name){
        Author authorByName = authorService.getAuthorByName(author_name);
        return new ResponseEntity<>(authorByName, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> allAuthors = authorService.getAllAuthors();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }

    @DeleteMapping("/author-id/{author_id}")
    public ResponseEntity<Object> deleteAuthorById(@PathVariable Integer author_id){
        authorService.deleteAuthorById(author_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/author-name/{author_name}")
    public ResponseEntity<Object> deleteAuthorByName(@PathVariable String author_name){
        authorService.deleteAuthorByName(author_name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
