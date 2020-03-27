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
    private int store_id;
    @Column(name="last_update", nullable = false)
    private String last_update;

    // Connects customers to store
    @OneToMany(mappedBy = "store_obj")
    private List<Customer> customerList = new ArrayList<>();

    // Connects store to address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address_obj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_staff_id")
    private Staff manager_staff_obj;


    @Override
    public String toString() {
        return "Store{" +
                "id=" + store_id +
                ", customerList=" + customerList.size() +
                ", address_obj=" + address_obj.getAddress_id() +
                '}';
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
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

    public Staff getManager_staff_obj() {
        return manager_staff_obj;
    }

    public void setManager_staff_obj(Staff manager_staff_obj) {
        this.manager_staff_obj = manager_staff_obj;
    }

    // Getters and Setters for GUI Controller
    public int getManager_staff_obj_id() { return manager_staff_obj.getStaff_id(); }

    public void setManager_staff_id(int new_id) { /* update id = new_id for THIS Object */ }

    public int getAddress_obj_id() {
        return address_obj.getAddress_id();
    }

    public void setAddress_id(int new_id) { /* update id = new_id for THIS Object */ }
}
