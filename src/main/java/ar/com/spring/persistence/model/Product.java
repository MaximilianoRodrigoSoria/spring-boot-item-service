package ar.com.spring.persistence.model;

import java.util.Date;



public class Product {
	private long id;
	private String name;
	private Double price;
	private Date cretateAt;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCretateAt() {
		return cretateAt;
	}
	public void setCretateAt(Date cretateAt) {
		this.cretateAt = cretateAt;
	}



}
