package models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "followers")
public class Follower implements Serializable {
	
	@Id
	private long user_id;
	
	// Constructors
	public Follower() {
		// Empty Constructor
	}
	
	public Follower(long user_id) {
		super();
		this.user_id = user_id;
	}

	// Getters && Setters:
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

}
