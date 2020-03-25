package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name="store")
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="store_id",unique = true)
    private int id;

    //TODO change XXX to the onetoone jointable from Address class.
    @OneToOne(mappedBy = "XXX")
    private Address address;

    //TODO change XXX to the onetoone jointable from Staff class.
    @OneToOne(mappedBy="XXX")
    private Staff manager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }
}
