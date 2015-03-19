package springbook.user.dao;

public class DaoFactory {
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
	public ConnectionMaker connectionMaker(){
		return new DConnectionMaker();
	}
}
