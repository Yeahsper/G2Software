package tables;

import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.*;

@Entity
@Table (name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "address_id", unique = true)
    private int address_id;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "address2", nullable = false)
    private String address2;
    @Column(name = "district", nullable = false)
    private String district;
    @Column(name = "postal_code", nullable = false)
    private String postal_code;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "location", nullable = false)
    private Blob location;
    @Column(name = "last_update", nullable = false)
    private String last_update;

    // Connects city and address
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city_obj = new City();

    // For testing
    @Override
    public String toString() {
        return "Address{" +
//                "CITY=" + city.getCity() +
                ", address_id=" + address_id +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", last_update='" + last_update + '\'' +
                '}';
    }

    public City getCity() { return city_obj; }

    public void setCity(City city) { this.city_obj = city; }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Blob getLocation() {
        return location;
    }

    public void setLocation(Blob location) {
        this.location = location;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
