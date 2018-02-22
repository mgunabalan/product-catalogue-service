package com.pcs.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcs.jpa.repository.StoreRepository;
import com.pcs.model.Store;
import com.pcs.model.response.ResponseMessage;
import com.pcs.store.service.SaveStoreService;

@Service
public class SaveStoreServiceImpl implements SaveStoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public String save(Store store) throws Exception {
		try {
			storeRepository.save(store);
		} catch (Exception e) {
			/// logger and global exception handling
			throw new Exception(e.getMessage());
		}
		return ResponseMessage.ADDED_STORE;
	}

}
