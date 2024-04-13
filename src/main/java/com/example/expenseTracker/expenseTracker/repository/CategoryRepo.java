package com.example.expenseTracker.expenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expenseTracker.expenseTracker.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
