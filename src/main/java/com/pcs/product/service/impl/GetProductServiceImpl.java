package com.pcs.product.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pcs.jpa.repository.ProductRepository;
import com.pcs.jpa.repository.StockRepository;
import com.pcs.jpa.repository.StoreRepository;
import com.pcs.model.Product;
import com.pcs.model.ProductInventory;
import com.pcs.model.Store;
import com.pcs.product.service.GetProductService;

@Service
public class GetProductServiceImpl implements GetProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private StoreRepository storeRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findProductStock(long productId) {
		List<Long> pids = new ArrayList<Long>();
		pids.add(productId);

		List<ProductInventory> stocks = stockRepository.getStockByProductIds(pids);

		List<Long> storeIds = stocks.stream().map(ProductInventory::getStoreId).collect(Collectors.toList());

		List<Store> stores = storeRepository.getStoreByIds(storeIds);

		for (ProductInventory p : stocks) {
			stores.stream().filter(s -> p.getStoreId() == (s.getStoreId())).forEach(s -> s.setStock(p.getStock()));
		}

		Product product = productRepository.findOne(productId);
		product.setStore(stores);
		return product;
	}

	@Override
	public List<Product> searchProducts(Product productEntity) {
		List<Product> products = retrieveProducts(productEntity);

		List<Long> pIds = products.stream().map(Product::getProductId).collect(Collectors.toList());
		List<ProductInventory> stocks = stockRepository.getStockByProductIds(pIds);
		List<Long> storeIds = stocks.stream().map(ProductInventory::getStoreId).collect(Collectors.toList());
		List<Store> stores = storeRepository.getStoreByIds(storeIds);
		for (ProductInventory p : stocks) {
			stores.stream().filter(s -> p.getStoreId() == (s.getStoreId())).forEach(s -> s.setStock(p.getStock()));
			products.stream().filter(s -> p.getProductId() == (s.getProductId())).forEach(s -> s.setStore(stores));
		}

		return products;
	}

	private List<Product> retrieveProducts(Product filter) {

		List<Product> products = productRepository.findAll(new Specification<Product>() {

			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();

				if (filter.getProductName() != null) {
					predicates.add(cb.equal(root.get("productName"), filter.getProductName()));
				}
				if (filter.getProductCode() != null) {
					predicates.add(cb.equal(root.get("productCode"), filter.getProductCode()));
				}
				if (filter.getProductType() != null) {
					predicates.add(cb.equal(root.get("productType"), filter.getProductType()));
				}

				return cb.and(predicates.toArray(new Predicate[0]));
			}

		});
		return products;
	}

}
