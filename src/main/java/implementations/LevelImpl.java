package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.ILevel;
import models.Level;
import utils.HibernateUtil;

public class LevelImpl implements ILevel {

	@Override
	public List<Level> getAllLevels() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Level> query = queryBuilder.createQuery(Level.class);
	        Root<Level> from = query.from(Level.class);
	        
	        CriteriaQuery<Level> all = query.select(from);
	        TypedQuery<Level> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the levels.");		
		}
		return null;
	}

	@Override
	public Level getLevelById(long level_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(Level.class, level_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the level with id " + (level_id) + ".");
		}
		return null;
	}

	@Override
	public boolean deleteLevel(Level level) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(level);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the level with id" + (level.getLevel_id()) + ".");		}
		return false;
	}

	@Override
	public Level insertLevel(Level level) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(level);
		
			t.commit();			
			return level;
		} catch (Exception e) {
			System.out.println("Exception while inserting the level with id " + (level.getLevel_id()) + ".");		}
		return null;
	}

	@Override
	public Level updateLevel(Level level) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(level);
		
			t.commit();			
			return level;
		} catch (Exception e) {
			System.out.println("Exception while updating the level with id " + (level.getLevel_id()) + ".");
		}
		return null;
	}
	
}
