package com.example.expenseTracker.expenseTracker.model;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	private long id;
	
	@NonNull
	private String name;
	

	public Category() {
		super();
	}

	public Category(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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
	
//	@ManyToOne(cascade=CascadeType.PERSIST)
//	private User user;
	
	
}
