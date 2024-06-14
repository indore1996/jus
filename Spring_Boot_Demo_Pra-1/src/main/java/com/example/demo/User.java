package com.example.demo;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fname;
	private String lname;
	
	@OneToMany
	private List<Vehicle> vehicles = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public User(String fname, String lname, List<Vehicle> vehicles) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.vehicles = vehicles;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
