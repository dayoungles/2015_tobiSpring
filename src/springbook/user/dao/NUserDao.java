package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao{
	//에러 날 수밖에 없어서 일단 넣어줌. 정리됐으니까 이게 있을 필요가 없음. 
	public NUserDao(ConnectionMaker connectionMaker) {
		super(connectionMaker);
		
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springDB", "root", "ekdudrmf2");
		
		return c;
	}
}
