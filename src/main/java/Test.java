import implementations.UserImpl;
import interfaces.IUser;
import models.Exercise;
import models.User;

public class Test {

	public static void main(String[] args) {
		User u1 = new User("test", "1234", 0, "", 1, "test@duolingo.com");
		
		Exercise e1 = new Exercise("Translate", 5, null);
		Exercise e2 = new Exercise("Listen", 10, null);
		
		u1.addExercise(e1);
		u1.addExercise(e2);
		
		IUser userManager = new UserImpl();
		
		userManager.insertUser(u1);
		
		
	}

}
