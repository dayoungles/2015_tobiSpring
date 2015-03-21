package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao(){
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		return userDao;
	}
	
	public AccountDao accountDao(){
		return new AccountDao(connectionMaker());
	}
	
	public MessageDao messageDao(){
		return new MessageDao(connectionMaker());
	}
	
	//connectionmaker를 한번에 수정할 수 있도록 정리하는 메소드.
	@Bean
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
}
