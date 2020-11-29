package com.controller.demo.service;

import java.util.List;

import com.controller.demo.domain.ProductLine;



public interface ProductLineService {
	List<ProductLine> queryAll();
	
	void add(ProductLine productline) throws ServiceException;
}
