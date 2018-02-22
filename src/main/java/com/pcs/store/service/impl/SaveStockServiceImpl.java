package com.pcs.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcs.jpa.repository.StockRepository;
import com.pcs.model.ProductInventory;
import com.pcs.model.response.ResponseMessage;
import com.pcs.stock.service.SaveStockService;

@Service
public class SaveStockServiceImpl implements SaveStockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public String save(ProductInventory stock) throws Exception {
		try {
			stockRepository.save(stock);
		} catch (Exception e) {
			/// logger and global exception handling
			throw new Exception(e.getMessage());
		}
		return ResponseMessage.ADDED_STOCK;
	}

}
