package com.controller.demo.service.imp;

import java.util.List;

import com.controller.demo.dao.CustomerDao;
import com.controller.demo.domain.Customer;
import com.controller.demo.dao.imp.CustomerDaoImpJdbc;
import com.controller.demo.service.CustomerService;
import com.controller.demo.service.ServiceException;

public class CustomerServiceImp implements CustomerService {

    CustomerDao customerDao = new CustomerDaoImpJdbc();

    @Override
    public boolean login(Customer customer) {

        Customer dbCustomer = customerDao.findByNumber(customer.getCompanyNumber());

        if (dbCustomer != null &&
                dbCustomer.getCompanyNumber().equals(customer.getCompanyNumber())) {

            // 把db返回的客户信息返回给表示层
            customer.setCompanyName(dbCustomer.getCompanyName());
            customer.setCompanyTel(dbCustomer.getCompanyTel());
            customer.setCompanyAddress(dbCustomer.getCompanyAddress());
            customer.setCompanyPeople(dbCustomer.getCompanyPeople());

            customer.setEmail(dbCustomer.getEmail());
            new OrdersServiceImp().sendData(customer);
            return true;
        }

        return false;
    }

    @Override
    public void register(Customer customer) throws ServiceException {

        Customer dbCustomer = customerDao.findByNumber(customer.getCompanyNumber());
        //customer.setCompanyName(dbCustomer.getCompanyName());
        if (dbCustomer != null) { //客户ID已经存在了
            throw new ServiceException("此廠商 " + customer.getCompanyName() + " 已經註冊");
        }

        // 注册开始
        customerDao.create(customer);
    }

	@Override
	public List<Customer> queryByStartEnd(int start, int end) {
		return customerDao.findStartEnd(start, end);
	}

	@Override
	public List<Customer> queryAll() {
		return customerDao.findAll();
	}

	@Override
	public void delete(Customer customer) {
		customerDao.remove(customer);
	}

	@Override
	public void update(Customer customer) {
		customerDao.modify(customer);
		
	}

	@Override
	public Customer queryById(int companyId) {
		return customerDao.findByPk(companyId);
	}
}
