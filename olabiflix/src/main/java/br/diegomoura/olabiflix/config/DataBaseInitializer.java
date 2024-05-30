package br.diegomoura.olabiflix.config;

import br.diegomoura.olabiflix.model.entity.Movie;
import br.diegomoura.olabiflix.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataBaseInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataBaseInitializer.class);

    private final MovieRepository movieRepository;

    public DataBaseInitializer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public static final List<Movie> movies = List.of(
            new Movie("Movie 1", "2000", "PG-13", "01 Jan 2000", "120 min", "Action", "Director 1", "Writer 1", "Actor 1", "Plot 1", "English", "USA", "No awards"),
            new Movie("Movie 2", "2005", "R", "01 Jan 2005", "130 min", "Drama", "Director 2", "Writer 2", "Actor 2", "Plot 2", "Spanish", "Spain", "Oscar winner"),
            new Movie("Movie 3", "2010", "PG", "01 Jan 2010", "110 min", "Comedy", "Director 3", "Writer 3", "Actor 3", "Plot 3", "French", "France", "Golden Globe winner"),
            new Movie("Movie 4", "2015", "PG-13", "01 Jan 2015", "125 min", "Thriller", "Director 4", "Writer 4", "Actor 4", "Plot 4", "German", "Germany", "BAFTA winner"),
            new Movie("Movie 5", "2020", "R", "01 Jan 2020", "135 min", "Horror", "Director 5", "Writer 5", "Actor 5", "Plot 5", "Italian", "Italy", "Cannes Film Festival winner")
    );

    @Override
    public void run(String... args) throws Exception {
        logger.info("Connected Database");
        System.out.println(" --------------------> Save All Movies <--------------------");
        movieRepository.saveAll(movies);
        logger.info("Successfully Entered Films {}", movies);
        System.out.println(" --------------------> Find All Movies <--------------------");
        movieRepository.findAll().forEach(movie -> System.out.println("Movie " + movie));
    }
}
