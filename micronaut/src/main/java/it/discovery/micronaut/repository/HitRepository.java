package it.discovery.micronaut.repository;

import it.discovery.micronaut.model.Hit;

import java.util.List;

public interface HitRepository {

    List<Hit> findAll();
}
