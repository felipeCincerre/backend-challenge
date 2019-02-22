package com.invillia.acme.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.invillia.acme.store.model.Store;

public interface StoreRepository extends MongoRepository<Store, String> {

    public List<Store> findByName(String name);

	public Optional<Store> findById(BigInteger id);

}