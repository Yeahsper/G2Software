package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="store")
public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="store_id",unique = true)
    private int id;


    //TODO change XXX to the onetoone jointable from Address class.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address_obj;

    //TODO change XXX to the onetoone jointable from Staff class.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="manager_staff_id")
    private Staff staff;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress_obj() {
       return address_obj;
  }

  public void setAddress_obj(Address address) {     this.address_obj = address; }

    public Staff getManager() {
       return staff;
    }

    public void setManager(Staff manager) {
        this.staff = manager;
   }


    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", address_obj=" + address_obj +
                '}';
    }
}