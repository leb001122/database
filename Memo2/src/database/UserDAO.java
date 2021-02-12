package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {	
	
	private Connection connect()  {
		Connection con = null;
		String user = "root";
		String pw = "qazplm1029";
		String url = "jdbc:mysql://localhost/memo?serverTimezone=UTC";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}

		System.out.println("Database�� ����Ǿ����ϴ�.");
		return con;
	}
	// ȸ������
	public void signUp(String name, String id, String pw) {
		Connection con = connect();
		PreparedStatement pstmt;
		
		String query = "INSERT INTO user(name, id, password) VALUES (?,?,?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.executeUpdate();	
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// �α���
	public int signIn(String id, String password) {
		Connection con = connect();
		PreparedStatement pstmt;
		ResultSet rs;
		String query = "Select password From user Where id=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(password)) 
					return 1; //�α��� ����
				else  
					return 0; //�α��� ����
			}
			return -1; //���̵� ����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -2; //�����ͺ��̽� ����
		
	}
	

}
