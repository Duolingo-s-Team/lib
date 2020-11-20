package modelsMtM;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@Column(name = "department_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "department_name")
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "department_user", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "department_id")})
	private List<User> users;
	
	public Department() {
		users = new ArrayList<User>();
	}
	
	public Department(String name) {
		users = new ArrayList<User>();
		this.name = name;
	}
	
	public Department(int id, String name) {
		users = new ArrayList<User>();
		this.id = id;
		this.name = name;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		users.add(user);
	}
	
	public void addUsers(List<User> users) {
		users.addAll(users);
	}

}
