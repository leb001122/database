package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemoDAO {

	// 메모추가
	public void addMemo(String id, String memo)
	{
		Connection con = MyConn.connect();
		PreparedStatement pstmt;
		String query = "Insert into memo(user_id, memo) values (?,?)";
		
		try 
		{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, memo);
			
			pstmt.execute();
			pstmt.close();
			con.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	//메모 목록
	public String editMemo(String user_id) 
	{
		Connection con = MyConn.connect();
		PreparedStatement pstmt;
		ResultSet rs;
		String query = "select memo from memo where user_id = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
