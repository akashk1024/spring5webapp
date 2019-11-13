package com.spring.spring5webapp.bootstrap;

import com.spring.spring5webapp.model.Author;
import com.spring.spring5webapp.model.Book;
import com.spring.spring5webapp.model.Publisher;
import com.spring.spring5webapp.repositories.AuthorRepository;
import com.spring.spring5webapp.repositories.BookRepository;
import com.spring.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    public void init(){
        Author rowling = new Author("JK","Rowling");
        Publisher british = new Publisher("Bloomsbury Publishing","British");
        Book potter = new Book("Harry Potter","1234",british);
        rowling.getBooks().add(potter);
        potter.getAuthors().add(rowling);
        authorRepository.save(rowling);
        publisherRepository.save(british);
        bookRepository.save(potter);

        Author robin = new Author("Robin","Sharma");
        Publisher indian = new Publisher("Morning Sun","India");
        Book monk = new Book("The Monk","2345",indian);
        robin.getBooks().add(monk);
        authorRepository.save(robin);
        publisherRepository.save(indian);
        bookRepository.save(monk);
    }
}
