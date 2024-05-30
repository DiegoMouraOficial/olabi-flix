package br.diegomoura.olabiflix.repository;

import br.diegomoura.olabiflix.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    //TODO - Define Methods for Generating Query
}
