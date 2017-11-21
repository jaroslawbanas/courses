package com.jb.spring5webapp.bootsrap;

import com.jb.spring5webapp.model.Author;
import com.jb.spring5webapp.model.Book;
import com.jb.spring5webapp.model.Publisher;
import com.jb.spring5webapp.repositories.AuthorRepository;
import com.jb.spring5webapp.repositories.BookRepository;
import com.jb.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDB();
    }

    private void initDB() {
        Publisher publisher = Publisher.of("Tom", "UK");

        publisherRepository.save(publisher);
        createDDDBook(publisher);
        createNoEJBBook(publisher);
    }

    private void createNoEJBBook(Publisher publisher) {
        Author rod = Author.of("Rod", "Johnson");
        Book noEJB = Book.of("J2EE Development without EJB", "00002", publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

    private void createDDDBook(Publisher publisher) {
        Author eric = Author.of("Eric", "Evans");
        Book ddd = Book.of("DDD", "00001", publisher);
        eric.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
    }

}
