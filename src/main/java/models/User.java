package models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	private String username;
	private String password;
	private int coins;
	private String userAvatar;
	private int userWinstreak;
	private String userEmail;
	
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

}
