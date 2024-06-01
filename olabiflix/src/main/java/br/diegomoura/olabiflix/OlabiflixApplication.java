package br.diegomoura.olabiflix;

import br.diegomoura.olabiflix.model.entity.Serie;
import br.diegomoura.olabiflix.repository.SerieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class OlabiflixApplication {

	private final SerieRepository serieRepository;

    public OlabiflixApplication(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(OlabiflixApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(){
		return "Hello Olabi ;)";
	}

	@GetMapping("/series")
	public List<Serie> getSeries(){
		return serieRepository.findAll();
	}
}
