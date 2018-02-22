package com.pcs.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcs.jpa.repository.ProductRepository;
import com.pcs.model.Product;
import com.pcs.model.response.ResponseMessage;
import com.pcs.product.service.SaveProductService;

@Service
public class SaveProductServiceImpl implements SaveProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public String save(Product product) throws Exception {
		try {
			productRepository.save(product);
		} catch (Exception e) {
			/// logger and global exception handling
			throw new Exception(e.getMessage());
		}
		return ResponseMessage.ADDED_PRODUCT;
	}

}
