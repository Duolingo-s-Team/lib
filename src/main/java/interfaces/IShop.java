package interfaces;

import java.util.List;

import models.Shop;

public interface IShop {

	public List<Shop> getAllProducts();
	
	public Shop getProductById(long shop_id);
	
	public boolean deleteProduct(Shop shop);
	
	public Shop insertProduct(Shop shop);
	
	public Shop updateProduct(Shop shop);
}
