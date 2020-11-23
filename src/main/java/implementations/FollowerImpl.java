package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.IFollower;
import models.Follower;
import utils.HibernateUtil;

public class FollowerImpl implements IFollower {

	@Override
	public List<Follower> getAllFollowers() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Follower> query = queryBuilder.createQuery(Follower.class);
	        Root<Follower> from = query.from(Follower.class);
	        
	        CriteriaQuery<Follower> all = query.select(from);
	        TypedQuery<Follower> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the followers.");		
		}
		return null;
	}

	@Override
	public Follower getFollowerById(long follower_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(Follower.class, follower_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the follower with id " + (follower_id) + ".");
		}
		return null;
	}

	@Override
	public boolean deleteFollower(Follower follower) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(follower);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the follower with id" + (follower.getUser_id()) + ".");		}
		return false;
	}

	@Override
	public Follower insertFollower(Follower follower) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(follower);
		
			t.commit();			
			return follower;
		} catch (Exception e) {
			System.out.println("Exception while inserting the follower with id " + (follower.getUser_id()) + ".");		}
		return null;
	}

	@Override
	public Follower updateFollower(Follower follower) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(follower);
		
			t.commit();			
			return follower;
		} catch (Exception e) {
			System.out.println("Exception while updating the follower with id " + (follower.getUser_id()) + ".");
		}
		return null;
	}
	
}
