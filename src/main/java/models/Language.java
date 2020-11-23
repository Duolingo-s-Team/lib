package models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "languages")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long language_id;
	
	private String language_name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "language_id")
	private List<Course> courses;
	
	// Constructors
	public Language() {
		// Empty Constructor
	}
	
	public Language(String language_name) {
		super();
		this.language_name = language_name;
	}
	
	public Language(long language_id, String language_name, List<Course> courses) {
		super();
		this.language_id = language_id;
		this.language_name = language_name;
		this.courses = courses;
	}

	// Getters && Setters:
	public long getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(long language_id) {
		this.language_id = language_id;
	}

	public String getLanguage_name() {
		return language_name;
	}

	public void setLanguage_name(String language_name) {
		this.language_name = language_name;
	}

}
