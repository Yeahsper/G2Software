package tables;

import javax.persistence.*;
import java.io.Serializable;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="country_id")
    private Country country_OBJ;

    public void setCountry_OBJ(Country country_) {
        this.country_OBJ = country_;
    }
    public Country getCountry_OBJ() {
        return country_OBJ;
    }

    public int getID()
    {return city_id;}
    public void setID(int a){
        city_id=a;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getCity() {
        return city;
    }

    public String getLast_update() {
        return last_update;
    }


}
