package com.altimetrik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}