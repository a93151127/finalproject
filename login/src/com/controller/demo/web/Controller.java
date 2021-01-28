package com.controller.demo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.demo.domain.Accounts;
import com.controller.demo.service.AccountService;
import com.controller.demo.service.imp.AccountServiceImp;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Controller() {
        
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		int pass=Integer.parseInt(password);
		AccountService accountservice=new AccountServiceImp();
		Accounts acc=accountservice.login(account);
		String msg="";
		/*if(acc.getAccount().equals(account)) {
			if(acc.getPassword()==pass) {
				msg+="登入成功";
			}else{
				msg+="密碼錯誤";
			}
			
		}else*/ 
		if(acc==null){
			msg+="無此帳號";
		}else {
			if(acc.getPassword()==pass) {
				msg+="登入成功";
			}else{
				msg+="密碼錯誤";
			}
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
