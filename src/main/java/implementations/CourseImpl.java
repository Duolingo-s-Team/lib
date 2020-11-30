package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.ICourse;
import models.Course;
import utils.HibernateUtil;

public class CourseImpl implements ICourse {

	@Override
	public List<Course> getAllCourses() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Course> query = queryBuilder.createQuery(Course.class);
	        Root<Course> from = query.from(Course.class);
	        
	        CriteriaQuery<Course> all = query.select(from);
	        TypedQuery<Course> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the courses.");		
		}
		return null;
	}

	@Override
	public Course getCourseById(long course_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(Course.class, course_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the course with id " + (course_id) + ".");
		}
		return null;
	}
	
	@Override
	public List<Course> getCoursesByOriginLanguage(String language_name) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Course> query = queryBuilder.createQuery(Course.class);
	        Root<Course> from = query.from(Course.class);
	        ParameterExpression<String> where = queryBuilder.parameter(String.class);
	        
	        CriteriaQuery<Course> select = query.select(from).where(queryBuilder.equal(from.get("course_lang_from"), where));
	        TypedQuery<Course> allQuery = session.createQuery(select);
	        
	        allQuery.setParameter(where, language_name);
	      
	        return allQuery.getResultList();
			
		} catch (Exception e) {
			System.out.println("Exception while getting the course with name '" + (language_name) + "'.");
		}
		return null;
	}
	
	@Override
	public List<Course> getCoursesByDestinationLanguage(String language_name) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Course> query = queryBuilder.createQuery(Course.class);
	        Root<Course> from = query.from(Course.class);
	        ParameterExpression<String> where = queryBuilder.parameter(String.class);
	        
	        CriteriaQuery<Course> select = query.select(from).where(queryBuilder.equal(from.get("course_lang_to"), where));
	        TypedQuery<Course> allQuery = session.createQuery(select);
	        
	        allQuery.setParameter(where, language_name);
	      
	        return allQuery.getResultList();
			
		} catch (Exception e) {
			System.out.println("Exception while getting the course with name '" + (language_name) + "'.");
		}
		return null;
	}
	
	@Override
	public Course getCourseByLanguage(String origin_language, String destination_language) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Course> query = queryBuilder.createQuery(Course.class);
	        Root<Course> from = query.from(Course.class);
	        ParameterExpression<String> where = queryBuilder.parameter(String.class);
	        ParameterExpression<String> and = queryBuilder.parameter(String.class);
	        
	        CriteriaQuery<Course> select = query.select(from).where(queryBuilder.and(queryBuilder.equal(from.get("course_lang_from"), where), queryBuilder.equal(from.get("course_lang_to"), and)));
	        TypedQuery<Course> allQuery = session.createQuery(select);
	        
	        allQuery.setParameter(where, origin_language);
	        allQuery.setParameter(and, destination_language);
	      
	        return allQuery.getResultList().get(0);
			
		} catch (Exception e) {
			System.out.println("Exception while getting the course with origin language '" + (origin_language) + "' and destination language '" + (destination_language) + "'.");
		}
		return null;
	}

	@Override
	public boolean deleteCourse(Course course) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(course);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the course with id" + (course.getCourse_id()) + ".");		}
		return false;
	}

	@Override
	public Course insertCourse(Course course) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(course);
		
			t.commit();			
			return course;
		} catch (Exception e) {
			System.out.println("Exception while inserting the course with id " + (course.getCourse_id()) + ".");		}
		return null;
	}

	@Override
	public Course updateCourse(Course course) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(course);
		
			t.commit();			
			return course;
		} catch (Exception e) {
			System.out.println("Exception while updating the course with id " + (course.getCourse_id()) + ".");
		}
		return null;
	}
	
}
