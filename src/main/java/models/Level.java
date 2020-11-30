package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "levels")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long level_id;
	
	private String level_name;
	
	private boolean isComplete;
	
	@ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "exercise_id")
	private List<Exercise> exercises;
	
	// Constructors
	public Level() {
		this.exercises = new ArrayList<Exercise>();
	}
	
	public Level(String level_name) {
		super();
		this.level_name = level_name;
		this.exercises = new ArrayList<Exercise>();
	}
	
	public Level(long level_id, String level_name) {
		super();
		this.level_id = level_id;
		this.level_name = level_name;
		this.exercises = new ArrayList<Exercise>();
	}

	public long getLevel_id() {
		return level_id;
	}

	public void setLevel_id(long level_id) {
		this.level_id = level_id;
	}

	public String getLevel_name() {
		return level_name;
	}

	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	public void addExercise(Exercise exercise) {
		this.exercises.add(exercise);
	}

}
