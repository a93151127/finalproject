import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.controller.demo.dao.imp.CustomerDaoImpJdbc;
import com.controller.demo.dao.imp.EmployeeDaoImpJdbc;
import com.controller.demo.dao.imp.LyDaoImpJdbc;
import com.controller.demo.dao.imp.OfficeDaoImpJdbc;
import com.controller.demo.dao.imp.OrderDaoImpJdbc;
import com.controller.demo.dao.imp.OrdersDetailDaoImpJdbc;
import com.controller.demo.dao.imp.ProductLineDaoImpJdbc;
import com.controller.demo.domain.Customer;
import com.controller.demo.domain.Employee;
import com.controller.demo.domain.LeaveMessageTable;
import com.controller.demo.domain.Office;
import com.controller.demo.domain.ProductLine;
import com.controller.demo.service.ServiceException;
import com.controller.demo.service.imp.CustomerServiceImp;
import com.controller.demo.service.imp.EmployeeServiceImp;
import com.controller.demo.service.imp.GoodsServiceImp;
import com.controller.demo.service.imp.LyServiceImp;
import com.controller.demo.service.imp.OfficeServiceImp;
import com.controller.demo.service.imp.OrdersDetailServiceImp;
import com.controller.demo.service.imp.OrdersServiceImp;
import com.controller.demo.service.imp.ProductLineServiceImp;

public class test {

	public static void main(String[] args) {

		OrdersDetailDaoImpJdbc osi=new OrdersDetailDaoImpJdbc();
		osi.remove(27788);
	}

}
