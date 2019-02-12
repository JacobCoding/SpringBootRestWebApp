package com.kuba.spingboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuba.spingboot.cruddemo.dao.EmployeeRepository;
import com.kuba.spingboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	// before @Qualifier two beans EmployeeDAOJpaImpl.class] ,EmployeeDAOHibernateImpl.class]  - one has to be specified
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) { 
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		// new approach from Java8
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()){
			theEmployee = result.get();
		}else{
			throw new RuntimeException("Did not find the employee - " + theId );
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}

