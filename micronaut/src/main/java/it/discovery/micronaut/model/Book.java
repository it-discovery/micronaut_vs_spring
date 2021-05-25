package it.discovery.micronaut.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table
@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private int year;
}
