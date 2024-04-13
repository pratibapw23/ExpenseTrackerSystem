package com.example.expenseTracker.expenseTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="expense")
public class Expense {

	@Id
	private long id;	
	private String description;
	private String location;
	
	public Expense() {
		super();
	}

	public Expense(long id,String description,String location) {
		super();
		this.id = id;
		this.description = description;
		this.location=location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;

	
}
