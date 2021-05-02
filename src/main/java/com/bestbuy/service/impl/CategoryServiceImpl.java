package com.bestbuy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestbuy.dao.CategoryDao;
import com.bestbuy.model.Category;
import com.bestbuy.model.Product;
import com.bestbuy.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}

	@Override
	public Category getCategory(Integer id) {
		return categoryDao.getCategory(id);
	}

	@Override
	public Boolean add(Category category) {
		return categoryDao.add(category);
	}

	@Override
	public Boolean update(Category category) {
		return categoryDao.update(category);
	}

	@Override
	public Boolean delete(Integer id) {
		return categoryDao.delete(id);
	}

	@Override
	public Boolean exists(Integer id) {
		return categoryDao.exists(id);
	}
	
	@Override
	public List<Product> getProducts(Integer categoryId) {
		return categoryDao.getProducts(categoryId);
	}

}
