package com.controller.demo.dao;

import java.util.List;

import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Office;

public interface OfficeDao {
	void create(Office office);
	void modify(Office office);
	void remove(int officeCode);
	Office findByPk(int pk);
	Office findByOfficeCode(int postalCode);
	List<Office> findAll();
	List<Office> findStartEnd(int start, int end);
}
