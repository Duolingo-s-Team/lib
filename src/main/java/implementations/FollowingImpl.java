package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.IFollowing;
import models.Following;
import utils.HibernateUtil;

public class FollowingImpl implements IFollowing {

	@Override
	public List<Following> getAllFollowingUsers() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Following> query = queryBuilder.createQuery(Following.class);
	        Root<Following> from = query.from(Following.class);
	        
	        CriteriaQuery<Following> all = query.select(from);
	        TypedQuery<Following> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the followings.");		
		}
		return null;
	}

	@Override
	public Following getFollowingById(long following_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(Following.class, following_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the following with id " + (following_id) + ".");
		}
		return null;
	}

	@Override
	public boolean deleteFollowing(Following following) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(following);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the following with id" + (following.getUser_id()) + ".");		}
		return false;
	}

	@Override
	public Following insertFollowing(Following following) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(following);
		
			t.commit();			
			return following;
		} catch (Exception e) {
			System.out.println("Exception while inserting the following with id " + (following.getUser_id()) + ".");		}
		return null;
	}

	@Override
	public Following updateFollowing(Following following) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(following);
		
			t.commit();			
			return following;
		} catch (Exception e) {
			System.out.println("Exception while updating the following with id " + (following.getUser_id()) + ".");
		}
		return null;
	}
	
}
