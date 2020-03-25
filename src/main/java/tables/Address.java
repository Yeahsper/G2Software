package tables;

import java.io.Serializable;
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
    @Column(name = "city_id", unique = true, nullable = false)
    private int city_id;
    @Column(name = "postal_code", nullable = false)
    private String postal_code;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "last_update", nullable = false)
    private String last_update;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "city",
//            joinColumns = {@JoinColumn(name = "city_id")})
//
//    private City city = new City();

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                ", city_id=" + city_id +
                ", postal_code='" + postal_code + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", last_update='" + last_update + '\'' +
                '}';
    }

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

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
