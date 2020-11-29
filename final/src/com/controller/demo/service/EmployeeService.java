package com.controller.demo.service;

import java.util.List;

import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Employee;
import com.controller.demo.domain.Goods;
import com.controller.demo.domain.ProductLine;

public interface EmployeeService {
    List<Employee> queryAll();
	
	void add(Employee employee);
	
	public Employee queryByOfficeCode(int officeCode);
	
	List<Employee> queryByStartEnd(int start, int end);
	
	boolean login(Employee employee);
	
	void delete(int employeeId);
	
	void update(Employee employee);
	
	public Employee queryById(int id);
}
