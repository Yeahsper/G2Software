package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "staff")
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id", unique = true)
    private int staff_id;
    @Column(name = "first_name", nullable = false)
    private String first_name;
    @Column(name = "last_name", nullable = false)
    private String last_name;
    @Column(name = "picture", nullable = false)
    private Blob picture;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "active", nullable = false)
    private int active;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "last_update", nullable = false)
    private String last_update;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address_obj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store_obj;

    @Override
    public String toString() {
        return "Staff{" +
                "staff_id=" + staff_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address_id=" + address_obj.getAddress_id() +
//                ", picture=" + picture +
                ", email='" + email + '\'' +
                ", store_id=" + store_obj.getStore_id() +
                ", active=" + active +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", last_update='" + last_update + '\'' +
                '}';
    }

    //Constructor
    public Staff() {
    }

    //Getters
    public Address getAddress_obj() {
        return address_obj;
    }

    public Blob getPicture() {
        return picture;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public Store getStore_obj() {
        return store_obj;
    }

    public int getActive() {
        return active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLast_update() {
        return last_update;
    }

    //Setters
    public void setAddress_obj(Address address_obj) {
        this.address_obj = address_obj;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStore_obj(Store store_obj) {
        this.store_obj = store_obj;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    // Getters and Setters for GUI Controller
    public int getAddress_obj_id() { return address_obj.getAddress_id(); }

    public void setAddress_id(int new_id) { /* update id = new_id for THIS Object */ }

    public int getStore_obj_id() { return store_obj.getStore_id(); }

    public void setStore_id(int new_id) { /* update id = new_id for THIS Object */ }
}