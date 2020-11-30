package interfaces;

import java.util.List;

import models.Category;

public interface ICategory {

	public List<Category> getAllCategories();
	
	public Category getCategoryById(long category_id);
	
	public Category getCategoryByName(String category_name);
	
	public List<Category> getCategoriesByCourseId(long course_id);
	
	public boolean deleteCategory(Category category);
	
	public Category insertCategory(Category category);
	
	public Category updateCategory(Category category);
}
