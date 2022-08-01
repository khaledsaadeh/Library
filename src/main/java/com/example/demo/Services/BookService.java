package com.example.demo.Services;

import com.example.demo.Models.Author;
import com.example.demo.Models.Book;
import com.example.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("Book not found"));
    }

    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        boolean found = bookRepository.existsById(id);
        if (!found) {
            throw new IllegalStateException("Book not found");
        }
        bookRepository.deleteById(id);
    }

    public void updateBook(Long id, String name, String publishYear, Author author) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("Book not found"));
        if (name != null && book.getName() != name) {
            book.setName(name);
        }
        if (publishYear != null && book.getPublishYear() != publishYear) {
            book.setPublishYear(publishYear);
        }
        book.setAuthor(author);
    }
}