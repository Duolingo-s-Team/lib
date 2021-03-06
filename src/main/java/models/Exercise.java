package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long exercise_id;
	
	private String exercise_name;
	private int exercise_exp;
	private byte[] content;
	private boolean isFinished;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "User_Exercise", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "exercise_id")})
	private List<User> users;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "type_id")
	private List<ExerciseType> types;
	
	// Constructors
	public Exercise() {
		// Empty Constructor
	}
	
	public Exercise(String exercise_name, int exercise_exp, byte[] content) {
		super();
		this.exercise_name = exercise_name;
		this.exercise_exp = exercise_exp;
		this.content = content;
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

	public int getExercise_exp() {
		return exercise_exp;
	}

	public void setExercise_exp(int exercise_exp) {
		this.exercise_exp = exercise_exp;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(File content) {
		try {
			FileInputStream f = new FileInputStream(content);
			this.content = f.readAllBytes();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please check the file's path." + e.getCause());
		} catch (IOException e) {
			System.out.println("Error while reading the given File." + e.getCause());
		}
		
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
