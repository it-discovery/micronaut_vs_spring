package it.disovery.spring.web;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import it.discovery.micronaut.model.Book;
import org.junit.jupiter.api.*;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    @DisplayName("GET /books Returns no books")
    @Order(1)
    void findAll_repositoryEmpty_noBooksReturned()
            throws Exception {
        //Given
        //When
        HttpResponse<Book> response = client.toBlocking().exchange("/books", Book.class);
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON_TYPE, response.getContentType().orElse(null));
    }

    @Test
    @DisplayName("GET /books Successfully save a book")
    @Order(2)
    void saveBook_validBook_BookIsReturned() throws Exception {
        //Given
        Book book = new Book();
        book.setTitle("Spring Boot 2");
        book.setYear(2021);
        //When
//        ResultActions resultActions = mockMvc.perform(post("/books")
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(bookTester.write(book).getJson()));
//
//        //Then
//        resultActions.andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(jsonPath("$.title", Matchers.equalTo("Spring Boot 2")));
    }


}
