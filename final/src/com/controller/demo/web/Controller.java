package com.controller.demo.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.controller.demo.dao.LyDao;
import com.controller.demo.dao.imp.CustomerDaoImpJdbc;
import com.controller.demo.dao.imp.LyDaoImpJdbc;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Goods;
import com.controller.demo.domain.LeaveMessageTable;
import com.controller.demo.service.CustomerService;
import com.controller.demo.service.GoodsService;
import com.controller.demo.service.LyService;
import com.controller.demo.service.OrdersService;
import com.controller.demo.service.ServiceException;
import com.controller.demo.service.imp.CustomerServiceImp;
import com.controller.demo.service.imp.GoodsServiceImp;
import com.controller.demo.service.imp.LyServiceImp;
import com.controller.demo.service.imp.OrdersServiceImp;




@WebServlet("/Controller")
public class Controller extends HttpServlet {
	  private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    private CustomerService customerService = new CustomerServiceImp();
	    private GoodsService goodsService = new GoodsServiceImp();
	    private OrdersService ordersService = new OrdersServiceImp();
	    private LeaveMessageTable ly=new LeaveMessageTable();
	    private LyService lys=new LyServiceImp();
	    int goodsid=1;
	    private int totalPageNumber = 0;
	    private int pageSize = 10;
	    private int currentPage = 1;
	    private static final long serialVersionUID = 1L;
	    Customer customer = new Customer();
    public Controller() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String action = request.getParameter("action");

	        if ("reg".equals(action)) {
	          
	            String companyName = request.getParameter("companyName");
	            String companyTel = request.getParameter("companyTel");
	            String companyNumber = request.getParameter("companyNumber");
	            String companyNumber2 = request.getParameter("companyNumber2");
	            String companyAddress = request.getParameter("companyAddress");
	            String companyPeople = request.getParameter("companyPeople");
	            String email = request.getParameter("email");

	         
	            List<String> errors = new ArrayList<>();
	            if (companyName == null || companyName.equals("")) {
	                errors.add("廠商名稱不能为空！");
	            }
	            if (companyTel == null || companyTel.equals("")) {
	                errors.add("廠商電話不能为空！");
	            }
	            if (companyNumber == null
	                    || companyNumber2 == null
	                    || !companyNumber.equals(companyNumber2)) {
	                errors.add("两次输入的統一編號不一致！");
	            }

	            if (companyAddress == null || companyAddress.equals("")) {
	                errors.add("廠商地址不能为空！");
	            }

	            if (errors.size() > 0) { // 验证失败
	                request.setAttribute("errors", errors);
	                request.getRequestDispatcher("customer_reg.jsp").forward(request, response);
	            } else { // 验证成功
	                
	                customer.setCompanyName(companyName);
	                customer.setCompanyTel(companyTel);
	                customer.setCompanyNumber(companyNumber);
	                customer.setCompanyAddress(companyAddress);
	                customer.setCompanyPeople(companyPeople);
	                //customer.setEmployeeId(1);
	                customer.setEmail(email);
	                
	                // 注册
	                try {
	                    // 注册成功
	                    customerService.register(customer);
	                    request.getRequestDispatcher("login.jsp").forward(request, response);
	                } catch (ServiceException e) {
	                    // 客户ID已经注册
	                    errors.add("此廠商已经注册！");
	                    request.setAttribute("errors", errors);
	                    request.getRequestDispatcher("customer_reg.jsp").forward(request, response);
	                }

	            }
	        }else if ("login".equals(action)) {
	            //------------客户登录--------------
	            String companyName = request.getParameter("companyName");
	            String companyNumber = request.getParameter("companyNumber");

	            //Customer customer = new Customer();
	            customer.setCompanyName(companyName);
	            customer.setCompanyNumber(companyNumber);
	            
	            if (customerService.login(customer)) { // 登录成功
	                HttpSession session = request.getSession();
	                CustomerDaoImpJdbc cdij=new CustomerDaoImpJdbc();
	                customer.setCompanyId(cdij.findByNumber(companyNumber).getCompanyId());
	                session.setAttribute("customer", customer);
	                request.getRequestDispatcher("main.jsp").forward(request, response);
	            } else { // 登录失败
	                List<String> errors = new ArrayList<>();
	                errors.add("您輸入的統一編號不正確！");
	                request.setAttribute("errors", errors);
	                request.getRequestDispatcher("login.jsp").forward(request, response);
	            }

	        }else if ("list".equals(action)) {
	            //------------商品列表--------------
	            List<Goods> goodsList = goodsService.queryAll();

	            if (goodsList.size() % pageSize == 0) {
	                totalPageNumber = goodsList.size() / pageSize;
	            } else {
	                totalPageNumber = goodsList.size() / pageSize + 1;
	            }

	            request.setAttribute("totalPageNumber", totalPageNumber);
	            request.setAttribute("currentPage", currentPage);

	            int start = (currentPage - 1) * pageSize;
	            int end = currentPage * pageSize;
	            if (currentPage == totalPageNumber) { // 最后一页
	                end = goodsList.size();
	            }

	            request.setAttribute("goodsList",goodsList.subList(start, end));
	            request.getRequestDispatcher("goods_list.jsp").forward(request, response);

	        } else if ("paging".equals(action)) {
	            //------------商品列表分页--------------
	            String page = request.getParameter("page");

	            if (page.equals("prev")) { //上一页
	                currentPage--;
	                if (currentPage < 1) {
	                    currentPage = 1;
	                }
	            } else if (page.equals("next")) {// 下一页
	                currentPage++;
	                if (currentPage > totalPageNumber) {
	                    currentPage = totalPageNumber;
	                }
	            } else {
	                currentPage = Integer.valueOf(page);
	            }
	            int start = (currentPage - 1) * pageSize;
	            int end = currentPage * pageSize;

	            List<Goods> goodsList = goodsService.queryByStartEnd(start, end);

	            request.setAttribute("totalPageNumber", totalPageNumber);
	            request.setAttribute("currentPage", currentPage);
	            request.setAttribute("goodsList", goodsList);
	            request.getRequestDispatcher("goods_list.jsp").forward(request, response);

	        }else if ("detail".equals(action)) {
	            //----------查看商品详细------------
	            String productCode = request.getParameter("id");
	            Goods goods = goodsService.querDetail(productCode);

	            request.setAttribute("goods", goods);
	            request.getRequestDispatcher("goods_detail.jsp").forward(request, response);

	        }else if ("add".equals(action)) {
	            //----------添加购物车------------
	            String productCode = request.getParameter("id");
	            String productName = request.getParameter("name");
	            int buyPrice =Integer.parseInt(request.getParameter("price"));

	            // 购物车结构是List中包含Map，每一个Map是一个商品
	            // 从Session中取出的购物车
	            List<Map<String, Object>> cart = (List<Map<String, Object>>) request.getSession().getAttribute("cart");

	            if (cart == null) { // 第一次取出是null
	                cart = new ArrayList<Map<String, Object>>();
	                request.getSession().setAttribute("cart", cart);
	            }

	            // 购物车中有选择的商品
	            int flag = 0;
	            for (Map<String, Object> item : cart) {
	                String productCode2 = (String) item.get("productCode");
	                if (productCode.equals(productCode2)) {

	                    Integer quantityOrder = (Integer) item.get("quantityOrder");
	                    quantityOrder++;
	                    item.put("quantityOrder", quantityOrder);

	                    flag++;
	                }
	            }
	         
	            // 购物车中没有选择的商品
	            if (flag == 0) {
	                Map<String, Object> item = new HashMap<>();
	                // item 结构是Map [商品id，商品名称，价格，数量]
	                item.put("companyId",customer.getCompanyId());
	                item.put("goodsid",goodsid);
	                item.put("productCode",productCode);
	                item.put("productName", productName);
	                item.put("quantityOrder", 1);
	                item.put("buyPrice", buyPrice);
	                goodsid++;
	                // 添加到购物车
	                cart.add(item);
	                
	            }

	            System.out.println(cart);
	            
	            String pagename = request.getParameter("pagename");

	            
	                int start = (currentPage - 1) * pageSize;
	                int end = currentPage * pageSize;

	                List<Goods> goodsList = goodsService.queryByStartEnd(start, end);

	                request.setAttribute("totalPageNumber", totalPageNumber);
	                request.setAttribute("currentPage", currentPage);
	                request.setAttribute("goodsList", goodsList);
	                request.getRequestDispatcher("goods_list.jsp").forward(request, response);

	           
	        }else if ("cart".equals(action)) {
	            //---------查看购物车---------
	            // 从Session中取出的购物车
	            List<Map<String, Object>> cart = (List<Map<String, Object>>) request.getSession().getAttribute("cart");

	            double total = 0.0;

	            if (cart != null) {
	                for (Map<String, Object> item : cart) {

	                    Integer quantity = (Integer) item.get("quantityOrder");
	                    Integer buyPrice = (Integer) item.get("buyPrice");
	                    Integer subtotal = buyPrice * quantity;
	                    total += subtotal;
	                }
	            }

	            request.setAttribute("total", total);
	            request.getRequestDispatcher("cart.jsp").forward(request, response);
	        }else if ("sub_ord".equals(action)) {
	            //------------提交订单-----------
	            // 从Session中取出的购物车
	            List<Map<String, Object>> cart = (List<Map<String, Object>>) request.getSession().getAttribute("cart");
	            for (Map<String, Object> item : cart) {
	                int good = (int) item.get("goodsid");
	                String strquantity = request.getParameter("quantity_" + good);
	                int quantity = 0;
	                try {
	                    quantity = new Integer(strquantity);
	                } catch (Exception e) {
	                }

	                item.put("quantityOrder", quantity);
	            }

	            // 提交订单
	            String ordersid2 = ordersService.submitOrders(cart);
	            request.setAttribute("ordersid2", ordersid2);
	            request.getRequestDispatcher("order_finish.jsp").forward(request, response);
	            // 清空购物车
	            request.getSession().removeAttribute("cart");
	        }else if ("main".equals(action)) {
	            //--------------进入主页面--------------------
	            request.getRequestDispatcher("main.jsp").forward(request, response);
	        }else if ("comment".equals(action)) {
	        	request.setCharacterEncoding("UTF-8" ) ;
	            response.setContentType( "UTF-8" );  
	            LyDao ld=new LyDaoImpJdbc();	          
	          
	                String validationCode = request.getParameter("validationCode" ) ; 

	                if ( ld.checkValidationCode(request, validationCode)) {
	                	String companyNumber = request.getParameter("companyNumber");
	    	            String companyName = request.getParameter("companyName");
	    	            String title = request.getParameter("title");
	    	            String content = request.getParameter("content");
	    	            Integer number=Integer.parseInt(companyNumber);
	    	            ly.setCompanyName(companyName);
	    	            ly.setTitle(title);
	    	            ly.setCompanyNumber(number);
	    	            ly.setContent(content);
	    	            lys.add(ly);
	                    request.getRequestDispatcher("main3.jsp").forward(request, response);
	                }else {
	                
	                	request.getRequestDispatcher("codeError.jsp").forward(request,response);
	                	
	                }
	        	
               
	        }else if ("column".equals(action)) {
	            //--------------进入主页面--------------------
	            request.getRequestDispatcher("main3.jsp").forward(request, response);
	        }else if ("logout".equals(action)) {
	            //-----------注销-----------------------
	            // 清空购物车
	            request.getSession().removeAttribute("cart");
	            // 清除登录信息
	            request.getSession().removeAttribute("customer");
	            request.getRequestDispatcher("index.html").forward(request, response);
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// 獲取表單中引數
		String sname = request.getParameter("sname");//中文不亂碼
		doGet(request, response);
	}

}
