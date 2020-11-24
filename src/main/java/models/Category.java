package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long category_id;
	
	private String category_name;
	
	private boolean isComplete;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "category_id")
	private List<Level> levels;
	
	// Constructors
	public Category() {
		this.levels = new ArrayList<Level>();
	}
	
	public Category(String category_name) {
		super();
		this.category_name = category_name;
		this.levels = new ArrayList<Level>();
	}
	
	public Category(long category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.levels = new ArrayList<Level>();
	}

	// Getters && Setters:
	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
	
	public void addLevel(Level level) {
		this.levels.add(level);
	}

}
