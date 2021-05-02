package com.bestbuy.service;

import java.util.List;

import com.bestbuy.model.Product;

public interface ProductService {
	List<Product> getProducts();
	Product getProduct(Integer id);
	Boolean add(Product product);
	Boolean update(Product product);
	Boolean delete(Integer id);
	Boolean exists(Integer id);
}
