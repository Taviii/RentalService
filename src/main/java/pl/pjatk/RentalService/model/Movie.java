package pl.pjatk.RentalService.model;

import java.util.Objects;

public class Movie {

    private Long id;
    private String name;
    private Category category;
    private int rating;
    private boolean isAvailable;

    public Movie(Long id, String name, Category category, int rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
    }

    public Movie(Long id, String name, Category category, int rating, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.isAvailable = isAvailable;
    }

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", rating=" + rating +
                ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, rating, isAvailable);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Movie movie = (Movie) object;
        return isAvailable == movie.isAvailable
                && Objects.equals(id, movie.id)
                && Objects.equals(name, movie.name)
                && category == movie.category
                && Objects.equals(rating, movie.rating);
    }
}
