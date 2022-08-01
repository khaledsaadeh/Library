package com.example.demo.Controllers;

import com.example.demo.Models.Author;
import com.example.demo.Models.Book;
import com.example.demo.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/authors")
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "/all")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping(path = "/get/{id}")
    public Author getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping(path = "/add")
    public void addNewAuthor(@RequestBody Author author) {
        authorService.addNewAuthor(author);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
    }

    @PutMapping(path = "/update/{id}")
    public void updateAuthor(@PathVariable("id") Long id, @RequestBody Author author) {
        authorService.updateAuthor(id, author);
    }
}
