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
    private String country_id;
    @Column(name="last_update",nullable = false )
    private String last_update;

    public int getID()
    {return city_id;}
    public void setID(int a){
        city_id=a;
    }

    public void setCountry(String city) {
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "country",
            joinColumns = {@JoinColumn(name = "country_id")})
    private Country country = new Country();
}
