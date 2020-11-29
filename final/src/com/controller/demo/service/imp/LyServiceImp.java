package com.controller.demo.service.imp;

import java.util.List;

import com.controller.demo.dao.LyDao;
import com.controller.demo.dao.imp.LyDaoImpJdbc;
import com.controller.demo.domain.LeaveMessageTable;
import com.controller.demo.service.LyService;

public class LyServiceImp implements LyService{
	LyDao ld=new LyDaoImpJdbc();
	@Override
	public List<LeaveMessageTable> queryAll() {
		return ld.findAll();
	}

	@Override
	public void add(LeaveMessageTable leavemessage) {
		ld.create(leavemessage);
		
	}

	@Override
	public List<LeaveMessageTable> queryByStartEnd(int start, int end) {
		return ld.findStartEnd(start, end);
	}

}
