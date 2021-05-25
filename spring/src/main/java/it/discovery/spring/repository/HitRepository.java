package it.discovery.spring.repository;

import it.discovery.spring.model.Hit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HitRepository extends MongoRepository<Hit, String> {
}
