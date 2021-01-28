package com.controller.demo.dao;

import java.util.List;

import com.controller.demo.domain.Username;
import com.controller.demo.domain.Username;

public interface UsernameDao {
	public List<Username> findByUsername(String username);
	
}
