package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MyConn {
	
//	private static Connection myConn;
//	
//	public static Connection getInstance() {
//		if(myConn == null)
//		{
//			myConn = new MyConn();
//		}
//		return myConn;
//	}
	
	private MyConn() {}
	
	public static Connection connect() {
		Connection con = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost/memo?serverTimezone=UTC";
		String user = "root";
		String password = "qazplm1029";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Database에 연결되었습니다.");
		return con;
		
	}
}
