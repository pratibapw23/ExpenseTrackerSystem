package com.example.expenseTracker.expenseTracker.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expenseTracker.expenseTracker.model.Category;
import com.example.expenseTracker.expenseTracker.repository.CategoryRepo;

@RestController
@RequestMapping("/api")
public class CategoryController {

	private CategoryRepo categoryRepo;
	
	//Constructor based dependency Injection
	public CategoryController(CategoryRepo categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}
	
	@GetMapping("/categories")
	Collection<Category> categories(){
		//Select * from categories
		return categoryRepo.findAll();
	}
}
