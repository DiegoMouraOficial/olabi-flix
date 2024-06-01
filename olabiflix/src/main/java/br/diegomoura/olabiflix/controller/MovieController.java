package br.diegomoura.olabiflix.controller;

import br.diegomoura.olabiflix.model.entity.Movie;
import br.diegomoura.olabiflix.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository repository;

    public MovieController(MovieRepository movieRepository) {
        this.repository = movieRepository;
    }

    @GetMapping()
    public List<Movie> getMovie(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getById(@PathVariable UUID id) {
        return repository.findById(id);
    }

    @GetMapping("/search-title")
    public ResponseEntity<Movie> findByTitle(@RequestParam(name = "title", defaultValue = "") String title) {
        Optional<Movie> findMovie = repository.findMoviesByTitle(title);

        if(findMovie.isPresent()) {
            Movie movie = findMovie.get();
            return ResponseEntity.ok(movie);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search-genre")
    public ResponseEntity<List<Movie>> findByGenre(@RequestParam(name = "genre", defaultValue = "") String genre){
        List<Movie> movies = repository.findByGenreContainsIgnoreCase(genre);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/search-actors")
    public ResponseEntity<List<Movie>> findByGenre(@RequestParam(name = "title", defaultValue = "") String title,
                                                   @RequestParam(name = "actors", defaultValue = "") String actor){
        List<Movie> actors = repository.findByTitleOrActors(title, actor);
        return ResponseEntity.ok(actors);
    }

    @PostMapping("/create")
    public Movie create(@RequestBody Movie movieBody) {
        return repository.save(movieBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovies(@PathVariable UUID id){
        repository.deleteById(id);
    }
}
