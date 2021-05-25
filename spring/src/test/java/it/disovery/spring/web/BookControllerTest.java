package it.disovery.spring.web;

import it.discovery.spring.MainApplication;
import it.discovery.spring.model.Book;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitWebConfig(MainApplication.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JacksonTester<Book> bookTester;

    @Test
    @DisplayName("GET /books Returns no books")
    @Order(1)
    void findAll_repositoryEmpty_noBooksReturned()
            throws Exception {
        //Given
        //When
        ResultActions actions = mockMvc.perform(get("/books"))
                .andDo(MockMvcResultHandlers.print());
        //Then
        actions.andExpect(status().isOk())
                .andExpect(content().contentType(
                        MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", Matchers.hasSize(0)));
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
        ResultActions resultActions = mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(bookTester.write(book).getJson()));

        //Then
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.title", Matchers.equalTo("Spring Boot 2")));
    }


}
