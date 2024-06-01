package br.diegomoura.olabiflix.repository;

import br.diegomoura.olabiflix.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

    Optional<Movie> findMoviesByTitle(String title);

    List<Movie> findByGenreContainsIgnoreCase(String genre);

    List<Movie> findByTitleOrActors(String title, String actors);
}
