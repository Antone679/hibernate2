package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmCategoryId implements Serializable {
    @Column(name = "film_id")
    private byte filmId;

    @Column(name = "category_id")
    private byte categoryId;

    public FilmCategoryId() {}

    public FilmCategoryId(byte filmId, byte categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    public byte getFilmId() {
        return filmId;
    }

    public void setFilmId(byte filmId) {
        this.filmId = filmId;
    }

    public byte getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(byte categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        FilmCategoryId that = (FilmCategoryId) object;
        return filmId == that.filmId && categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, categoryId);
    }
}