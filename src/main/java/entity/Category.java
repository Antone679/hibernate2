package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;
    @Column(name = "name")
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;
    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"),
            inverseJoinColumns=@JoinColumn(name = "film_id",referencedColumnName = "film_id"))
    private Set<Film> films;

    public Category() {}

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
