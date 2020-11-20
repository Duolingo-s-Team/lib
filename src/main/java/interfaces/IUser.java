package interfaces;

import java.util.List;

import models.User;

public interface IUser {

	/**@return a List with all departments
	 */
	public List<User> getAllUsers();
	
	/**@param department_id a long with the id
	 * @return the Department with the given id
	 */
	public User getUserById(long user_id);
	
	/**@param department_id a long with the id
	 * @return a int with the result of the delete
	 */
	public boolean deleteUserById(User user);
	
	/**@param department a Department
	 * @return the Department that has been inserted
	 */
	public User insertUser(User user);
	
	/**@param department a Department
	 * @return the Department that has been updated
	 */
	public User updateUser(User user);

	
	
}
