package com.controller.demo.service.imp;

import com.controller.demo.dao.AccountDao;
import com.controller.demo.dao.imp.AccountDaoJdbcImp;
import com.controller.demo.domain.Accounts;
import com.controller.demo.service.AccountService;

public class AccountServiceImp implements AccountService{
	AccountDao accountdao=new AccountDaoJdbcImp();

	@Override
	public Accounts login(String account) {
		return accountdao.findByPk(account);
	}

}
