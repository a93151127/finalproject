import com.controller.demo.dao.imp.AccountDaoJdbcImp;
import com.controller.demo.domain.Accounts;
import com.controller.demo.service.AccountService;
import com.controller.demo.service.imp.AccountServiceImp;

public class test {

	public static void main(String[] args) {
		AccountService accountservice=new AccountServiceImp();
		Accounts acc=accountservice.login("a5203983");
		System.out.println(acc);

	}

}
