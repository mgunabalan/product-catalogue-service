package com.pcs.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pcs.model.ProductInventory;

@Repository
public interface StockRepository extends JpaRepository<ProductInventory, Long> {

	@Query("FROM ProductInventory pi where pi.productId in (:productIds)")
	List<ProductInventory> getStockByProductIds(@Param("productIds") List<Long> productIds);

	@Transactional
	@Modifying
	@Query("DELETE FROM ProductInventory pi where pi.productId =:productId")
	void deleteByProdyctId(@Param("productId") long productId);

}
