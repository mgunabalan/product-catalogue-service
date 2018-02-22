package com.pcs.jpa.repository;

import org.springframework.stereotype.Repository;

import com.pcs.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>,JpaSpecificationExecutor<Product> {
	
	List<Product> findAll();
	
	
}
