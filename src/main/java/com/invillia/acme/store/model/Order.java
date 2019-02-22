package com.invillia.acme.store.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {

	@Id
	public BigInteger id;
	private String address;
	private Date portabilityExpectedDate;
	private String status;
	List<OrderItem> items;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getPortabilityExpectedDate() {
		return portabilityExpectedDate;
	}
	public void setPortabilityExpectedDate(Date portabilityExpectedDate) {
		this.portabilityExpectedDate = portabilityExpectedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "Order [address=" + address + ", portabilityExpectedDate=" + portabilityExpectedDate + ", status="
				+ status + ", items=" + items + "]";
	}

}
