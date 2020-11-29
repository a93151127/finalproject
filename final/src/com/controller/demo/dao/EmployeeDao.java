package com.controller.demo.dao;

import java.util.List;

import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Employee;

public interface EmployeeDao {
	void create(Employee employee);
	void modify(Employee employee);
	void remove(int employeeId);
	Employee findByPk(int pk);
	Employee findByOfficeCode(int officeCode);
	List<Employee> findAll();
	List<Employee> findStartEnd(int start, int end);
}
