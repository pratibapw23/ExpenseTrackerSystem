package com.example.expenseTracker.expenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expenseTracker.expenseTracker.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	User findByName(String name);
}
