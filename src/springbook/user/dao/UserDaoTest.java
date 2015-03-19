package springbook.user.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import springbook.user.domain.User;

public class UserDaoTest {

	@Test
	public void testClient() throws ClassNotFoundException, SQLException {
		
		UserDao dao = new DaoFactory().userDao();
		
		User user = new User();
		user.setId("dayg");
		user.setName("dayoungle");
		user.setPassword("day");
		
		dao.add(user);
		
		System.out.println(user.getId()+"등록 성공 ");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() +"조회 성공 ");
		
	}

}
