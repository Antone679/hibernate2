package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

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
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<FilmCategory> filmCategories;

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

    public List<FilmCategory> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(List<FilmCategory> filmCategories) {
        this.filmCategories = filmCategories;
    }

}
