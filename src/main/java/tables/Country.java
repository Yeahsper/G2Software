package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "country")
public class Country implements Serializable{
    private static final long serialVersionUID=1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="country_id",unique =true )
        private int country_id;
        @Column(name="country",nullable = false )
        private String country;
        @Column(name="last_update",nullable = false )
        private String last_update;

    @OneToMany(mappedBy = "country_OBJ")
    private List<City> city_list;

    public void setCity_list(List<City> city_list) {
        this.city_list = city_list;
    }

    public List<City> getCity_list() {
        return city_list;
    }

    public int getCountry_id()
        {return country_id;}
        public void setID(int a){
            country_id=a;
        }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getCountry() {
        return country;
    }

    public String getLast_update() {
        return last_update;
    }



}
