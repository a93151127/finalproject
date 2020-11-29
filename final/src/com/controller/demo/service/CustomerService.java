package com.controller.demo.service;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Goods;

import java.util.List;

public interface CustomerService {

   
    boolean login(Customer customer);

    
    void register(Customer customer) throws ServiceException;
    List<Customer> queryByStartEnd(int start, int end);

	List<Customer> queryAll();
	
	Customer queryById(int companyId);
	
	void delete(Customer customer);
	
	void update(Customer customer);
}
