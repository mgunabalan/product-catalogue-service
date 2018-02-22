package com.pcs.product.service;

import java.util.List;

import com.pcs.model.Product;

public interface GetProductService {
	
	List<Product> findAll();

	Product findProductStock(long productId);

	List<Product> searchProducts(Product productEntity);

}
