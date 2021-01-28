package com.controller.demo.dao;

import com.controller.demo.domain.Accounts;

public interface AccountDao{
	public Accounts findByPk(String account);
}

