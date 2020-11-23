package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.IExerciseType;
import models.ExerciseType;
import utils.HibernateUtil;

public class ExerciseTypeImpl implements IExerciseType {

	@Override
	public List<ExerciseType> getAllExerciseTypes() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<ExerciseType> query = queryBuilder.createQuery(ExerciseType.class);
	        Root<ExerciseType> from = query.from(ExerciseType.class);
	        
	        CriteriaQuery<ExerciseType> all = query.select(from);
	        TypedQuery<ExerciseType> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the exerciseTypes.");		
		}
		return null;
	}

	@Override
	public ExerciseType getExerciseTypeById(long type_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(ExerciseType.class, type_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the exerciseType with id " + (type_id) + ".");
		}
		return null;
	}

	@Override
	public boolean deleteExerciseType(ExerciseType exerciseType) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(exerciseType);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the exerciseType with id" + (exerciseType.getType_id()) + ".");		}
		return false;
	}

	@Override
	public ExerciseType insertExerciseType(ExerciseType exerciseType) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(exerciseType);
		
			t.commit();			
			return exerciseType;
		} catch (Exception e) {
			System.out.println("Exception while inserting the exerciseType with id " + (exerciseType.getType_id()) + ".");		}
		return null;
	}

	@Override
	public ExerciseType updateExerciseType(ExerciseType exerciseType) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(exerciseType);
		
			t.commit();			
			return exerciseType;
		} catch (Exception e) {
			System.out.println("Exception while updating the exerciseType with id " + (exerciseType.getType_id()) + ".");
		}
		return null;
	}
	
}
