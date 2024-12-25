package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
@Table(name = "film_actor")
public class FilmActor {

    @EmbeddedId
    private FilmActorId id;

    @ManyToOne()
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    private Actor actor;
    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    private Film film;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastUpdate;

    public FilmActor() {}

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}
