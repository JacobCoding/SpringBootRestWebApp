package com.kuba.spingboot.cruddemo.dao;

import java.util.List;

import com.kuba.spingboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}

