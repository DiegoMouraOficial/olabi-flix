package br.diegomoura.olabiflix.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    // Rename 'year' to 'releaseYear'
    @Column(name = "release_year")
    private String releaseYear;

    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;

    //region ...Constructor
    public Movie(){};

    public Movie(String awards, String country, String language, String plot, String actors, String writer, String director, String genre, String runtime, String released, String rated, String releaseYear, String title) {
        this.awards = awards;
        this.country = country;
        this.language = language;
        this.plot = plot;
        this.actors = actors;
        this.writer = writer;
        this.director = director;
        this.genre = genre;
        this.runtime = runtime;
        this.released = released;
        this.rated = rated;
        this.releaseYear = releaseYear;
        this.title = title;
    }
    //endregion

    //region ...Getter and Setter
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    // endregion
}
