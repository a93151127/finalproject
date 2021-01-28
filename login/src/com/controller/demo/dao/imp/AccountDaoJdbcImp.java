package com.controller.demo.dao.imp;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import com.controller.demo.dao.AccountDao;
import com.controller.demo.domain.Accounts;


public class AccountDaoJdbcImp implements AccountDao{
	public static Connection connection() {
		String url="jdbc:mysql://localhost:3306/interview?useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String password="1234";
		List<Accounts> list=new ArrayList<Accounts>();
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			
			System.out.println("no connection");
		} catch (ClassNotFoundException e) {
		
			System.out.println("no driver");
		}

		return conn;
	}

	@Override
	public Accounts findByPk(String account) {
		String sql="select password from interview.accounts where account=?";
		Connection conn=connection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,account);
			Accounts accounts=new Accounts();
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				accounts.setAccount(account);
				accounts.setPassword(rs.getInt("password"));
				return accounts;
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

}
