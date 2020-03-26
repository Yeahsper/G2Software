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
                ", store=" + store.getId() +
                '}';
    }

        public Film getFilm_OBJ() {
        return film_OBJ;
    }

    public void setFilm_OBJ(Film film_OBJ) {
        this.film_OBJ = film_OBJ;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getLast_update() {
        return last_update;
    }

    public int getInventory_id() {
        return inventory_id;
    }
}
