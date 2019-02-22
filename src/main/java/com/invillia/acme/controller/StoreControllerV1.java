package com.invillia.acme.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.repository.StoreRepository;
import com.invillia.acme.store.model.Store;

@RestController
public class StoreControllerV1 {
	
	
	@Autowired
	private StoreRepository repository;
	
	@RequestMapping(method = RequestMethod.POST,  value =  "/api/v1/stores")
    public void addStore(@RequestBody Store store){
    	repository.save(store);
    }

    @PutMapping("/api/v1/store/{id}")
    public ResponseEntity<Object> updateStore(@RequestBody Store store, @PathVariable BigInteger id) {

    	Optional<Store> storeOptional = repository.findById(id);
    	if (!storeOptional.isPresent())
    		return ResponseEntity.notFound().build();

    	store.setId(id);
    	repository.save(store);
    	return ResponseEntity.noContent().build();
    }
    
	@RequestMapping("/store/{name}")
    public List<Store> getRecognition(@PathVariable("name") String name){
        return repository.findByName(name);
    }

    @RequestMapping("/colleagues")
    public List<Store> getStores(){
        return repository.findAll();
    }

}
