package br.diegomoura.olabiflix;

import br.diegomoura.olabiflix.model.entity.Movie;
import br.diegomoura.olabiflix.model.entity.Serie;
import br.diegomoura.olabiflix.repository.MovieRepository;
import br.diegomoura.olabiflix.repository.SerieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class OlabiflixApplication {

	private final MovieRepository movieRepository;
	private final SerieRepository serieRepository;

    public OlabiflixApplication(MovieRepository movieRepository, SerieRepository serieRepository) {
        this.movieRepository = movieRepository;
		this.serieRepository = serieRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(OlabiflixApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(){
		return "Hello Olabi ;)";
	}

	@GetMapping("/movies")
	public List<Movie> getMovies(){
		return movieRepository.findAll();
	}

	@PostMapping("/movies/create")
	public Movie create(@RequestBody Movie movieBody) {
		return movieRepository.save(movieBody);
	}

	@GetMapping("/series")
	public List<Serie> getSeries(){
		return serieRepository.findAll();
	}
}
