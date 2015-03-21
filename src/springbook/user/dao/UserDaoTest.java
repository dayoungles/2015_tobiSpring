package springbook.user.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class UserDaoTest {

	@Test
	public void testClient() throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		//UserDao dao = new DaoFactory().userDao();
		
		User user = new User();
		user.setId("dayg");
		user.setName("dayoungle");
		user.setPassword("day");
		//이부분 하기 전에 mysql 비워줘야 함. 
		dao.add(user);
		
		System.out.println(user.getId()+"등록 성공 ");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() +"조회 성공 ");
		
	}
	
	@Test
	public void testIdentical(){
		DaoFactory factory = new DaoFactory();
		UserDao dao1 = factory.userDao();
		UserDao dao2 = factory.userDao();
		
		assertEquals(dao1, dao2);//같지 않음. 동일하지 않음.
		
	}
	
	@Test
	public void testEquality(){
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		UserDao dao1 = context.getBean("userDao", UserDao.class);
		UserDao dao2 = context.getBean("userDao", UserDao.class);
		assertEquals(dao1, dao2);//동일함. 패스. 
		
	}

}
