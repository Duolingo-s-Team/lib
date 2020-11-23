package models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long course_id;
	
	private String course_name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_id")
	private List<Category> categories;
	
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
		this.categories = categories;
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

}
