package it.discovery.micronaut.web;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import it.discovery.micronaut.model.Book;
import it.discovery.micronaut.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @Get
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Get("/{id}")
    public HttpResponse<Book> findById(@PathVariable int id) {
        return bookRepository.findById(id).map(HttpResponse::ok).orElse(HttpResponse.notFound());
    }

    @Post
    public Book save(@Body Book book) {
        return bookRepository.save(book);
    }
}
