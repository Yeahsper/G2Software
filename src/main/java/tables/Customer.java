package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name="customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="customer_id",unique = true)
    private int id;
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
    private Address address_OBJ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store_OBJ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Address getAddress_OBJ() {
        return address_OBJ;
    }

    public void setAddress_OBJ(Address address_OBJ) {
        this.address_OBJ = address_OBJ;
    }

    public Store getStore_OBJ() {
        return store_OBJ;
    }

    public void setStore_OBJ(Store store_OBJ) {
        this.store_OBJ = store_OBJ;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", create_date='" + create_date + '\'' +
                ", last_update='" + last_update + '\'' +
                ", address_OBJ=" + address_OBJ.getAddress() +
                ", store_OBJ=" + store_OBJ.getId() +
                '}';
    }
}
