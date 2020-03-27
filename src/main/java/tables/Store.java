package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="store")
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="store_id",unique = true)
    private int id;
    @Column(name="last_update", nullable = false)
    private String last_update;

    // Connects customers to store
    @OneToMany(mappedBy = "store")
    private List<Customer> customerList = new ArrayList<>();

    // Connects store to address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address_obj;

    @OneToOne(mappedBy="staff_id")
    private Staff staff_obj;


    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", customerList=" + customerList +
                ", address_obj=" + address_obj +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Address getAddress_obj() {
        return address_obj;
    }

    public void setAddress_obj(Address address_obj) {
        this.address_obj = address_obj;
    }

    public Staff getStaff_obj() {
        return staff_obj;
    }

    public void setStaff_obj(Staff staff_obj) {
        this.staff_obj = staff_obj;
    }

    // Getters and Setters for GUI Controller
    public int getStaff_obj_id() {
        return staff_obj.getStaff_id();
    }

    public void setStaff_id(int new_id) { /* update id = new_id for THIS Object */ }

    public int getAddress_obj_id() {
        return address_obj.getAddress_id();
    }

    public void setAddress_id(int new_id) { /* update id = new_id for THIS Object */ }
}
