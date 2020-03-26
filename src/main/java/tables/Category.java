package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "category")
public class Category implements Serializable{
    private static final long serialVersionUID=1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="category_id",unique =true )
        private int category_id;
        @Column(name="name",nullable = false )
        private String name;
        @Column(name="last_update",nullable = false )
        private String last_update;

    @OneToMany(mappedBy = "category")
    private List<Film> film;

    public List<Film> getFilm() {
        return film;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                ", last_update='" + last_update + '\'' +
                ", film=" + film +
                '}';
    }

    public void setFilm(List<Film> film) {
        this.film = film;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getCategory_id() {
        return category_id;
    }
}
