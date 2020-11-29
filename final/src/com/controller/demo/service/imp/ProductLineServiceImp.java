package com.controller.demo.service.imp;

import java.util.List;

import com.controller.demo.dao.GoodsDao;
import com.controller.demo.dao.ProductLineDao;
import com.controller.demo.dao.imp.GoodsDaoImpJdbc;
import com.controller.demo.dao.imp.ProductLineDaoImpJdbc;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.ProductLine;
import com.controller.demo.service.ProductLineService;
import com.controller.demo.service.ServiceException;

public class ProductLineServiceImp implements ProductLineService{
	ProductLineDao productlinedao = new ProductLineDaoImpJdbc();
	@Override
	public List<ProductLine> queryAll() {
		return productlinedao.findAll();
	}

	@Override
	public void add(ProductLine productline) throws ServiceException {
		ProductLine dbCustomer = productlinedao.findByBrand(productline.getBrand());
	       
        
        if (dbCustomer != null) { 
           throw new ServiceException("此廠牌 " + productline.getBrand() + " 已經存在");
       }
       productlinedao.create(productline);
	        
	}

}
