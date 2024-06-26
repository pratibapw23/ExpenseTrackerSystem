package com.example.expenseTracker.expenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expenseTracker.expenseTracker.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{

	Category findByName(String name);
}
