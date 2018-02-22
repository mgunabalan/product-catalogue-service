package com.pcs.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcs.jpa.repository.ProductRepository;
import com.pcs.jpa.repository.StockRepository;
import com.pcs.model.response.ResponseMessage;
import com.pcs.product.service.DeleteProductService;

@Service
public class DeleteProductServiceImpl implements DeleteProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	
	@Override
	public String delete(long id) throws Exception {
		try {
			stockRepository.deleteByProdyctId(id);
			productRepository.delete(id);
			
		} catch (Exception e) {
			/// logger and global exception handling
			throw new Exception(e.getMessage());
		}
		return ResponseMessage.DELETED_PRODUCT;
	}

}
