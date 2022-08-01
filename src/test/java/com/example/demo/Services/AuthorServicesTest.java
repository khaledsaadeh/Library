package com.example.demo.Services;

import com.example.demo.Models.Author;
import com.example.demo.Repositories.AuthorRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class AuthorServicesTest {
    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private AuthorService authorService;

    @Test
    public void getAllAuthors_methodCalled_authorRepoGetAllCalled() {
        authorService.getAuthors();
        verify(authorRepository).findAll();
    }

    @Test
    public void getAuthorById_methodCalled_authorRepoGetAuthorByIdCalled() {
        Author author = new Author();

        authorService.getAuthorById(1L);
        verify(authorRepository).findById(1L);
    }

    @Test
    public void addNewAuthor_methodCalled_authorRepoSaveCalled() {
        Author author = new Author();
        author.setAge(24);
        author.setName("Khaled");

        authorService.addNewAuthor(author);
        verify(authorRepository).save(author);
    }

    @Test
    public void deleteAuthor_methodCalled_authorRepoDeleteCalled() {
        Author author = new Author();

        authorService.deleteAuthor(1L);
        verify(authorRepository).deleteById(1L);
    }

//    @Test
//    public void updateAuthor_methodCalled_authorUpdated() {
//        Author author = new Author();
//        author.setId(4L);
//        author.setAge(24);
//        author.setName("Khaled");
//
//        authorService.updateAuthor(4L, "Ahmad", 20);
//        Assertions.assertEquals("Ahmad", author.getName());
//    }
}