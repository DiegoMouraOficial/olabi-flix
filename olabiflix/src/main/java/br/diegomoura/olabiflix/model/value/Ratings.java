package br.diegomoura.olabiflix.model.value;

import jakarta.persistence.Embeddable;

@Embeddable
public class Ratings {

    private String rating;
    private String likes;

    //region ...Constructor
    public Ratings(){}

    public Ratings(String rating, String likes) {
        this.rating = rating;
        this.likes = likes;
    }

    //endregion

    //region ...Getter and Setter
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
    //endregion

    //region ...toString
    @Override
    public String toString() {
        return "Ratings{" +
                "rating='" + rating + '\'' +
                ", likes='" + likes + '\'' +
                '}';
    }
    //endregion
}
