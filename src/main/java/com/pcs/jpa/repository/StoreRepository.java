package com.pcs.jpa.repository;

import org.springframework.stereotype.Repository;

import com.pcs.model.Store;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
	List<Store> findAll();

	@Query("FROM Store s where s.storeId in (:soreIds)") 
	List<Store> getStoreByIds(@Param("soreIds") List<Long> soreIds);
}
