package it.discovery.spring.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("hits")
@Getter
@Setter
public class Hit {
    @Id
    private String id;

    private LocalDate createdAt;

    private int bookId;
}
