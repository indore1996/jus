package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String year;
	private String brand;
	private String model;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Vehicle(String year, String brand, String model) {
		super();
		this.year = year;
		this.brand = brand;
		this.model = model;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
