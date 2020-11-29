package com.controller.demo.service;

import java.util.List;

import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Goods;
import com.controller.demo.domain.Office;
import com.controller.demo.domain.ProductLine;

public interface OfficeService {
	List<Office> queryAll();
	
	void add(Office office);
	
	List<Office> queryByStartEnd(int start, int end);
	
	void delete(int officeCode);
	
	void update(Office office);
	
	public Office queryByOfficeCode(int officeCode);
}
