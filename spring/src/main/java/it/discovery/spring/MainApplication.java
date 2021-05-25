package it.discovery.spring;

import it.discovery.spring.model.Book;
import it.discovery.spring.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Component
    @RequiredArgsConstructor
    public class AppInitializer implements ApplicationRunner {

        private final BookRepository bookRepository;

        @Override
        public void run(ApplicationArguments args) throws Exception {
            Book book = new Book();
            book.setTitle("Micronaut vs Spring Boot");
            book.setYear(2021);
            bookRepository.save(book);
        }
    }
}
