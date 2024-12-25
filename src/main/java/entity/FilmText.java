package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "film_text")
public class FilmText {
    @Id
    @Column(name = "film_id")
    private short id;
    @OneToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
    private Film film;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public FilmText() {}

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
