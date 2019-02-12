package com.kuba.spingboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kuba.spingboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entitManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entitManager) {
		this.entitManager = entitManager;
	}

	@Override
	public List<Employee> findAll() {
		
		// create a query	
		Query theQuery = entitManager.createQuery("from Employee");
		
		//execute query and get resultlist
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
		
	}

	@Override
	public Employee findById(int theId) {
		//get employee
		Employee theEmployee =
				entitManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		//save or update the employee
		Employee dbEmployee =
				entitManager.merge(theEmployee); // if id ==0 - insert/save else update
		
		// update with id from db ... so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());
		
	}

	@Override
	public void deleteById(int theId) {
		
		// delete object with primary key
		Query theQuery = entitManager.createQuery("delete from Employee where id=:employeeId ");
		theQuery.setParameter("employeeId", "theId");
		
		theQuery.executeUpdate();
		
	}

}
