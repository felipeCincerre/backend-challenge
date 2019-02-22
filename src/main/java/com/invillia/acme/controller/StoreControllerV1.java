package com.invillia.acme.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.repository.StoreRepository;
import com.invillia.acme.store.model.Store;

@RestController
@RequestMapping("/api/v1")
public class StoreControllerV1 {

	@Autowired
	private StoreRepository repository;

	// Create a Store
	@RequestMapping(value = "/createStore", method = RequestMethod.POST)
	public void createStore(@RequestBody Store store) {
		repository.save(store);
	}

	// Update a Store information
	@PutMapping("/updateStore/{id}")
	public Store updateStore(@RequestBody Store newStore, @PathVariable BigInteger id) {

		return repository.findById(id).map(store -> {
			store.setName(newStore.getName());
			store.setAddress(newStore.getAddress());
			return repository.save(store);
		}).orElseGet(() -> {
			newStore.setId(id);
			return repository.save(newStore);
		});

	}

	// Retrieve a Store by parameters
	@GetMapping("/findStore/{name}")
	public List<Store> getRecognition(@PathVariable("name") String name) {
		return repository.findByName(name);
	}

}
