package tables;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "rental")
public class Rental implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", unique = true)
    private int rental_id;

    @Column(name = "rental_date", nullable = false)
    private String rental_date;

    @Column(name = "return_date", nullable = false)
    private String return_date;

    @Column(name = "last_update", nullable = false)
    private String last_update;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory_obj;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_obj;

    @OneToOne
    @JoinColumn(name = "staff_id")
    private Staff staff_obj;

    //Constructor
    public Rental() {
    }

    //Getters

    public int getRental_id() {
        return rental_id;
    }

    public String getRental_date() {
        return rental_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public String getLast_update() {
        return last_update;
    }

    public Inventory getInventory_obj() {
        return inventory_obj;
    }

    public Customer getCustomer_obj() {
        return customer_obj;
    }

    public Staff getStaff_obj() {
        return staff_obj;
    }

    //Setters

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public void setRental_date(String rental_date) {
        this.rental_date = rental_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public void setInventory_obj(Inventory inventory_obj) {
        this.inventory_obj = inventory_obj;
    }

    public void setCustomer_obj(Customer customer_obj) {
        this.customer_obj = customer_obj;
    }

    public void setStaff_obj(Staff staff_obj) {
        this.staff_obj = staff_obj;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rental_id=" + rental_id +
                ", rental_date='" + rental_date + '\'' +
                ", return_date='" + return_date + '\'' +
                ", last_update='" + last_update + '\'' +
                ", inventory_id=" + inventory_obj.getInventory_id() +
                ", customer_id=" + customer_obj.getFirst_name() +
                ", staff_id=" + staff_obj.getFirst_name() +
                '}';
    }
}