package implementations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.IUser;
import models.User;
import utils.HibernateUtil;

public class UserImpl implements IUser {

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<User> getAllUsers() {
		Transaction t = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			List<User> users = session.createCriteria(User.class).list();
		
			t.commit();			
			
			return users;
		} catch (Exception e) {
			System.out.println("Fatal Exception. Exiting with code -1");
		}
		return null;
	}

	@Override
	public User getUserById(long user_id) {
		 
		return null;
	}

	@Override
	public boolean deleteUserById(User user) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(user);
		
			t.commit();	
			
			return true;
		} catch (Exception e) {
			System.out.println("Fatal Exception. Exiting with code -1");
		}
		return false;
	}

	@Override
	public User insertUser(User user) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(user);
		
			t.commit();			
			
			return user;
		} catch (Exception e) {
			System.out.println("Fatal Exception. Exiting with code -1");
		}
		return null;
	}

	@Override
	public User updateUser(User user) {
		 
		return null;
	}

	
}
