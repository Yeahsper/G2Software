package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "film")
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", unique = true)
    private int film_id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "release_year", nullable = false)
    private String release_year;
    @Column(name = "rental_duration", nullable = false)
    private int rental_duration;
    @Column(name = "rental_rate", nullable = false)
    private double rental_rate;
    @Column(name = "length", nullable = false)
    private int length;
    @Column(name = "original_language_id", nullable = false)
    private int original_language_id;
    @Column(name = "original_language", nullable = false)
    private int original_language;
    @Column(name = "replacement_cost", nullable = false)
    private double replacement_cost;
    @Column(name = "rating", nullable = false)
    private String rating;
    @Column(name = "special_features", nullable = false)
    private String special_features;
    @Column(name = "last_update", nullable = false)
    private String last_update;

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language_obj;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name="film_category", joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name="category_id"))
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="film_actor", joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id"))
    private List<Actor> actorList;

    @Override
    public String toString() {
        return "Film{" +
                "film_id=" + film_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", release_year='" + release_year + '\'' +
                ", rental_duration=" + rental_duration +
                ", rental_rate=" + rental_rate +
                ", length=" + length +
                ", replacement_cost=" + replacement_cost +
                ", rating='" + rating + '\'' +
                ", special_features='" + special_features + '\'' +
                ", last_update='" + last_update + '\'' +
                ", language_obj=" + language_obj.getName() +
                ", original_language=" + original_language +
                ", category=" + category.getName() +
                ", actorList_size=" + actorList.size() +
                '}';
    }

    public int getOriginal_language_id() { return original_language_id; }

    public void setOriginal_language_id(int original_language_id) { this.original_language_id = original_language_id; }

    public int getOriginal_language() { return original_language; }

    public void setOriginal_language(int original_language) { this.original_language = original_language; }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
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

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public Language getLanguage_obj() {
        return language_obj;
    }

    public void setLanguage_obj(Language language_obj) {
        this.language_obj = language_obj;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    // Getters and Setters for GUI Controller
    public int getLanguage_obj_id() { return language_obj.getLanguage_id(); }

    public void setLanguage_id(int new_id) { /* update id = new_id for THIS Object */ }
}