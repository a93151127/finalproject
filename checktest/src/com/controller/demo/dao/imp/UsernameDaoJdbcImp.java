package com.controller.demo.dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.demo.dao.UsernameDao;
import com.controller.demo.domain.Username;
import com.controller.demo.domain.Username;

public class UsernameDaoJdbcImp implements UsernameDao{
	public static Connection connect() {
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/interview?useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String password="1234";
		
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
	public List<Username> findByUsername(String username) {
		List<Username> list=new ArrayList<Username>();
		String sql="select * from interview.username where username=?";
		Connection conn=connect();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Username name=new Username();
				name.setUsername(username);
				list.add(name);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
