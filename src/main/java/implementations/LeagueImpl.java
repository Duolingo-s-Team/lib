package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.ILeague;
import models.League;
import utils.HibernateUtil;

public class LeagueImpl implements ILeague {

	@Override
	public List<League> getAllLeagueRanks() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<League> query = queryBuilder.createQuery(League.class);
	        Root<League> from = query.from(League.class);
	        
	        CriteriaQuery<League> all = query.select(from);
	        TypedQuery<League> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the leagues.");		
		}
		return null;
	}

	@Override
	public League getRankByUserId(long user_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(League.class, user_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the league with id " + (user_id) + ".");
		}
		return null;
	}

	@Override
	public boolean deleteLeague(League league) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(league);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the league with id" + (league.getLeague_rank()) + ".");		}
		return false;
	}

	@Override
	public League insertLeague(League league) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(league);
		
			t.commit();			
			return league;
		} catch (Exception e) {
			System.out.println("Exception while inserting the league rank with id " + (league.getLeague_rank()) + ".");		}
		return null;
	}

	@Override
	public League updateLeague(League league) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(league);
		
			t.commit();			
			return league;
		} catch (Exception e) {
			System.out.println("Exception while updating the league rank with id " + (league.getLeague_rank()) + ".");
		}
		return null;
	}
	
}
