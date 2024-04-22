package com.example.expenseTracker.expenseTracker.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/category")
	ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) throws URISyntaxException{
		Category res=categoryRepo.save(category);
		return ResponseEntity.created(new URI("/api/category" + res.getId())).body(res);
	}
	
	@PutMapping("/category/{id}")
	ResponseEntity<Category>  updatecategory(@Validated @RequestBody Category category){
		Category result=categoryRepo.save(category);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/category/{id}")
	ResponseEntity<?> deleteCategory(@PathVariable long id){
		categoryRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
