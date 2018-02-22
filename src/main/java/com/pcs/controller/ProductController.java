package com.pcs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pcs.model.Product;
import com.pcs.model.response.StringResponse;
import com.pcs.product.service.DeleteProductService;
import com.pcs.product.service.GetProductService;
import com.pcs.product.service.SaveProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private GetProductService getProductService;

	@Autowired
	private SaveProductService saveProductService;

	@Autowired
	private DeleteProductService deleteProductService;

	@GetMapping
	public @ResponseBody List<Product> getAllProducts() {
		return getProductService.findAll();
	}

	@PostMapping(value = "add")
	public StringResponse addProduct(@Valid @RequestBody Product product) throws Exception {
		String message = saveProductService.save(product);
		return new StringResponse(message, HttpStatus.CREATED.toString());
	}

	@GetMapping(value = "stock/{productId}")
	public @ResponseBody Product getProductStock(@PathVariable("productId") long productId) throws Exception {
		Product product = getProductService.findProductStock(productId);
		return product;
	}

	/* This method allows to search usign product name,type,code */
	@GetMapping(value = "search")
	public @ResponseBody List<Product> searchProduct(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "code", required = false) String code) throws Exception {
		Product productEntity = new Product();;
		if(name!=null)
		{
			productEntity.setProductName(name);
		}
		if(type!=null)
		{
			productEntity.setProductType(type);
		}
		if(code!=null)
		{
			productEntity.setProductCode(code);
		}
		List<Product> products= getProductService.searchProducts(productEntity);
		return products;
	}

	@DeleteMapping(value = "delete/{id}")
	public StringResponse deleteProduct(@PathVariable("id") long id) throws Exception {
		String message = deleteProductService.delete(id);
		return new StringResponse(message, HttpStatus.CREATED.toString());
	}

}
