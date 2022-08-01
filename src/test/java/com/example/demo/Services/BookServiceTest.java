package com.example.demo.Services;

import com.example.demo.Models.Author;
import com.example.demo.Models.Book;
import com.example.demo.Repositories.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class BookServiceTest {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookService bookService;

    @Test
    public void getAllBooks_methodCalled_bookRepoGetAllCalled() {
        bookService.getBooks();
        verify(bookRepository).findAll();
    }

    @Test
    public void getBookById_methodCalled_bookRepoGetBookByIdCalled() {
        Book book = new Book();

        bookService.getBookById(1L);
        verify(bookRepository).findById(1L);
    }

    @Test
    public void addNewBook_methodCalled_bookRepoSaveCalled() {
        Book book = new Book();

        bookService.addNewBook(book);
        verify(bookRepository).save(book);
    }

    @Test
    public void deleteBook_methodCalled_bookRepoDeleteBookCalled() {
        Book book = new Book();

        bookService.deleteBook(1L);
        verify(bookRepository).deleteById(1L);
    }

    @Test
    public void updateBook_methodCalled_bookUpdated() {
        Book book = new Book();
        book.setName("Book One");
        book.setPublishYear("2000");

        bookService.updateBook(1L, "Book Update", "2001", new Author());
        Assertions.assertEquals("Book Update", book.getName());
    }
}