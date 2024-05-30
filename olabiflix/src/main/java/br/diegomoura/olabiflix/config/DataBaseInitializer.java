package br.diegomoura.olabiflix.config;

import br.diegomoura.olabiflix.model.entity.Movie;
import br.diegomoura.olabiflix.model.entity.Serie;
import br.diegomoura.olabiflix.model.value.Ratings;
import br.diegomoura.olabiflix.repository.MovieRepository;
import br.diegomoura.olabiflix.repository.SerieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataBaseInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataBaseInitializer.class);

    private final MovieRepository movieRepository;
    private final SerieRepository serieRepository;

    public DataBaseInitializer(MovieRepository movieRepository, SerieRepository serieRepository) {
        this.movieRepository = movieRepository;
        this.serieRepository = serieRepository;
    }

    public static final List<Movie> movies = List.of(
            new Movie("Movie 1", "2000", "PG-13", "01 Jan 2000", "120 min", "Action", "Director 1", "Writer 1", "Actor 1", "Plot 1", "English", "USA", "No awards"),
            new Movie("Movie 2", "2005", "R", "01 Jan 2005", "130 min", "Drama", "Director 2", "Writer 2", "Actor 2", "Plot 2", "Spanish", "Spain", "Oscar winner"),
            new Movie("Movie 3", "2010", "PG", "01 Jan 2010", "110 min", "Comedy", "Director 3", "Writer 3", "Actor 3", "Plot 3", "French", "France", "Golden Globe winner"),
            new Movie("Movie 4", "2015", "PG-13", "01 Jan 2015", "125 min", "Thriller", "Director 4", "Writer 4", "Actor 4", "Plot 4", "German", "Germany", "BAFTA winner"),
            new Movie("Movie 5", "2020", "R", "01 Jan 2020", "135 min", "Horror", "Director 5", "Writer 5", "Actor 5", "Plot 5", "Italian", "Italy", "Cannes Film Festival winner")
    );

    public static final List<Serie> series = List.of(
            new Serie(
                    "Serie 1",
                    List.of("Actor 1", "Actor 2"), "poster1.jpg",
                    List.of("Writer 1", "Writer 2"),
                    List.of("Genre 1", "Genre 2"), "5",
                    new Ratings("9.0", "1000")
            ),
            new Serie(
                    "Serie 2",
                    List.of("Actor 3", "Actor 4"), "poster2.jpg",
                    List.of("Writer 3", "Writer 4"),
                    List.of("Genre 3", "Genre 4"), "7",
                    new Ratings("8.5", "800")
            ),
            new Serie(
                    "Serie 3",
                    List.of("Actor 5", "Actor 6"), "poster3.jpg",
                    List.of("Writer 5", "Writer 6"),
                    List.of("Genre 5", "Genre 6"), "6",
                    new Ratings("9.2", "1200")
            ),
            new Serie(
                    "Serie 4",
                    List.of("Actor 7", "Actor 8"), "poster4.jpg",
                    List.of("Writer 7", "Writer 8"),
                    List.of("Genre 7", "Genre 8"), "8",
                    new Ratings("8.8", "900")
            ),
            new Serie(
                    "Serie 5",
                    List.of("Actor 9", "Actor 10"), "poster5.jpg",
                    List.of("Writer 9", "Writer 10"),
                    List.of("Genre 9", "Genre 10"), "4",
                    new Ratings("8.0", "700")
            )
    );

    @Override
    public void run(String... args) throws Exception {
        logger.info("Connected Database");
        System.out.println(" --------------------> Save All Movies <--------------------");
        movieRepository.saveAll(movies);
        logger.info("Successfully Entered Movies");
        System.out.println(" --------------------> Find All Movies <--------------------");
        movieRepository.findAll().forEach(movie -> System.out.println("Movie " + movie));
        System.out.println(" --------------------> Save All Series <--------------------");
        serieRepository.saveAll(series);
        logger.info("Successfully Entered Series");
        System.out.println(" --------------------> Find All Movies <--------------------");
        serieRepository.findAll().forEach(serie -> System.out.println("Movie " + serie));
    }
}
