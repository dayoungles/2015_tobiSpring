package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{

	
	public Connection makeConnection() throws ClassNotFoundException,
			SQLException {
		//새로운 Connection 생성 코드
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springDB", "root", "ekdudrmf2");
		
		return c;
		
	}
	
}
