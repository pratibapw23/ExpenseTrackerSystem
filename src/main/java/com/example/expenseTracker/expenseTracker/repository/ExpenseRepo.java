package com.example.expenseTracker.expenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expenseTracker.expenseTracker.model.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Long>{

}
