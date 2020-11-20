package modelsMtM;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@ManyToMany(mappedBy = "users")
	private List<Department> departments;

	public User() {
		departments = new ArrayList<Department>();
	}

	public User(String firstName, String lastName) {
		super();
		departments = new ArrayList<Department>();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void addDepartment(Department department) {
		departments.add(department);
	}
	
	public void addDepartments(List<Department> departments) {
		this.departments.addAll(departments);
	}

}
