package models;

import javax.persistence.*;

@Entity
@Table(name = "league")
public class League {

	@Id
	private long league_rank;
	
	private int league_pos;
	
	@OneToOne(mappedBy = "league", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private User user;
	
	// Constructors
	public League() {
		// Empty Constructor
	}
	
	public League(int league_pos) {
		super();
		this.league_pos = league_pos;
	}
	
	public League(long league_rank, int league_pos) {
		super();
		this.league_rank = league_rank;
		this.league_pos = league_pos;
	}

	// Getters && Setters:
	public long getLeague_rank() {
		return league_rank;
	}

	public void setLeague_rank(long league_rank) {
		this.league_rank = league_rank;
	}

	public int getLeague_pos() {
		return league_pos;
	}

	public void setLeague_pos(int league_pos) {
		this.league_pos = league_pos;
	}

}
