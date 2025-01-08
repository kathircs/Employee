package com.altimetrik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.Entity.Employee;

public interface ProjectRepository extends JpaRepository<Employee, Integer> {
}
