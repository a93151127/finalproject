package com.controller.demo.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.controller.demo.domain.LeaveMessageTable;
import com.controller.demo.domain.OrdersDetail;

public interface LyDao {
	void create(LeaveMessageTable leavemessage);
	
	List<LeaveMessageTable> findAll();
	
	public  boolean checkValidationCode(HttpServletRequest request ,
            String validationCode);
	
	List<LeaveMessageTable> findStartEnd(int start, int end);
}
