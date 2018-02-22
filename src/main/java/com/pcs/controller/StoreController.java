package com.pcs.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcs.model.Store;
import com.pcs.model.response.StringResponse;
import com.pcs.store.service.GetStoreService;
import com.pcs.store.service.SaveStoreService;

@RestController
@RequestMapping(value = "/store")
public class StoreController {

	@Autowired
	private GetStoreService getStoreService;

	@Autowired
	private SaveStoreService saveStoreService;

	@PostMapping(value = "add")
	public StringResponse addStore(@Valid @RequestBody Store store) throws Exception {
		String message = saveStoreService.save(store);
		return new StringResponse(message, HttpStatus.CREATED.toString());
	}

	@GetMapping
	public List<Store> getStores() throws Exception {
		return getStoreService.findAll();
	}

}
