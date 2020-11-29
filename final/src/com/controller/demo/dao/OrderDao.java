package com.controller.demo.dao;

import java.util.List;

import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Orders;

public interface OrderDao {
	Orders findByPk(int pk);

    List<Orders> findAll();

    void create(Orders orders);

    void modify(Orders orders);

    void remove(int pk);
    
    List<Orders> findStartEnd(int start, int end);
    
    Orders findByCompanyId(int companyId);
}
