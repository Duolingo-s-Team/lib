package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course implements Serializable {
	
	private static final long serialVersionUID = 24L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long course_id;
	
	private String course_lang_from;
	private String course_lang_to;

	private boolean isFinished;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_id")
	private List<Category> categories;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "users_courses", joinColumns = {@JoinColumn(name = "course_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
	private List<User> users;
	
	// Constructors
	public Course() {
		this.categories = new ArrayList<Category>();
		this.users = new ArrayList<User>();
	}
	
	public Course(String course_lang_from, String course_lang_to) {
		super();
		this.course_lang_from = course_lang_from;
		this.course_lang_to = course_lang_to;
		this.categories = new ArrayList<Category>();
		this.users = new ArrayList<User>();
	}
	
	public Course(long course_id, String course_lang_from, String course_lang_to) {
		super();
		this.course_id = course_id;
		this.course_lang_from = course_lang_from;
		this.course_lang_to = course_lang_to;
		this.categories = new ArrayList<Category>();
		this.users = new ArrayList<User>();
	}

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}
	
	public String getCourse_lang_from() {
		return course_lang_from;
	}

	public void setCourse_lang_from(String course_lang_from) {
		this.course_lang_from = course_lang_from;
	}

	public String getCourse_lang_to() {
		return course_lang_to;
	}

	public void setCourse_lang_to(String course_lang_to) {
		this.course_lang_to = course_lang_to;
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

	@Override
	public String toString() {
		return (course_id + " " + course_lang_from + " " + course_lang_to + " " + isFinished);
	}
	
//	@Override
//	public String toString() {
//		return course_lang_from + " - " + course_lang_to;
//	}
	
}
