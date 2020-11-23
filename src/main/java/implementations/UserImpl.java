package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.IUser;
import models.User;
import utils.HibernateUtil;

public class UserImpl implements IUser {

	@Override
	public List<User> getAllUsers() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<User> query = queryBuilder.createQuery(User.class);
	        Root<User> from = query.from(User.class);
	        
	        CriteriaQuery<User> all = query.select(from);
	        TypedQuery<User> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the users.");		
		}
		return null;
	}

	@Override
	public User getUserById(long user_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(User.class, user_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the user with id " + (user_id) + ".");
		}
		return null;
	}

	@Override
	public boolean deleteUser(User user) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(user);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the user with id" + (user.getUser_id()) + ".");		}
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
			System.out.println("Exception while inserting the user with id " + (user.getUser_id()) + ".");		}
		return null;
	}

	@Override
	public User updateUser(User user) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(user);
		
			t.commit();			
			return user;
		} catch (Exception e) {
			System.out.println("Exception while updating the user with id " + (user.getUser_id()) + ".");
		}
		return null;
	}
	
}
