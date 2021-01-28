import com.controller.demo.dao.imp.HibernateUsernameDaoImp;
import com.controller.demo.dao.imp.UsernameDaoJdbcImp;
import com.controller.demo.domain.Username;
import com.controller.demo.service.imp.UsernameServiceImp;

public class test {

	public static void main(String[] args) {
		UsernameServiceImp a=new UsernameServiceImp();
		System.out.println(a.checkUsername("A12"));

	}

}
