package tables;
import javax.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "language_id", unique = true)
    private int language_id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_update", nullable = false)
    private String last_update;

    @Override
    public String toString() {
        return "Language{" +
                "address_id=" + language_id +
                ", name='" + name + '\'' +
                ", last_update='" + last_update + '\'' +
                '}';
    }

    public int getLanguage_id() { return language_id; }

    public void setLanguage_id(int language_id) { this.language_id = language_id; }

    public int getAddress_id() {
        return language_id;
    }

    public void setAddress_id(int address_id) {
        this.language_id = address_id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

}
