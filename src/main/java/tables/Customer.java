package tables;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="customer_id",unique = true)
    private int customer_id;
    @Column(name="first_name", nullable = false)
    private String first_name;
    @Column(name="last_name", nullable = false)
    private String last_name;
    @Column(name="email")
    private String email;
    @Column(name="active")
    private int active;
    @Column(name="create_date")
    private String create_date;
    @Column(name="last_update")
    private String last_update;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address_obj;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store_obj;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", create_date='" + create_date + '\'' +
                ", last_update='" + last_update + '\'' +
                ", address_obj=" + address_obj +
//                ", store=" + store.toString() +
                '}';
    }

    public Address getAddress_obj() {
        return address_obj;
    }

    public void setAddress_obj(Address address_obj) {
        this.address_obj = address_obj;
    }

    public Address getAddress() { return address_obj; }

    public void setAddress(Address address) { this.address_obj = address; }

    public int getCustomer_id() { return customer_id; }

    public void setCustomer_id(int id) {
        this.customer_id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public Store getStore_obj() {
        return store_obj;
    }

    public void setStore_obj(Store store_obj) {
        this.store_obj = store_obj;
    }

    // Getters and Setters for GUI Controller
    public int getStore_obj_id() { return store_obj.getStore_id(); }

    public void setStore_id(int new_id) { /* update id = new_id for THIS Object */ }

    public int getAddress_obj_id() {
        return address_obj.getAddress_id();
    }

    public void setAddress_id(int new_id) { /* update id = new_id for THIS Object */ }
}
