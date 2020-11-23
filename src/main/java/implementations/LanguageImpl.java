package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.ILanguage;
import models.Language;
import utils.HibernateUtil;

public class LanguageImpl implements ILanguage {

	@Override
	public List<Language> getAllLanguages() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Language> query = queryBuilder.createQuery(Language.class);
	        Root<Language> from = query.from(Language.class);
	        
	        CriteriaQuery<Language> all = query.select(from);
	        TypedQuery<Language> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the languages.");		
		}
		return null;
	}

	@Override
	public Language getLanguageById(long language_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(Language.class, language_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the language with id " + (language_id) + ".");
		}
		return null;
	}

	@Override
	public boolean deleteLanguage(Language language) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(language);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the language with id" + (language.getLanguage_id()) + ".");		}
		return false;
	}

	@Override
	public Language insertLanguage(Language language) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(language);
		
			t.commit();			
			return language;
		} catch (Exception e) {
			System.out.println("Exception while inserting the language with id " + (language.getLanguage_id()) + ".");		}
		return null;
	}

	@Override
	public Language updateLanguage(Language language) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(language);
		
			t.commit();			
			return language;
		} catch (Exception e) {
			System.out.println("Exception while updating the language with id " + (language.getLanguage_id()) + ".");
		}
		return null;
	}
	
}
