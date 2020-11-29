package com.controller.demo.service;

import java.util.List;

import com.controller.demo.domain.Goods;
import com.controller.demo.domain.Orders;
import com.controller.demo.domain.OrdersDetail;

public interface OrdersDetailService {
	List<OrdersDetail> queryAll();

    List<OrdersDetail> queryByStartEnd(int start, int end);
    
    OrdersDetail queryByProductCode(String productCode);
    void delete(int PK);
    OrdersDetail queryByOrderId(int orderId);
}
