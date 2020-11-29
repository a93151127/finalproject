package com.controller.demo.dao.imp;

import java.util.List;

import com.controller.db.core.PreparedStatementCreator;
import com.controller.db.core.RowCallbackHandler;
import com.controller.db.core.jdbcTemplate;
import com.controller.demo.dao.CustomerDao;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class CustomerDaoImpJdbc implements CustomerDao{

	@Override
	public void create(Customer customer) {
		 String sql = "insert into customer(companyName,companyTel,companyAddress,companyNumber,companyPeople,email) values (?,?,?,?,?,?)";
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setString(1, customer.getCompanyName());
	                ps.setString(2, customer.getCompanyTel());
	                ps.setString(3, customer.getCompanyAddress());
	                ps.setString(4, customer.getCompanyNumber());
	                ps.setString(5, customer.getCompanyPeople());

	                ps.setString(6,customer.getEmail());

	                return ps;
	            }
	        });
		
	}

	@Override
	public void modify(Customer customer) {
		String sql = "update customer set companyName=?, companyTel=?,companyAddress=?,companyNumber=?, companyPeople=?, email=? where companyId=?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, customer.getCompanyName());
                ps.setString(2, customer.getCompanyTel());
                ps.setString(3, customer.getCompanyAddress());
                ps.setString(4, customer.getCompanyNumber());
                ps.setString(5, customer.getCompanyPeople());

                ps.setString(6, customer.getEmail());
                ps.setInt(7, customer.getCompanyId());

                return ps;
            }
        });
		
	}

	@Override
	public void remove(Customer customer) {
		 String sql = "delete from customer where companyId=?";
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setInt(1, customer.getCompanyId());

	                return ps;
	            }
	        });
		
	}

	@Override
	public Customer findByPk(int pk) {
		 final List<Customer> list = new ArrayList<Customer>();

	        String sql = "select companyName,companyTel,companyAddress,companyNumber,companyPeople,email from customer where companyId=?";

	        jdbcTemplate.query(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

	                PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setInt(1, pk);

	                return ps;
	            }
	        }, new RowCallbackHandler() {
	            @Override
	            public void processRow(ResultSet rs) throws SQLException {

	                Customer customer = new Customer();
	                //customer.setCompanyId(rs.getInt("companyId"));
	                customer.setCompanyId(pk);
	                customer.setCompanyName(rs.getString("companyName"));
	                customer.setCompanyTel(rs.getString("companyTel"));
	                customer.setCompanyAddress(rs.getString("companyAddress"));
	                customer.setCompanyNumber(rs.getString("companyNumber"));
	                customer.setCompanyPeople(rs.getString("companyPeople"));

	                customer.setEmail(rs.getString("email"));

	                list.add(customer);
	            }
	        });

	        if (list.size() == 1) {
	            return list.get(0);
	        }
	        return null;
	}

	@Override
	public List<Customer> findAll() {
		final List<Customer> list = new ArrayList<Customer>();

        String sql = "select * from customer";

        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);
                return ps;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {

                Customer customer = new Customer();
                customer.setCompanyId(rs.getInt("companyId"));
                customer.setCompanyName(rs.getString("companyName"));
                customer.setCompanyAddress(rs.getString("companyAddress"));
                customer.setCompanyNumber(rs.getString("companyNumber"));
                customer.setCompanyPeople(rs.getString("companyPeople"));
                customer.setCompanyTel(rs.getString("companyTel"));
                customer.setEmail(rs.getString("email"));

                list.add(customer);
            }
        });

        return list;
    }

	@Override
	public Customer findByNumber(String number) {
		final List<Customer> list = new ArrayList<Customer>();

        String sql = "select companyId,companyName,companyTel,companyAddress,companyPeople,email from customer where companyNumber=?";

        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,number);

                return ps;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {

                Customer customer = new Customer();
                //customer.setCompanyId(rs.getInt("companyId"));
                customer.setCompanyId(rs.getInt("companyId"));
                customer.setCompanyName(rs.getString("companyName"));
                customer.setCompanyTel(rs.getString("companyTel"));
                customer.setCompanyAddress(rs.getString("companyAddress"));
                customer.setCompanyNumber(number);
                customer.setCompanyPeople(rs.getString("companyPeople"));

                customer.setEmail(rs.getString("email"));

                list.add(customer);
            }
        });

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
	}

	@Override
	public List<Customer> findStartEnd(int start, int end) {
		List<Customer> list = new ArrayList<Customer>();

		StringBuffer sql = new StringBuffer("select * from finalproject.customer");
        sql.append(" LIMIT ").append(end - start);
        sql.append(" OFFSET ").append(start);

        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            return ps;
        }, rs -> {
        	Customer goods = new Customer();
        	goods.setCompanyId(rs.getInt("companyId"));
            goods.setCompanyName(rs.getString("companyName"));
            goods.setCompanyTel(rs.getString("companyTel"));
            goods.setCompanyAddress(rs.getString("companyAddress"));
            goods.setCompanyNumber(rs.getString("companyNumber"));
            goods.setCompanyPeople(rs.getString("companyPeople"));
            goods.setEmail(rs.getString("email"));
            list.add(goods);

        });

        return list;
	}
	

}
