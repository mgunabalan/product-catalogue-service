package com.pcs.stock.service;

import com.pcs.model.ProductInventory;

public interface SaveStockService   {

	String save(ProductInventory stock) throws Exception;

}
