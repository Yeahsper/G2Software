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

    // Connects customers to store
    @OneToMany(mappedBy = "store")
    private List<Customer> customerList = new ArrayList<>();

    // Connects store to address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address_obj;

//    @OneToOne(mappedBy="staff_id")
//    private Staff manager;


    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", customerList=" + customerList +
                ", address_obj=" + address_obj +
//                ", manager=" + manager.getStaff_id() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() { return address_obj; }

    public void setAddress(Address address) { this.address_obj = address; }

//    public Staff getManager() {
//        return manager;
//    }
//
//    public void setManager(Staff manager) {
//        this.manager = manager;
//    }
}
