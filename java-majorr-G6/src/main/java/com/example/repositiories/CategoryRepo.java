package com.example.repositiories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	public Category findByCategoryName(String name);

	public Object save(Optional<Category> cati);
}
