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

    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + country_id +
                ", country='" + country + '\'' +
                ", last_update='" + last_update + '\'' +

                '}';
    }
}
