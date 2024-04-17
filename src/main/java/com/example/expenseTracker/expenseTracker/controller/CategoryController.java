package com.example.expenseTracker.expenseTracker.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/category/{id}")
	ResponseEntity<?> getCategory(@PathVariable long id){
		Optional<Category> cat=categoryRepo.findById(id);
		return cat.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
