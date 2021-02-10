package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemoDAO {

	private Connection connect() {
		Connection con = null;
		String user = "root";
		String pw = "qazplm1029";
		String url = "jdbc:mysql://localhost/memo?serverTimezone=UTC";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Database에 연결되었습니다.");
		return con;
	}
	
	public void addMemo(String id, String memo) {
		Connection con = connect();
		PreparedStatement pstmt;
		String query = "Insert into memo(user_id, memo) values = (?,?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, memo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void myMemo() {
		
	}



}
