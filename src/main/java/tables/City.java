package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "city")
public class City implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="city_id",unique =true )
    private int city_id;
    @Column(name="city",nullable = false )
    private String city;
    @Column(name="last_update",nullable = false )
    private String last_update;

    @OneToMany(mappedBy = "city_obj")
    private List<Address> addressList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="country_id")
    private Country country_obj;

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city='" + city + '\'' +
                ", last_update='" + last_update + '\'' +
                ", addressList=" + addressList +
                ", country_obj_id=" + country_obj.getCountry_id() +
                '}';
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Country getCountry_obj() {
        return country_obj;
    }

    public void setCountry_obj(Country country_obj) {
        this.country_obj = country_obj;
    }
}
