package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	// 로그인
	public int signIn(String id, String pw) {
		
		Connection con = MyConn.connect();
		System.out.println("확인");
		PreparedStatement pstmt;
		ResultSet rs;
		String query = "Select password From user where id=?";
		
		try 
		{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				if(rs.getString(1).equals(pw)) 
				{
					rs.close();
					pstmt.close();
					con.close();
					return 1; // 로그인 성공
				}
				else 
				{
					rs.close();
					pstmt.close();
					con.close();
					return 0; // 패스워드 다름
				}
			}
			rs.close();
			pstmt.close();
			con.close();
			return -1; // 아이디 없음
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return -2; // 데이터베이스 오류
	}
	
	// 회원가입
	public void signUp(String name, String id, String pw) 
	{
		Connection con = MyConn.connect();
		PreparedStatement pstmt;
		String query = "Insert into user(name, id, password) values (?,?,?)";
		
		try
		{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.execute();
			pstmt.close();
			con.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
























