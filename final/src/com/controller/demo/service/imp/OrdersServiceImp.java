package com.controller.demo.service.imp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.controller.demo.dao.GoodsDao;
import com.controller.demo.dao.OrderDao;
import com.controller.demo.dao.OrdersDetailDao;
import com.controller.demo.dao.imp.GoodsDaoImpJdbc;
import com.controller.demo.dao.imp.OrderDaoImpJdbc;
import com.controller.demo.dao.imp.OrdersDetailDaoImpJdbc;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Goods;
import com.controller.demo.domain.Orders;
import com.controller.demo.domain.OrdersDetail;
import com.controller.demo.service.OrdersService;

public class OrdersServiceImp implements OrdersService {

    GoodsDao goodsDao = new GoodsDaoImpJdbc();
    OrderDao orderDao = new OrderDaoImpJdbc();
    OrdersDetailDao ordersdetaildao = new OrdersDetailDaoImpJdbc();
    Orders orders=new Orders();
    public void sendData(Customer customer) {
    	
    	orders.setCompanyId(customer.getCompanyId());
    	
    }

    @Override
    public String submitOrders(List<Map<String, Object>> cart) {

        //Orders orders = new Orders();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date =sdf.format(new Date());
        Date date2=new Date(); //取时间 
		Calendar   calendar = new GregorianCalendar(); 
		calendar.setTime(date2); 
		calendar.add(calendar.DATE,1);
		date2=calendar.getTime(); 
		String date3=sdf.format(date2);
      
        String ordersid=String.valueOf((int) (Math.random() * 100000));
        orders.setOrderId(Integer.parseInt(ordersid));
        orders.setOrderDate(date);
        orders.setShipDate(date3);
       
        int amount=0;
        int i=0;
        for (Map item : cart) {
           	        		
            String productcode =(String) item.get("productCode");
            Integer quantity = (Integer) item.get("quantityOrder");
            Goods goods = goodsDao.findByPk(productcode);
           
            int subtotal = quantity * (Integer.parseInt(goods.getBuyPrice()));
            amount += subtotal;
            int companyId=(int)item.get("companyId");
            if(i==0) {
            	orders.setCompanyId(companyId);
            	orders.setAmount(Integer.toString(amount));
            	orderDao.create(orders);
            	OrdersDetail ordersdetail = new OrdersDetail();
            	ordersdetail.setProductCode(productcode);
            	ordersdetail.setQuantityOrder(Integer.toString(quantity));
            	ordersdetail.setPriceEach(goods.getBuyPrice());
            	ordersdetail.setOrderId(Integer.parseInt(ordersid));
            	
            	ordersdetaildao.create(ordersdetail);
            	i++;
            }else {
            	 OrdersDetail ordersdetail = new OrdersDetail();
                 ordersdetail.setProductCode(productcode);
                 ordersdetail.setQuantityOrder(Integer.toString(quantity));
                 ordersdetail.setPriceEach(goods.getBuyPrice());
                 ordersdetail.setOrderId(Integer.parseInt(ordersid));
           
                 ordersdetaildao.create(ordersdetail);
            }
        	
        }
        
        orders.setAmount(Integer.toString(amount));
       
        orderDao.modify(orders);
        String ordersid2=Integer.toString(orders.getOrderId());
        return ordersid2;
    }

	@Override
	public List<Orders> queryByStartEnd(int start, int end) {
		return orderDao.findStartEnd(start, end);
	}

	@Override
	public List<Orders> queryAll() {
		return orderDao.findAll();
	}

	@Override
	public Orders queryByCompanyId(int companyId) {
		return orderDao.findByCompanyId(companyId);
	}

	@Override
	public void delete(int pk) {
		orderDao.remove(pk);
		
	}
}
