package models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long course_id;
	
	@Column(unique = true)
	private String course_name;
	
	private boolean isFinished;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_id")
	private List<Category> categories;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "Users_Courses", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "course_id")})
	private List<User> users;
	
	// Constructors
	public Course() {
		// Empty Constructor
	}
	
	public Course(String course_name) {
		super();
		this.course_name = course_name;
	}
	
	public Course(long course_id, String course_name, List<Category> categories) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.setCategories(categories);
	}

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategory(Category category) {
		this.categories.add(category);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
}
