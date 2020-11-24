package models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	@Column(unique = true)
	private String username;
	private String password;
	private int coins;
	private String userAvatar;
	private int userWinstreak;
	private String userEmail;
	
	@JoinColumn(name = "league_rank")
    @OneToOne(fetch = FetchType.LAZY)
    private League league;
	
	@ManyToMany(mappedBy = "users")
	private List<Course> courses;
	
	@ManyToMany(mappedBy = "users")
	private List<Exercise> exercises;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private List<Follower> followers;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
	private List<Following> following;
	
	// Constructors
	public User() {
		// Empty Constructor
	}
	
	public User(String username, String password, int coins, String userAvatar, int userWinstreak, String userEmail) {
		super();
		this.username = username;
		this.password = password;
		this.coins = coins;
		this.userAvatar = userAvatar;
		this.userWinstreak = userWinstreak;
		this.userEmail = userEmail;
	}
	
	public User(long user_id, String username, String password, int coins, String userAvatar, int userWinstreak, String userEmail) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.coins = coins;
		this.userAvatar = userAvatar;
		this.userWinstreak = userWinstreak;
		this.userEmail = userEmail;
	}

	// Getters && Setters:
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public int getUserWinstreak() {
		return userWinstreak;
	}

	public void setUserWinstreak(int userWinstreak) {
		this.userWinstreak = userWinstreak;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void addLevel(Course course) {
		this.courses.add(course);
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
	
	public List<Follower> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follower> followers) {
		this.followers = followers;
	}
	
	public void addFollower(Follower follower) {
		this.followers.add(follower);
	}

	public List<Following> getFollowing() {
		return following;
	}

	public void setFollowingUsers(List<Following> following) {
		this.following = following;
	}
	
	public void addFollowingUser(Following following) {
		this.following.add(following);
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

}
