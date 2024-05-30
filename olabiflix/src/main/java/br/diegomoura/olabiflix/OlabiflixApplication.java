package br.diegomoura.olabiflix;

import br.diegomoura.olabiflix.model.entity.Movie;
import br.diegomoura.olabiflix.repository.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class OlabiflixApplication {

	private final MovieRepository repository;

    public OlabiflixApplication(MovieRepository repository) {
        this.repository = repository;
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
		return repository.findAll();
	}
}
