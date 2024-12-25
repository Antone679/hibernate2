package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class FilmActorId {
    @Column(name = "actor_id")
    private short actorId;

    @Column(name = "film_id")
    private short filmId;

    public FilmActorId() {}

    public FilmActorId(short actorId, short filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    public short getActorId() {
        return actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        FilmActorId that = (FilmActorId) object;
        return Objects.equals(actorId, that.actorId) && Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }
}
