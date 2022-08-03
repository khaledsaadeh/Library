package com.example.demo.Services;

import com.example.demo.Models.Author;
import com.example.demo.Models.Book;
import com.example.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void updateBook(Long id, Book newBook) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("Book not found"));
        if (newBook.getName() != null && book.getName() != newBook.getName()) {
            book.setName(newBook.getName());
        }
        if (newBook.getPublishYear() != null && book.getPublishYear() != newBook.getPublishYear()) {
            book.setPublishYear(newBook.getPublishYear());
        }
        book.setPublished(newBook.isPublished());
        book.setAuthor(newBook.getAuthor());
        book.setQuantity(newBook.getQuantity());
    }

    public List<Book> findBooksByAuthorName(String name) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : foundBooks) {
            if (book.getAuthor().getName().equals(name)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> findPublishedBooks(boolean Unpublished) {
        List<Book> books = bookRepository.findAll();
        if (Unpublished == true) {
            return books;
        }
        List<Book> publishedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isPublished()) {
                publishedBooks.add(book);
            }
        }
        return publishedBooks;
    }
}