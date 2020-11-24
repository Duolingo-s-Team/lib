package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.ICategory;
import models.Category;
import utils.HibernateUtil;

public class CategoryImpl implements ICategory {

	@Override
	public List<Category> getAllCategories() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Category> query = queryBuilder.createQuery(Category.class);
	        Root<Category> from = query.from(Category.class);
	        
	        CriteriaQuery<Category> all = query.select(from);
	        TypedQuery<Category> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the categorys.");		
		}
		return null;
	}

	@Override
	public Category getCategoryById(long category_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(Category.class, category_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the category with id " + (category_id) + ".");
		}
		return null;
	}
	
	@Override
	public Category getCategoryByName(String category_name) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Category> query = queryBuilder.createQuery(Category.class);
	        Root<Category> from = query.from(Category.class);
	        ParameterExpression<String> where = queryBuilder.parameter(String.class);
	        
	        CriteriaQuery<Category> select = query.select(from).where(queryBuilder.equal(from.get("category_name"), where));
	        TypedQuery<Category> allQuery = session.createQuery(select);
	        
	        allQuery.setParameter(where, category_name);
	      
	        return allQuery.getResultList().get(allQuery.getFirstResult());
			
		} catch (Exception e) {
			System.out.println("Exception while getting the category with name '" + (category_name) + "'.");
		}
		return null;
	}

	@Override
	public boolean deleteCategory(Category category) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(category);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the category with id" + (category.getCategory_id()) + ".");		}
		return false;
	}

	@Override
	public Category insertCategory(Category category) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(category);
		
			t.commit();			
			return category;
		} catch (Exception e) {
			System.out.println("Exception while inserting the category with id " + (category.getCategory_id()) + ".");		}
		return null;
	}

	@Override
	public Category updateCategory(Category category) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(category);
		
			t.commit();			
			return category;
		} catch (Exception e) {
			System.out.println("Exception while updating the category with id " + (category.getCategory_id()) + ".");
		}
		return null;
	}
	
}
