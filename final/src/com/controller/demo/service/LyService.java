package com.controller.demo.service;

import java.util.List;

import com.controller.demo.domain.Employee;
import com.controller.demo.domain.LeaveMessageTable;
import com.controller.demo.domain.OrdersDetail;

public interface LyService {
	List<LeaveMessageTable> queryAll();
	
	void add(LeaveMessageTable leavemessage);
	List<LeaveMessageTable> queryByStartEnd(int start, int end);
}
