package org.anusha.hibernate;

import java.util.Date;

import org.anusha.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("Anusha");
		user.setAddress("giddalur");
		user.setJoinedDate(new Date());
		user.setDescription("software Employee");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
		user = null;
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class,1);
		System.out.println("user name retrived is " + user.getUserName());
	}
}
