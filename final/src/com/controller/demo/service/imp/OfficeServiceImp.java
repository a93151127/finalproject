package com.controller.demo.service.imp;

import java.util.List;

import com.controller.demo.dao.OfficeDao;
import com.controller.demo.dao.ProductLineDao;
import com.controller.demo.dao.imp.OfficeDaoImpJdbc;
import com.controller.demo.dao.imp.ProductLineDaoImpJdbc;
import com.controller.demo.domain.Office;
import com.controller.demo.domain.ProductLine;
import com.controller.demo.service.OfficeService;
import com.controller.demo.service.ServiceException;

public class OfficeServiceImp implements OfficeService{
	OfficeDao officedao = new OfficeDaoImpJdbc();
	@Override
	public List<Office> queryAll() {
		return officedao.findAll();
	}

	@Override
	public void add(Office office){
		
       officedao.create(office);
		
	}

	@Override
	public List<Office> queryByStartEnd(int start, int end) {
		return officedao.findStartEnd(start, end);
	}

	@Override
	public void delete(int officeCode) {
		officedao.remove(officeCode);
		
	}

	@Override
	public void update(Office office) {
		officedao.modify(office);
		
	}

	@Override
	public Office queryByOfficeCode(int officeCode) {
		return officedao.findByPk(officeCode);
	}

}
