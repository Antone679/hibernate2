package entity;

import config.RatingConverter;
import config.SpecialFeatureConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private short id;
    @Column(name = "title")
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "release_year")
    private Integer releaseYear;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;
    @Column(name = "rental_duration")
    private byte rentalDuration;
    @Column(name = "rental_rate", precision = 4, scale = 2)
    private BigDecimal rentalRate;
    @Column(name = "length")
    private short length;
    @Column(name = "replacement_cost", scale = 5, precision = 2)
    private BigDecimal replacementCost;

    @Convert(converter = RatingConverter.class) // Используем конвертер
    @Column(name = "rating", columnDefinition = "ENUM('G', 'PG', 'PG-13', 'R', 'NC-17')")
    private Rating rating;
    @OneToMany(mappedBy = "film")
    private List<Inventory> inventories;

    @Convert(converter = SpecialFeatureConverter.class)
    @Column(name = "special_features")
    private Set<SpecialFeature> specialFeatures;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;
    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns=@JoinColumn(name = "actor_id",referencedColumnName = "actor_id"))
    private Set<Actor> actors;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns=@JoinColumn(name = "category_id",referencedColumnName = "category_id"))
    private Set<Category> categories;

    public Film() {}

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
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

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public byte getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Set<SpecialFeature> getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(Set<SpecialFeature> specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
