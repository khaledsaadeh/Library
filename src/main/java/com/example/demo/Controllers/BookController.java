package com.example.demo.Controllers;

import com.example.demo.Models.Author;
import com.example.demo.Models.Book;
import com.example.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/all")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/get/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping(path = "/add")
    public void addNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @PutMapping(path = "/update/{id}")
    public void updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @GetMapping(path = "/get/{author}")
    public List<Book> findBooksByAuthorName(@PathVariable("author") String byAuthor) {
        return bookService.findBooksByAuthorName(byAuthor);
    }
    @GetMapping(path = "unpublished/{flag}")
    public List<Book> findPublished(@PathVariable("flag") boolean flag){
        return bookService.findPublishedBooks(flag);
    }
}