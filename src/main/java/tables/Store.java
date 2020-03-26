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
    List<Customer> customerList;

    // Connects store to address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address_obj;

    //TODO change XXX to the onetoone jointable from Staff class.
//    @OneToOne(mappedBy="XXX")
//    private Staff manager;

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
