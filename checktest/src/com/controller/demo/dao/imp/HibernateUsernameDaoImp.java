package com.controller.demo.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.controller.demo.dao.UsernameDao;
import com.controller.demo.domain.Username;
import com.controller.demo.domain.Username;

public class HibernateUsernameDaoImp implements UsernameDao{
	public List<Username> findByUsername(String username){
		SessionFactory factory=new Configuration()
							   .configure("hibernate.cfg.xml")
							   .addAnnotatedClass(Username.class)
							   .buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			List<Username> name=session
					.createQuery("from Username s where s.username='"+username+"'").list();
			session.getTransaction().commit();
			return name;
		}finally {
			factory.close();
		}
	}

	
}
