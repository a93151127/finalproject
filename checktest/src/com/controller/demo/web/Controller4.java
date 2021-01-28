package com.controller.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.demo.service.UsernameService;
import com.controller.demo.service.imp.UsernameServiceImp;

@WebServlet("/Controller4")
public class Controller4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsernameService name=new UsernameServiceImp();

    public Controller4() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		boolean str=name.checkUsername(username);
		if(str) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("此帳號已有人使用");
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("此帳號可以註冊");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
