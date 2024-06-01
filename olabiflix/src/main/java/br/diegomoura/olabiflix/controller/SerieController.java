package br.diegomoura.olabiflix.controller;

import br.diegomoura.olabiflix.model.entity.Serie;
import br.diegomoura.olabiflix.repository.SerieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieRepository serieRepository;

    public SerieController(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @GetMapping()
    public List<Serie> getSeries(){
        return serieRepository.findAll();
    }
}
