package com.pcs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcs.model.ProductInventory;
import com.pcs.model.response.StringResponse;
import com.pcs.stock.service.SaveStockService;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

	
	@Autowired
	private SaveStockService saveStockService;

	@PostMapping(value = "add")
	public StringResponse addStok(@Valid @RequestBody ProductInventory stock) throws Exception {
		String message = saveStockService.save(stock);
		return new StringResponse(message, HttpStatus.CREATED.toString());
	}
	

}
