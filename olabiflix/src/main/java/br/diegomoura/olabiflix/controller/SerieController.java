package br.diegomoura.olabiflix.controller;

import br.diegomoura.olabiflix.model.entity.Serie;
import br.diegomoura.olabiflix.repository.SerieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieRepository repository;

    public SerieController(SerieRepository serieRepository) {
        this.repository = serieRepository;
    }

    @GetMapping()
    public List<Serie> getSeries(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Serie> getById(@PathVariable UUID id) {
        return repository.findById(id);
    }

    @PostMapping("/create")
    public Serie create(@RequestBody Serie serieBody) {
        return repository.save(serieBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serie> putSeries(@PathVariable UUID id, @RequestBody Serie serieBody) {
            Optional<Serie> foundSerie = repository.findById(id);

            if(foundSerie.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Serie serie = foundSerie.get();

            serie.setTitle(serie.getTitle());
            serie.setTotalSeasons(serie.getTotalSeasons());
            serie.setGenre(serie.getGenre());
            serie.setWriters(serie.getWriters());
            serie.setPoster(serie.getPoster());
            serie.setActors(serie.getActors());
            serie.setRatings(serie.getRatings());

            Serie serieUpdate = repository.save(serie);

            return ResponseEntity.ok(serieUpdate);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Serie> patchSeries(@PathVariable UUID id, @RequestBody Map<String, String> requestBody) throws IllegalAccessException {
        Optional<Serie> foundSerie = repository.findById(id);

        if(foundSerie.isEmpty()) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Serie serie = foundSerie.get();

        List<Field> fieldsModel = List.of(serie.getClass().getFields());

        for(Field field : fieldsModel){
            field.setAccessible(true);

            String nameField = field.getName();

            if(requestBody.containsKey(nameField)) {
                String updateRequest = requestBody.get(nameField);
                field.set(serie, updateRequest);
            }
        }
        repository.save(serie);
        return ResponseEntity.ok(serie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSeries(@PathVariable UUID id) {
        repository.deleteById(id);
    }
}
