package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.IExercise;
import models.Exercise;
import utils.HibernateUtil;

public class ExerciseImpl implements IExercise {

	@Override
	public List<Exercise> getAllExercises() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Exercise> query = queryBuilder.createQuery(Exercise.class);
	        Root<Exercise> from = query.from(Exercise.class);
	        
	        CriteriaQuery<Exercise> all = query.select(from);
	        TypedQuery<Exercise> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the exercises.");		
		}
		return null;
	}

	@Override
	public Exercise getExerciseById(long exercise_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(Exercise.class, exercise_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the exercise with id " + (exercise_id) + ".");
		}
		return null;
	}
	
	@Override
	public Exercise getExerciseByName(String exercise_name) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Exercise> query = queryBuilder.createQuery(Exercise.class);
	        Root<Exercise> from = query.from(Exercise.class);
	        ParameterExpression<String> where = queryBuilder.parameter(String.class);
	        
	        CriteriaQuery<Exercise> select = query.select(from).where(queryBuilder.equal(from.get("exercise_name"), where));
	        TypedQuery<Exercise> allQuery = session.createQuery(select);
	        
	        allQuery.setParameter(where, exercise_name);
	      
	        return allQuery.getResultList().get(allQuery.getFirstResult());
			
		} catch (Exception e) {
			System.out.println("Exception while getting the exercise with name '" + (exercise_name) + "'.");
		}
		return null;
	}

	@Override
	public boolean deleteExercise(Exercise exercise) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(exercise);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the exercise with id" + (exercise.getExercise_id()) + ".");		}
		return false;
	}

	@Override
	public Exercise insertExercise(Exercise exercise) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(exercise);
		
			t.commit();			
			return exercise;
		} catch (Exception e) {
			System.out.println("Exception while inserting the exercise with id " + (exercise.getExercise_id()) + ".");		}
		return null;
	}

	@Override
	public Exercise updateExercise(Exercise exercise) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(exercise);
		
			t.commit();			
			return exercise;
		} catch (Exception e) {
			System.out.println("Exception while updating the exercise with id " + (exercise.getExercise_id()) + ".");
		}
		return null;
	}
	
}
