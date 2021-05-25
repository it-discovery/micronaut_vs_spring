package it.discovery.micronaut.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import it.discovery.micronaut.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
