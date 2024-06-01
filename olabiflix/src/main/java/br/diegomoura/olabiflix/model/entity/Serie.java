package br.diegomoura.olabiflix.model.entity;

import br.diegomoura.olabiflix.model.value.Ratings;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="serie")
public class Serie {

    @Id
    @UuidGenerator
    private UUID id;

    private String title;
    private String totalSeasons;
    private List<String> genre;
    private List<String> writers;
    private String poster;
    private List<String> actors;

    @Embedded
    private Ratings ratings;

    //region ...Constructor
    public Serie(){}

    public Serie(String title, String totalSeasons,  List<String> genre, List<String> writers, String poster, List<String> actors, Ratings ratings) {
        this.title = title;
        this.actors = actors;
        this.poster = poster;
        this.writers = writers;
        this.genre = genre;
        this.totalSeasons = totalSeasons;
        this.ratings = ratings;
    }
//endregion

    //region ...Getter and Setter
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public String getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(String totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }
//endregion

    //region ...toString

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", totalSeasons='" + totalSeasons + '\'' +
                ", genre=" + genre +
                ", writers=" + writers +
                ", poster='" + poster + '\'' +
                ", actors=" + actors +
                ", ratings=" + ratings +
                '}';
    }
    //endregion
}
