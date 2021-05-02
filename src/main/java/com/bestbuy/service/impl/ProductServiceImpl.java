package com.bestbuy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestbuy.dao.ProductDao;
import com.bestbuy.model.Product;
import com.bestbuy.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	public Product getProduct(Integer id) {
		return productDao.getProduct(id);
	}

	@Override
	public Boolean add(Product product) {
		return productDao.add(product);
	}

	@Override
	public Boolean update(Product product) {
		return productDao.update(product);
	}

	@Override
	public Boolean delete(Integer id) {
		return productDao.delete(id);
	}

	@Override
	public Boolean exists(Integer id) {
		return productDao.exists(id);
	}

}
