package com.controller.demo.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.controller.db.core.PreparedStatementCreator;
import com.controller.db.core.RowCallbackHandler;
import com.controller.db.core.jdbcTemplate;
import com.controller.demo.dao.LyDao;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.LeaveMessageTable;
import com.controller.demo.domain.OrdersDetail;

public class LyDaoImpJdbc implements LyDao{
	LeaveMessageTable lmt=new LeaveMessageTable();
	@Override
	public void create(LeaveMessageTable leavemessage) {
		String sql = "insert into finalproject.ly_table(companyNumber,companyName,title,date,content) values (?,?,?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);
  
                ps.setInt(1, leavemessage.getCompanyNumber());
                ps.setString(2, leavemessage.getCompanyName());
                ps.setString(3, leavemessage.getTitle());
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                String date =sdf.format(new Date());
                ps.setString(4, date);
                ps.setString(5, leavemessage.getContent());
               
                return ps;
            }
        });
		
	}

	@Override
	public List<LeaveMessageTable> findAll() {
		final List<LeaveMessageTable> list = new ArrayList<LeaveMessageTable>();

        String sql = "select * from finalproject.ly_table";

        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

                PreparedStatement ps = conn.prepareStatement(sql);
                return ps;
            }
        }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {

            	LeaveMessageTable customer = new LeaveMessageTable();
                customer.setCompanyNumber(rs.getInt("companyNumber"));
                customer.setCompanyName(rs.getString("companyName"));
                customer.setTitle(rs.getString("title"));
                customer.setDate(rs.getString("date"));
                customer.setContent(rs.getString("content"));
                

                list.add(customer);
            }
        });

        return list;
	}

	@Override
	public boolean checkValidationCode(HttpServletRequest request, String validationCode) {
		String validationCodeSession = (String) request.getSession().getAttribute("validationCode" ) ; 
        if (validationCodeSession == null )
       {

           request.setAttribute("info" , "驗證碼過期" ) ;

           request.setAttribute("codeError", "驗證碼過期" ) ;
            return  false ;
       }
       if (! validationCode.equalsIgnoreCase(validationCodeSession))
       {
           request.setAttribute( "info","驗證碼錯誤" ) ;
           request.setAttribute( "codeError", "驗證碼錯誤" ) ;
            return  false ;
       }
       return  true ;
	}

	@Override
	public List<LeaveMessageTable> findStartEnd(int start, int end) {
		List<LeaveMessageTable> list = new ArrayList<LeaveMessageTable>();

		StringBuffer sql = new StringBuffer("select * from finalproject.ly_table order by date DESC");
        sql.append(" LIMIT ").append(end - start);
        sql.append(" OFFSET ").append(start);

        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            return ps;
        }, rs -> {
        	LeaveMessageTable goods = new LeaveMessageTable();
        	goods.setCompanyNumber(rs.getInt("companyNumber"));
            goods.setCompanyName(rs.getString("companyName"));
            goods.setDate(rs.getString("date"));
            goods.setTitle(rs.getString("title"));
            goods.setContent(rs.getString("content"));
            list.add(goods);

        });

        return list;
	}

}
