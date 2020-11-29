package com.controller.demo.service.imp;

import java.util.List;

import com.controller.demo.dao.GoodsDao;
import com.controller.demo.dao.OrdersDetailDao;
import com.controller.demo.dao.imp.GoodsDaoImpJdbc;
import com.controller.demo.dao.imp.OrdersDetailDaoImpJdbc;
import com.controller.demo.domain.OrdersDetail;
import com.controller.demo.service.OrdersDetailService;

public class OrdersDetailServiceImp implements OrdersDetailService {
	OrdersDetailDao goodsDao = new OrdersDetailDaoImpJdbc();
	@Override
	public List<OrdersDetail> queryAll() {
		return goodsDao.findAll();
	}

	@Override
	public List<OrdersDetail> queryByStartEnd(int start, int end) {
		 return goodsDao.findStartEnd(start, end);
	}

	@Override
	public OrdersDetail queryByProductCode(String productCode) {
		return goodsDao.findByProductCode(productCode);
	}

	@Override
	public void delete(int PK) {
		goodsDao.remove(PK);
		
	}

	@Override
	public OrdersDetail queryByOrderId(int orderId) {
		return goodsDao.findByOrderId(orderId);
	}

}
