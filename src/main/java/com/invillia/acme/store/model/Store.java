package com.invillia.acme.store.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "store")
public class Store {

	@Id
	public BigInteger id;
	private String name;
	private String address;

	public Store(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Store [name=" + name + ", address=" + address + "]";
	}

}
