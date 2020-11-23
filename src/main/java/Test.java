import implementations.UserImpl;
import interfaces.IUser;
import models.User;

public class Test {

	public static void main(String[] args) {

		User u1 = new User("User11", "1235", 6, "C:\\Users\\Images\\avatar.jpg", 4, "user1234@gmail.com");
		User u2 = new User("User2", "1234", 6, "C:\\Users\\Images\\avatar.jpg2", 4, "user1234@gmail.com");
		User u3 = new User("User3", "1234", 6, "C:\\Users\\Images\\avatar.jpg3", 4, "user1234@gmail.com");
		
		IUser userManager = new UserImpl();
		
		userManager.insertUser(u1);
		System.out.println(userManager.getUserById(1));
		userManager.updateUser(new User(1, "User1", "1234", 6, "C:\\Users\\Images\\avatar.jpg1", 4, "user1234@gmail.com"));
		
		userManager.insertUser(u2);
		userManager.insertUser(u3);
		System.out.println(userManager.getAllUsers());
	}

}
