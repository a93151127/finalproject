package com.controller.demo.service;

import java.util.List;
import java.util.Map;

import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Goods;
import com.controller.demo.domain.Orders;

public interface OrdersService {
	 String submitOrders(List<Map<String, Object>> cart);
	 List<Orders> queryByStartEnd(int start, int end);
	 List<Orders> queryAll();
	 Orders queryByCompanyId(int companyId);
	 void delete(int pk);
}
