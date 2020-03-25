package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "city")
public class City implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @Column(name="city_id",unique =true )
    private int city_id;
    @Column(name="city",nullable = false )
    private String city;
    @Column(name="country_id",nullable = false )
    private int country_id;
    @Column(name="last_update",nullable = false )
    private String last_update;

    public int getID()
    {return city_id;}
    public void setID(int a){
        city_id=a;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="country",
            joinColumns = {@JoinColumn(name = "country_id")})
    private Country country_list;
}
