package it.discovery.micronaut.web;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import it.discovery.micronaut.model.Hit;
import it.discovery.micronaut.repository.HitRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Controller("hits")
@RequiredArgsConstructor
public class HitController {

    private final HitRepository hitRepository;

    @Get
    public List<Hit> findAll() {
        return hitRepository.findAll();
    }

}
