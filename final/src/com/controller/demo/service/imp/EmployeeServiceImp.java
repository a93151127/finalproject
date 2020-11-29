package com.controller.demo.service.imp;

import java.util.List;

import com.controller.demo.dao.EmployeeDao;
import com.controller.demo.dao.ProductLineDao;
import com.controller.demo.dao.imp.EmployeeDaoImpJdbc;
import com.controller.demo.dao.imp.ProductLineDaoImpJdbc;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Employee;
import com.controller.demo.domain.Goods;
import com.controller.demo.domain.ProductLine;
import com.controller.demo.service.EmployeeService;
import com.controller.demo.service.ServiceException;

public class EmployeeServiceImp implements EmployeeService{
	EmployeeDao employeelinedao = new EmployeeDaoImpJdbc();
	@Override
	public List<Employee> queryAll() {
		return employeelinedao.findAll();
	}

	@Override
	public void add(Employee employee) {
		
       employeelinedao.create(employee);
		
	}

	@Override
	public Employee queryByOfficeCode(int officeCode) {
		return employeelinedao.findByOfficeCode(officeCode);
	}

	@Override
	public List<Employee> queryByStartEnd(int start, int end) {
		return employeelinedao.findStartEnd(start, end);
	}

	@Override
	public boolean login(Employee employee) {
		 Employee dbCustomer = employeelinedao.findByPk(employee.getEmployeeId());

	        if (dbCustomer != null &&
	                dbCustomer.getEmployeeId()==employee.getEmployeeId()) {

	            // 把db返回的客户信息返回给表示层
	        	employee.setEmployeeId(dbCustomer.getEmployeeId());
	        	employee.setEmployeeName(dbCustomer.getEmployeeName());
	        	employee.setEmployeeTel(dbCustomer.getEmployeeTel());
	        	employee.setEmail(dbCustomer.getEmail());
	        	employee.setJobTitle(dbCustomer.getJobTitle());
	        	employee.setOfficeCode(dbCustomer.getOfficeCode());
	            //new OrdersServiceImp().sendData(customer);
	            return true;
	        }

	        return false;
	}

	@Override
	public void delete(int employeeId) {
		employeelinedao.remove(employeeId);
		
	}

	@Override
	public void update(Employee employee) {
		employeelinedao.modify(employee);
		
	}

	@Override
	public Employee queryById(int id) {
		return employeelinedao.findByPk(id);
	}

}
