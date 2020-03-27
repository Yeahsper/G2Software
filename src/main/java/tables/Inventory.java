package tables;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "inventory")
public class Inventory implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventory_id",unique =true )
    private int inventory_id;
    @Column(name="last_update",nullable = false )
    private String last_update;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private Film film_OBJ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store;

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventory_id +
                ", last_update='" + last_update + '\'' +
                ", film_OBJ=" + film_OBJ.getTitle() +
                ", store=" + store.getId() +
                '}';
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getLast_update() { return last_update; }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public Film getFilm_OBJ() {
        return film_OBJ;
    }

    public void setFilm_OBJ(Film film_OBJ) {
        this.film_OBJ = film_OBJ;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    // Getters and Setters for GUI Controller
    public int getStore_obj_id() { return store.getId(); }

    public void setStore_id(int new_id) { /* update id = new_id for THIS Object */ }

    public int getFilm_obj_id() {
        return film_OBJ.getFilm_id();
    }

    public void setFilm_id(int new_id) { /* update id = new_id for THIS Object */ }
}
