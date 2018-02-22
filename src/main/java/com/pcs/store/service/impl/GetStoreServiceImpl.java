package com.pcs.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcs.jpa.repository.StoreRepository;
import com.pcs.model.Store;
import com.pcs.store.service.GetStoreService;

@Service
public class GetStoreServiceImpl implements GetStoreService{
	
	@Autowired
	private StoreRepository storeRepository;

	public List<Store> findAll() {
		return storeRepository.findAll();
	}

}
