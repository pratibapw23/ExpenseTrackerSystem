package com.example.expenseTracker.expenseTracker.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="expense")
public class Expense {

	@Id
	private long id;
	
	private Instant expensetime;
	private String description;
	
	public Expense(long id, Instant expensetime, String description) {
		super();
		this.id = id;
		this.expensetime = expensetime;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instant getExpensetime() {
		return expensetime;
	}

	public void setExpensetime(Instant expensetime) {
		this.expensetime = expensetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;

	
}
