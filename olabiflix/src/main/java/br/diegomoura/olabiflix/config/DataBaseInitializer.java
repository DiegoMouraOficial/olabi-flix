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
            new Serie("Game of Thrones", "8", List.of("Action", "Adventure", "Drama", "Fantasy", "Romance"), List.of("David Benioff", "D.B. Weiss"), "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_SX300.jpg", List.of("Peter Dinklage", "Lena Headey", "Emilia Clarke", "Kit Harington"), new Ratings("9.3", "1679892")),
            new Serie("Stranger Things", "3", List.of("Drama", "Fantasy", "Horror", "Mystery", "Sci-Fi", "Thriller"), List.of("Matt Duffer", "Ross Duffer"), "https://m.media-amazon.com/images/M/MV5BMjEzMDAxOTUyMV5BMl5BanBnXkFtZTgwNzAxMzYzOTE@._V1_SX300.jpg", List.of("Winona Ryder", "David Harbour", "Finn Wolfhard", "Millie Bobby Brown"), new Ratings("8.8", "769106")),
            new Serie("The Boys", "3", List.of("Action", "Comedy", "Crime", "Sci-Fi"), List.of("Eric Kripke"), "https://m.media-amazon.com/images/M/MV5BN2JjNmFjZmItMDVlMS00NzExLWJkOTMtY2U3ZDRiZGUyMTdhXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg", List.of("Karl Urban", "Jack Quaid", "Antony Starr", "Erin Moriarty"), new Ratings("8.7", "162770")),
            new Serie("This Is Us", "4", List.of("Comedy", "Drama", "Romance"), List.of("Dan Fogelman"), "https://m.media-amazon.com/images/M/MV5BMDM2YTMzMWMtNmFhZi00ZWY4LTk1ZmUtMWExNzg3NDZmMTY4XkEyXkFqcGdeQXVyMzQ2MDI5NjU@._V1_SX300.jpg", List.of("Milo Ventimiglia", "Mandy Moore", "Sterling K. Brown", "Chrissy Metz"), new Ratings("8.7", "94108")),
            new Serie("How to Get Away with Murder", "6", List.of("Crime", "Drama", "Mystery", "Thriller"), List.of("Peter Nowalk"), "https://m.media-amazon.com/images/M/MV5BZDQ5ZDRhMWItNjA5Ni00MDhiLTgwN2EtZjFkYzgzNjBhZTIyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg", List.of("Viola Davis", "Billy Brown", "Jack Falahee", "Aja Naomi King"), new Ratings("8.1", "120538")),
            new Serie("Little Fires Everywhere", "1", List.of("Drama"), List.of("Celeste Ng"), "https://m.media-amazon.com/images/M/MV5BNmEyZjc3MzgtZjU1OS00MDlkLThmOTMtODE5OTlmYmUxMTRmXkEyXkFqcGdeQXVyMTM1NjgyNDI@._V1_SX300.jpg", List.of("Kerry Washington", "Lexi Underwood", "Reese Witherspoon", "Joshua Jackson"), new Ratings("7.8", "19360")),
            new Serie("Lucifer", "5", List.of("Crime", "Drama", "Fantasy"), List.of("Tom Kapinos"), "https://m.media-amazon.com/images/M/MV5BNzY1YjIxOGMtOTAyZC00YTcyLWFhMzQtZTJkYTljYzU0MGRlXkEyXkFqcGdeQXVyMTAwMzM3NDI3._V1_SX300.jpg", List.of("Tom Ellis", "Lauren German", "Kevin Alejandro", "D.B. Woodside"), new Ratings("8.2", "211722")),
            new Serie("Anne with an E", "3", List.of("Drama"), List.of("Moira Walley-Beckett"), "https://m.media-amazon.com/images/M/MV5BNThmMzJlNzgtYmY5ZC00MDllLThmZTMtNTRiMjQwNmY0NmRhXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg", List.of("Amybeth McNulty", "Geraldine James", "R.H. Thomson", "Dalila Bela"), new Ratings("8.7", "30924")),
            new Serie("Breaking Bad", "5", List.of("Crime", "Drama", "Thriller"), List.of("Vince Gilligan"), "https://m.media-amazon.com/images/M/MV5BMTg4NjEyNjA1NF5BMl5BanBnXkFtZTgwOTU2Mjg3NDE@._V1_SX300.jpg", List.of("Bryan Cranston", "Aaron Paul", "Anna Gunn", "Betsy Brandt"), new Ratings("9.5", "1496588")),
            new Serie("Friends", "10", List.of("Comedy", "Romance"), List.of("David Crane", "Marta Kauffman"), "https://m.media-amazon.com/images/M/MV5BMjE0NjY3MjY4Ml5BMl5BanBnXkFtZTgwNjUyNzY3NTM@._V1_SX300.jpg", List.of("Jennifer Aniston", "Courteney Cox", "Lisa Kudrow", "Matt LeBlanc"), new Ratings("8.9", "873458")),
            new Serie("Sherlock", "4", List.of("Crime", "Drama", "Mystery", "Thriller"), List.of("Mark Gatiss", "Steven Moffat"), "https://m.media-amazon.com/images/M/MV5BMTUyMTA5ODQwMl5BMl5BanBnXkFtZTcwOTc4NDQ5Mw@@._V1_SX300.jpg", List.of("Benedict Cumberbatch", "Martin Freeman", "Una Stubbs", "Rupert Graves"), new Ratings("9.1", "884329"))
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
