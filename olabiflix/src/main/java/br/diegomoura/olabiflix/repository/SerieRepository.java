package br.diegomoura.olabiflix.repository;

import br.diegomoura.olabiflix.model.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SerieRepository extends JpaRepository<Serie, UUID> {
}
