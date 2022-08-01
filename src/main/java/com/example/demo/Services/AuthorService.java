package com.example.demo.Services;

import com.example.demo.Models.Author;
import com.example.demo.Models.Book;
import com.example.demo.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        boolean found = authorRepository.existsById(id);
        if (!found) {
            throw new IllegalStateException("Author not found");
        }
        authorRepository.deleteById(id);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new IllegalStateException("Author not found"));
    }

    @Transactional
    public void updateAuthor(Long id, Author newAuthor ) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new IllegalStateException("Author not found"));
        if (newAuthor.getName()!= null && newAuthor.getName() != author.getName()) {
            author.setName(newAuthor.getName());
        }
        if (newAuthor.getAge() > 0 && author.getAge() != newAuthor.getAge()) {
            author.setAge(newAuthor.getAge());
        }
    }
}