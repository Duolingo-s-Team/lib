package implementations;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.IShop;
import models.Shop;
import utils.HibernateUtil;

public class ShopImpl implements IShop {

	@Override
	public List<Shop> getAllProducts() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder queryBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Shop> query = queryBuilder.createQuery(Shop.class);
	        Root<Shop> from = query.from(Shop.class);
	        
	        CriteriaQuery<Shop> all = query.select(from);
	        TypedQuery<Shop> allQuery = session.createQuery(all);
	        
	        return allQuery.getResultList();	
		} catch (Exception e) {
			System.out.println("Exception while getting all the shop products.");		
		}
		return null;
	}

	@Override
	public Shop getProductById(long shop_id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction t = session.beginTransaction();
			if (t.isActive()) {
				return session.get(Shop.class, shop_id);
			}
		} catch (Exception e) {
			System.out.println("Exception while getting the shop product with id " + (shop_id) + ".");
		}
		return null;
	}

	@Override
	public boolean deleteProduct(Shop shop) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.delete(shop);
		
			t.commit();	
			return true;
		} catch (Exception e) {
			System.out.println("Exception while deleting the shop product with id" + (shop.getProduct_id()) + ".");		}
		return false;
	}

	@Override
	public Shop insertProduct(Shop shop) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.save(shop);
		
			t.commit();			
			return shop;
		} catch (Exception e) {
			System.out.println("Exception while inserting the shop product with id " + (shop.getProduct_id()) + ".");		}
		return null;
	}

	@Override
	public Shop updateProduct(Shop shop) {
		Transaction t = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			
			session.merge(shop);
		
			t.commit();			
			return shop;
		} catch (Exception e) {
			System.out.println("Exception while updating the shop product with id " + (shop.getProduct_id()) + ".");
		}
		return null;
	}
	
}
