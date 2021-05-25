package it.discovery.micronaut.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Hit {
    private String id;

    private LocalDate createdAt;

    private int bookId;
}
