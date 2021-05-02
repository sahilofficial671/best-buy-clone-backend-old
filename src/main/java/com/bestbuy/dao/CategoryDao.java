package com.bestbuy.dao;

import java.util.List;

import com.bestbuy.model.Category;
import com.bestbuy.model.Product;

public interface CategoryDao {
	List<Category> getCategories();
	Category getCategory(Integer id);
	Boolean add(Category category);
	Boolean update(Category category);
	Boolean delete(Integer id);
	Boolean exists(Integer id);
	
	List<Product> getProducts(Integer categoryId);
}
