package tables;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "staff_id", unique = true)
    private int staff_id;
    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "address_id", unique = true, nullable = false)
    private int address_id;

    @Column(name = "picture")
    private Blob picture;

    @Column(name = "email")
    private String email;

    @Column(name = "store_id", unique = true, nullable = false)
    private int store_id;

    @Column(name = "active", unique = true, nullable = false)
    private int active;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password")
    private String password;


    @Column(name = "last_update", nullable = false)
    private String last_update;


    public int getStaff_id() {
        return staff_id;
    }


    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
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


    public int getAddress_id() {
        return address_id;
    }


    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }


    public Blob getPicture() {
        return picture;
    }


    public void setPicture(Blob picture) {
        this.picture = picture;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public int getStore_id() {
        return store_id;
    }


    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }


    public int getActive() {
        return active;
    }


    public void setActive(int active) {
        this.active = active;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getLast_update() {
        return last_update;
    }


    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }















}
