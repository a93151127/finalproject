package com.controller.demo.service.imp;

import java.util.List;

import com.controller.demo.dao.GoodsDao;
import com.controller.demo.dao.imp.GoodsDaoImpJdbc;
import com.controller.demo.domain.Goods;
import com.controller.demo.service.GoodsService;
import com.controller.demo.service.ServiceException;

public class GoodsServiceImp implements GoodsService {

    GoodsDao goodsDao = new GoodsDaoImpJdbc();

    @Override
    public List<Goods> queryAll() {
        return goodsDao.findAll();
    }

    @Override
    public List<Goods> queryByStartEnd(int start, int end) {
        return goodsDao.findStartEnd(start, end);
    }

    @Override
    public Goods querDetail(String productCode) {
        return goodsDao.findByPk(productCode);
    }

	@Override
	public void register(Goods goods) {
		goodsDao.create(goods);
		
	}

	@Override
	public void delete(String Pk) {
		goodsDao.remove(Pk);
		
	}

	@Override
	public void update(Goods goods) {
		goodsDao.modify(goods);
		
	}

	@Override
	public Goods queryByProductCode(String productCode) {
		return goodsDao.findByPk(productCode);
	}
}
