package br.diegomoura.olabiflix.controller;

import br.diegomoura.olabiflix.model.entity.Movie;
import br.diegomoura.olabiflix.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    public MovieController(MovieRepository movieRepository) {
        this.repository = movieRepository;
    }

    @GetMapping()
    public List<Movie> getMovie() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getById(@PathVariable UUID id) {
        return repository.findById(id);
    }

    @GetMapping("/search-title")
    public ResponseEntity<Movie> findByTitle(@RequestParam(name = "title", defaultValue = "") String title) {
        Optional<Movie> findMovie = repository.findMoviesByTitle(title);

        if (findMovie.isPresent()) {
            Movie movie = findMovie.get();
            return ResponseEntity.ok(movie);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search-genre")
    public ResponseEntity<List<Movie>> findByGenre(@RequestParam(name = "genre", defaultValue = "") String genre) {
        List<Movie> movies = repository.findByGenreContainsIgnoreCase(genre);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/search-actors")
    public ResponseEntity<List<Movie>> findByGenre(@RequestParam(name = "title", defaultValue = "") String title,
                                                   @RequestParam(name = "actors", defaultValue = "") String actor) {
        List<Movie> actors = repository.findByTitleOrActors(title, actor);
        return ResponseEntity.ok(actors);
    }

    @PostMapping("/create")
    public Movie create(@RequestBody Movie movieBody) {
        return repository.save(movieBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovies(@PathVariable UUID id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> putMovies(@PathVariable UUID id, @RequestBody Movie movieBody) {
        Optional<Movie> foundMovie = repository.findById(id);

        if (foundMovie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Movie movie = foundMovie.get();

        movie.setTitle(movieBody.getTitle());
        movie.setActors(movieBody.getActors());
        movie.setAwards(movieBody.getAwards());
        movie.setCountry(movie.getCountry());
        movie.setReleaseYear(movie.getReleaseYear());
        movie.setGenre(movie.getGenre());
        movie.setRated(movie.getRated());
        movie.setPlot(movie.getPlot());
        movie.setReleased(movie.getReleased());
        movie.setRuntime(movie.getRuntime());
        movie.setWriter(movie.getWriter());
        movie.setLanguage(movie.getLanguage());
        movie.setCountry(movie.getCountry());

        Movie movieUpdate = repository.save(movie);

        return ResponseEntity.ok(movieUpdate);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Movie> patchMovies(@PathVariable UUID id, @RequestBody Map<String, String > requestBody) throws IllegalAccessException {
        Optional<Movie> foundMovie = repository.findById(id);

        if (foundMovie.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Movie movie = foundMovie.get();

        List<Field> fieldsModel = List.of(movie.getClass().getDeclaredFields());

        for(Field field : fieldsModel ) {
            field.setAccessible(true);

            String nameField = field.getName();

            if(requestBody.containsKey(nameField)) {
                String updateRequest = requestBody.get(nameField);
                field.set(movie, updateRequest);
            }
        }
        repository.save(movie);
        return ResponseEntity.ok(movie);
    }
}
