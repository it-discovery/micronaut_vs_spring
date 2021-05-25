package it.disovery.spring.web;

import it.discovery.spring.MainApplication;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitWebConfig(MainApplication.class)
@AutoConfigureMockMvc
@Testcontainers
public class HitControllerTest {

    @Container
    static GenericContainer mongo = new
            GenericContainer<>("mongo:4")
            .withExposedPorts(27017);

    @Autowired
    MockMvc mockMvc;

    @DynamicPropertySource
    static void mongoProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.port",
                () -> mongo.getMappedPort(27017));
    }


    @Test
    @DisplayName("GET /hits Returns no hits")
    void findAll_repositoryEmpty_noHitsReturned()
            throws Exception {
        //Given
        //When
        ResultActions actions = mockMvc.perform(get("/hits"))
                .andDo(MockMvcResultHandlers.print());
        //Then
        actions.andExpect(status().isOk())
                .andExpect(content().contentType(
                        MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", Matchers.hasSize(0)));
    }

}
