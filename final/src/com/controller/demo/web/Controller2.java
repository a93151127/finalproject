package com.controller.demo.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.demo.dao.imp.CustomerDaoImpJdbc;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Employee;
import com.controller.demo.domain.Goods;
import com.controller.demo.domain.LeaveMessageTable;
import com.controller.demo.domain.Office;
import com.controller.demo.domain.Orders;
import com.controller.demo.domain.OrdersDetail;
import com.controller.demo.service.CustomerService;
import com.controller.demo.service.EmployeeService;
import com.controller.demo.service.GoodsService;
import com.controller.demo.service.LyService;
import com.controller.demo.service.OfficeService;
import com.controller.demo.service.OrdersDetailService;
import com.controller.demo.service.OrdersService;
import com.controller.demo.service.ServiceException;
import com.controller.demo.service.imp.CustomerServiceImp;
import com.controller.demo.service.imp.EmployeeServiceImp;
import com.controller.demo.service.imp.GoodsServiceImp;
import com.controller.demo.service.imp.LyServiceImp;
import com.controller.demo.service.imp.OfficeServiceImp;
import com.controller.demo.service.imp.OrdersDetailServiceImp;
import com.controller.demo.service.imp.OrdersServiceImp;


@WebServlet("/Controller2")
public class Controller2 extends HttpServlet {
	
	 	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    private CustomerService customerService = new CustomerServiceImp();
	    private GoodsService goodsService = new GoodsServiceImp();
	    private OrdersService ordersService = new OrdersServiceImp();
	    private EmployeeService employeeservice=new EmployeeServiceImp();
	    private OfficeService officeservice=new OfficeServiceImp();
	    private OrdersDetailService ordersdetailservice=new OrdersDetailServiceImp();
	    int goodsid=1;
	    private LyService ly=new LyServiceImp();
	    private int totalPageNumber = 0; // 总页数
	    private int pageSize = 10; // 每页行数
	    private int currentPage = 1; // 当前页数
	    private static final long serialVersionUID = 1L;
	    Customer customer = new Customer();
	    Employee employee=new Employee();
        public Controller2() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if ("list".equals(action)) {
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
            request.getRequestDispatcher("products_list.jsp").forward(request, response);

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
            request.getRequestDispatcher("products_list.jsp").forward(request, response);

        }else if ("orderlist".equals(action)) {
            //------------商品列表--------------
            List<Orders> goodsList = ordersService.queryAll();

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
            request.getRequestDispatcher("orders_list.jsp").forward(request, response);

        } else if ("orderspaging".equals(action)) {
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

            List<Orders> goodsList = ordersService.queryByStartEnd(start, end);

            request.setAttribute("totalPageNumber", totalPageNumber);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("goodsList", goodsList);
            request.getRequestDispatcher("orders_list.jsp").forward(request, response);

        }else if ("employeelist".equals(action)) {
            //------------商品列表--------------
            List<Employee> goodsList = employeeservice.queryAll();

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
            request.getRequestDispatcher("employee_list.jsp").forward(request, response);

        } else if ("employeepaging".equals(action)) {
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

            List<Employee> goodsList = employeeservice.queryByStartEnd(start, end);

            request.setAttribute("totalPageNumber", totalPageNumber);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("goodsList", goodsList);
            request.getRequestDispatcher("employee_list.jsp").forward(request, response);

        }else if ("officelist".equals(action)) {
            //------------商品列表--------------
            List<Office> goodsList = officeservice.queryAll();
           

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
            request.getRequestDispatcher("office_list.jsp").forward(request, response);
        } else if ("officepaging".equals(action)) {
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

            List<Office> goodsList = officeservice.queryByStartEnd(start, end);

            request.setAttribute("totalPageNumber", totalPageNumber);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("goodsList", goodsList);
            request.getRequestDispatcher("office_list.jsp").forward(request, response);

        }else if ("companylist".equals(action)) {
            //------------商品列表--------------
            List<Customer> goodsList = customerService.queryAll();

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
            request.getRequestDispatcher("company_list.jsp").forward(request, response);

        } else if ("companypaging".equals(action)) {
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

            List<Customer> goodsList = customerService.queryByStartEnd(start, end);

            request.setAttribute("totalPageNumber", totalPageNumber);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("goodsList", goodsList);
            request.getRequestDispatcher("company_list.jsp").forward(request, response);

        }else if ("ordersdetaillist".equals(action)) {
            //------------商品列表--------------
        	List<OrdersDetail> goodsList = ordersdetailservice.queryAll();

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
            request.getRequestDispatcher("ordersDetail_list.jsp").forward(request, response);

        } else if ("ordersdetailpaging".equals(action)) {
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

            List<OrdersDetail> goodsList = ordersdetailservice.queryByStartEnd(start, end);

            request.setAttribute("totalPageNumber", totalPageNumber);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("goodsList", goodsList);
            request.getRequestDispatcher("ordersDetail_list.jsp").forward(request, response);

        }else if ("productreg".equals(action)) {
            // -----------客户注册------------
        	Goods goods=new Goods();
            String productCode = request.getParameter("productCode");
            String productName = request.getParameter("productName");
            String productBrand = request.getParameter("productBrand");
            String productDescription = request.getParameter("productDescription");
            String buyPrice = request.getParameter("buyPrice");
            String productLine =request.getParameter("productLine");
            String image1 = request.getParameter("image1");
            

            // 服务器端验证
            List<String> errors = new ArrayList<>();
            if (productCode == null || productCode.equals("")) {
                errors.add("產品編號不能为空！");
            }
            if (productName == null || productName.equals("")) {
                errors.add("產品名稱不能为空！");
            }


            if (productBrand == null || productBrand.equals("")) {
                errors.add("產品品牌不能为空！");
            }
            if (buyPrice == null || buyPrice.equals("")) {
                errors.add("產品售價不能为空！");
            }

            if (errors.size() > 0) { // 验证失败
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("add_product.jsp").forward(request, response);
            } else { // 验证成功
                Integer Line=Integer.parseInt(productLine);
            	goods.setProductCode(productCode);
            	goods.setProductName(productName);
            	goods.setProductBrand(productBrand);
            	goods.setProductDescription(productDescription);
            	goods.setBuyPrice(buyPrice);
            	goods.setProductLint(Line);
            
            	goods.setImage1(image1);
                
                
                
				goodsService.register(goods);
				request.getRequestDispatcher("main2.jsp").forward(request, response);
				
                
                

            }
        }else if ("employeereg".equals(action)) {
            // -----------客户注册------------
        	Employee employee=new Employee();
            String employeeName = request.getParameter("employeeName");
            String employeeTel = request.getParameter("employeeTel");
            String email = request.getParameter("email");
            String jobTitle = request.getParameter("jobTitle");
            String officeCode = request.getParameter("officeCode");
            

            // 服务器端验证
            List<String> errors = new ArrayList<>();
            if (employeeName == null || employeeName.equals("")) {
                errors.add("員工姓名不能为空！");
            }
            if (employeeTel == null || employeeTel.equals("")) {
                errors.add("員工電話不能为空！");
            }


            if (jobTitle == null || jobTitle.equals("")) {
                errors.add("職務不能为空！");
            }
            if (officeCode == null || officeCode.equals("")) {
                errors.add("辦公室編號不能为空！");
            }

            if (errors.size() > 0) { // 验证失败
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("add_employee.jsp").forward(request, response);
            } else { // 验证成功
                Integer Line=Integer.parseInt(officeCode);
                employee.setEmployeeName(employeeName);
                employee.setEmployeeTel(employeeTel);
                employee.setEmail(email);
                employee.setJobTitle(jobTitle);
                employee.setOfficeCode(Line);
               
                
                
                
                employeeservice.add(employee);
				request.getRequestDispatcher("main2.jsp").forward(request, response);
				
                
                

            }
        }else if ("officereg".equals(action)) {
            // -----------客户注册------------
        	Office office=new Office();
            String city = request.getParameter("city");
            String officeAddress = request.getParameter("officeAddress");
            String postalCode = request.getParameter("postalCode");
            
            

            // 服务器端验证
            List<String> errors = new ArrayList<>();
            if (city == null || city.equals("")) {
                errors.add("城市不能为空！");
            }
            if (officeAddress == null || officeAddress.equals("")) {
                errors.add("辦公室地址不能为空！");
            }


            if (postalCode == null || postalCode.equals("")) {
                errors.add("郵遞區號不能为空！");
            }
            

            if (errors.size() > 0) { // 验证失败
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("add_office.jsp").forward(request, response);
            } else { // 验证成功
                Integer Line=Integer.parseInt(postalCode);
                
                office.setCity(city);
                office.setOfficeAddress(officeAddress);
                office.setPostalCode(Line);
               
                
                
                
                
					officeservice.add(office);
					request.getRequestDispatcher("main2.jsp").forward(request, response);
				
				
				
                
                

            }
        }else if ("login".equals(action)) {
            //------------客户登录--------------
            String employeeId = request.getParameter("employeeId");
            String employeeName = request.getParameter("employeeName");

            //Customer customer = new Customer();
            Integer ei=Integer.parseInt(employeeId);
            employee.setEmployeeId(ei);
            employee.setEmployeeName(employeeName);
            
            if (employeeservice.login(employee)) { // 登录成功
                HttpSession session = request.getSession();
                //CustomerDaoImpJdbc cdij=new CustomerDaoImpJdbc();
                //customer.setCompanyId(cdij.findByNumber(companyNumber).getCompanyId());
                session.setAttribute("employee", employee);
                request.getRequestDispatcher("main2.jsp").forward(request, response);
            } else { // 登录失败
                List<String> errors = new ArrayList<>();
                errors.add("您輸入的員工編號不正確！");
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("login2.jsp").forward(request, response);
            }

        }else if ("columnlist".equals(action)) {
            //------------商品列表--------------
        	List<LeaveMessageTable> goodsList = ly.queryAll();

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
            request.getRequestDispatcher("column_list.jsp").forward(request, response);

        } else if ("columnpaging".equals(action)) {
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

            List<LeaveMessageTable> goodsList = ly.queryByStartEnd(start, end);

            request.setAttribute("totalPageNumber", totalPageNumber);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("goodsList", goodsList);
            request.getRequestDispatcher("column_list.jsp").forward(request, response);

        }else if ("companyDel".equals(action)) {
            //--------------进入主页面--------------------
            String companyId=request.getParameter("companyId");
            Integer id=Integer.parseInt(companyId);
            Orders orders=ordersService.queryByCompanyId(id);
            if(orders==null) {
            	Customer c=new Customer();
            	c.setCompanyId(id);
            	customerService.delete(c);
            	request.getRequestDispatcher("main2.jsp").forward(request, response);
            }else {
            	request.getRequestDispatcher("undel_company.jsp").forward(request, response);
            }
        }else if ("productDel".equals(action)) {
            //--------------进入主页面--------------------
            String productCode=request.getParameter("productCode");
            OrdersDetail orders=ordersdetailservice.queryByProductCode(productCode);
            
            if(orders==null) {
            	goodsService.delete(productCode);
            	request.getRequestDispatcher("main2.jsp").forward(request, response);
            }else {
            	request.getRequestDispatcher("undel_product.jsp").forward(request, response);
            }
        }else if ("employeeDel".equals(action)) {
            //--------------进入主页面--------------------
            String employeeId=request.getParameter("employeeId");
            Integer id=Integer.parseInt(employeeId);
           
            employeeservice.delete(id);
            request.getRequestDispatcher("main2.jsp").forward(request, response);
           
        }else if ("officeDel".equals(action)) {
            //--------------进入主页面--------------------
            String officeCode=request.getParameter("officeCode");
            Integer id=Integer.parseInt(officeCode);
            Employee orders=employeeservice.queryByOfficeCode(id);
            if(orders==null) {
            	officeservice.delete(id);
            	request.getRequestDispatcher("main2.jsp").forward(request, response);
            }else {
            	request.getRequestDispatcher("undel_office.jsp").forward(request, response);
            }
        }else if ("orderDel".equals(action)) {
            //--------------进入主页面--------------------
            String orderId=request.getParameter("orderId");
            Integer id=Integer.parseInt(orderId);
            OrdersDetail order=ordersdetailservice.queryByOrderId(id);
            if(order==null) 
            {         
            	ordersService.delete(id);
            	request.getRequestDispatcher("main2.jsp").forward(request, response);
            }else {
            	ordersdetailservice.delete(id);
            	ordersService.delete(id);
            	request.getRequestDispatcher("main2.jsp").forward(request, response);
            }
        }else if ("logout".equals(action)) {
            //-----------注销-----------------------
            // 清空购物车
            request.getSession().removeAttribute("cart");
            // 清除登录信息
            request.getSession().removeAttribute("employee");
            request.getRequestDispatcher("index.html").forward(request, response);
        }else if ("companyFind".equals(action)) {
        	List<Customer> list=new ArrayList<Customer>();
        	String companyId2=request.getParameter("companyId");
            Integer id=Integer.parseInt(companyId2);
            Customer customer=customerService.queryById(id);
            list.add(customer);
            request.setAttribute("list",list);
            request.getRequestDispatcher("company_update.jsp").forward(request,response);
           
        }else if ("companyUpdate".equals(action)) {
        	String companyId=request.getParameter("companyId");
        	
        	
        	String companyName=request.getParameter("companyName");
        	String companyAddress=request.getParameter("companyAddress");
        	String companyTel=request.getParameter("companyTel");
        	String email=request.getParameter("email");
        	String companyNumber=request.getParameter("companyNumber");
        	String companyPeople=request.getParameter("companyPeople");
        	Integer id=Integer.parseInt(companyId);
        	Customer c=new Customer();
        	c.setCompanyId(id);
        	c.setCompanyName(companyName);
        	c.setCompanyTel(companyTel);
        	c.setCompanyAddress(companyAddress);
        	c.setEmail(email);
        	c.setCompanyNumber(companyNumber);
        	c.setCompanyPeople(companyPeople);
        	customerService.update(c);
        	request.getRequestDispatcher("update_complete.jsp").forward(request, response);
        }else if ("employeeFind".equals(action)) {
        	List<Employee> list=new ArrayList<Employee>();
        	String employeeId=request.getParameter("employeeId");
            Integer id=Integer.parseInt(employeeId);
            Employee customer=employeeservice.queryById(id);
            list.add(customer);
            request.setAttribute("list",list);
            request.getRequestDispatcher("employee_update.jsp").forward(request,response);
           
        }else if ("employeeUpdate".equals(action)) {
        	String employeeId=request.getParameter("employeeId");
        	
        	
        	String employeeName=request.getParameter("employeeName");
        	String employeeTel=request.getParameter("employeeTel");
        	String email=request.getParameter("email");
        	String jobTitle=request.getParameter("jobTitle");
        	String officeCode=request.getParameter("officeCode");
        	
        	Integer id=Integer.parseInt(employeeId);
        	Employee c=new Employee();
        	Integer code=Integer.parseInt(officeCode);
        	c.setEmployeeId(id);
        	c.setEmployeeName(employeeName);
        	c.setEmployeeTel(employeeTel);
        	c.setEmail(email);
        	c.setJobTitle(jobTitle);
        	c.setOfficeCode(code);
        	employeeservice.update(c);
        	request.getRequestDispatcher("update_complete.jsp").forward(request, response);
        }else if ("productFindFind".equals(action)) {
        	List<Goods> list=new ArrayList<Goods>();
        	String productCode=request.getParameter("productCode");
           
            Goods customer=goodsService.queryByProductCode(productCode);
            list.add(customer);
            request.setAttribute("list",list);
            request.getRequestDispatcher("product_update.jsp").forward(request,response);
           
        }else if ("productUpdate".equals(action)) {
        	String productCode=request.getParameter("productCode");
        	
        	
        	String productName=request.getParameter("productName");
        	String productLine=request.getParameter("productLine");
        	String productDescription=request.getParameter("productDescription");
        	String buyPrice=request.getParameter("buyPrice");
        	String image1=request.getParameter("image1");
        	String productBrand=request.getParameter("productBrand");
        	Integer line=Integer.parseInt(productLine);
        	Goods c=new Goods();
        	
        	c.setProductCode(productCode);
        	c.setProductName(productName);
        	c.setProductLint(line);
        	c.setProductDescription(productDescription);
        	c.setBuyPrice(buyPrice);
        	c.setImage1(image1);
        	c.setProductBrand(productBrand);
        	goodsService.update(c);
        	request.getRequestDispatcher("update_complete.jsp").forward(request, response);
        }else if ("officeFind".equals(action)) {
        	List<Office> list=new ArrayList<Office>();
        	String officeCode=request.getParameter("officeCode");
        	Integer code=Integer.parseInt(officeCode);
           
            Office customer=officeservice.queryByOfficeCode(code);
            list.add(customer);
            request.setAttribute("list",list);
            request.getRequestDispatcher("office_update.jsp").forward(request,response);
           
        }else if ("officeUpdate".equals(action)) {
        	String officeCode=request.getParameter("officeCode");
        	
        	
        	String city=request.getParameter("city");
        	String officeAddress=request.getParameter("officeAddress");
        	String postalCode=request.getParameter("postalCode");
        	
        	Integer line=Integer.parseInt(officeCode);
        	Office c=new Office();
        	Integer code=Integer.parseInt(postalCode);
        	c.setOfficeCode(line);
        	c.setCity(city);
        	c.setOfficeAddress(officeAddress);
        	c.setPostalCode(code);
        	
        	officeservice.update(c);
        	request.getRequestDispatcher("update_complete.jsp").forward(request, response);
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
