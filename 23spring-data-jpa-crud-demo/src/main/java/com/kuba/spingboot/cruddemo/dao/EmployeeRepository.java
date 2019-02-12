package com.kuba.spingboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuba.spingboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// CRUD methods already in JpaRepository
	
}
