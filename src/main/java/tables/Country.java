package tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "country")
public class Country implements Serializable{
    private static final long serialVersionUID=1L;

        @Id
        @Column(name="country_id",unique =true )
        private int country_id;
        @Column(name="country",nullable = false )
        private String country_name;
        @Column(name="last_update",nullable = false )
        private String last_update;

        public int getCountry_id()
        {return country_id;}
        public void setID(int a){
            country_id=a;
        }

    public void setCountry_name(String country) {
        this.country_name = country;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getCountry_name() {
        return country_name;
    }

    public String getLast_update() {
        return last_update;
    }



    @OneToMany(mappedBy ="country_list")
    private List<City> city_list =new ArrayList<>();
}
