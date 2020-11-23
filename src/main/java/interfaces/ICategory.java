package interfaces;

import java.util.List;

import models.Category;

public interface ICategory {

	public List<Category> getAllCategories();
	
	public Category getCategoryById(long category_id);
	
	public boolean deleteCategory(Category category);
	
	public Category insertCategory(Category category);
	
	public Category updateCategory(Category category);
}
