package it.discovery.micronaut.bootstrap;

import io.micronaut.context.annotation.Context;
import it.discovery.micronaut.model.Book;
import it.discovery.micronaut.repository.BookRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

//@Singleton
@Context
public class ApplicationRunner {

    @Inject
    private BookRepository bookRepository;

    @PostConstruct
    public void init() {
        Book book = new Book();
        book.setTitle("Micronaut vs Spring Boot");
        book.setYear(2021);
        bookRepository.save(book);
    }

//    @EventListener
//    public void onStartup(ServerStartupEvent event) {
//        Book book = new Book();
//        book.setTitle("Micronaut vs Spring Boot");
//        book.setYear(2021);
//        bookRepository.save(book);
//    }
}
