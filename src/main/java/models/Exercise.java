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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exercises")
public class Exercise implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long exercise_id;
	
	private String exercise_name;
	private String content;
	private boolean isFinished;
	
	@ManyToOne()
    @JoinColumn(name = "level_id")
    private Level level;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "users_exercises", joinColumns = {@JoinColumn(name = "exercise_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
	private List<User> users;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "type_id")
	private List<ExerciseType> types;
	
	// Constructors
	public Exercise() {
		this.users = new ArrayList<User>();
		this.types = new ArrayList<ExerciseType>();
	}
	
	public Exercise(String exercise_name, String content) {
		super();
		this.exercise_name = exercise_name;
		this.content = content;
		this.users = new ArrayList<User>();
		this.types = new ArrayList<ExerciseType>();
	}
	
	public Exercise(String exercise_name, String content, Level level) {
		super();
		this.exercise_name = exercise_name;
		this.content = content;
		this.level = level;
	}

	// Getters && Setters:
	public long getExercise_id() {
		return exercise_id;
	}

	public void setExercise_id(long exercise_id) {
		this.exercise_id = exercise_id;
	}

	public String getExercise_name() {
		return exercise_name;
	}

	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String jsonContent) {
		this.content = jsonContent;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
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

	public List<ExerciseType> getTypes() {
		return types;
	}

	public void setTypes(List<ExerciseType> types) {
		this.types = types;
	}
	
	public void addType(ExerciseType type) {
		this.types.add(type);
	}
}
