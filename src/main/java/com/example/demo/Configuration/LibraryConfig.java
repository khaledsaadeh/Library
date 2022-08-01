package com.example.demo.Configuration;

import com.example.demo.Models.Author;
import com.example.demo.Models.Book;
import com.example.demo.Models.Person;
import com.example.demo.Repositories.AuthorRepository;
import com.example.demo.Repositories.BookRepository;
import com.example.demo.Repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository, BookRepository bookRepository, AuthorRepository authorRepository){
        return args -> {
            Person person = new Person();
            person.setName("Khaled");
            personRepository.save(person);

            Author author = new Author();
            author.setName("Ahmad");
            author.setAge(24);
            authorRepository.save(author);

            Book book = new Book();
            book.setName("First book");
            book.setPublishYear("2022");
            bookRepository.save(book);
            book.setAuthor(author);
            bookRepository.save(book);
        };
    }
}