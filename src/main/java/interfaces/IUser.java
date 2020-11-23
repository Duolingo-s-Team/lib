package interfaces;

import java.util.List;

import models.User;

public interface IUser {

	public List<User> getAllUsers();
	
	public User getUserById(long user_id);
	
	public boolean deleteUser(User user);
	
	public User insertUser(User user);
	
	public User updateUser(User user);
}
