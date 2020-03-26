package tables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="actor")
public class Actor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "actor_id", unique = true)
	private int actor_id;

	@Column(name = "first_name", nullable = false)
	private String first_name;

	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "last_update", nullable = false)
	private String last_update;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "film_actor",
			joinColumns = {@JoinColumn(name = "actor_id")},
			inverseJoinColumns = {@JoinColumn(name = "film_id")})
	private List<Film> films;

	@Override
	public String toString() {
		return "Actor{" +
				"actor_id=" + actor_id +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", last_update='" + last_update + '\'' +
				", films=" + films.size() +
				'}';
	}

	public int getActor_id() {
		return actor_id;
	}

	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLast_update() {
		return last_update;
	}

	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}

	public List<Film> getFilms() { return films; }

	public void setFilms(List<Film> films) { this.films = films; }

	

	
	
	
	
	
	
	
}
