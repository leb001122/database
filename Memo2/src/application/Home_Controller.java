package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.MemoDAO;
import database.MyConn;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Home_Controller {


    @FXML
    private Text name;
    @FXML
    private Text id;
    @FXML
    private Button add;
    @FXML
    private Button yes;
    @FXML
    private TextArea text;
    @FXML
    private Tab userInfo;
    @FXML
    private Tab memoList;
    @FXML
    private Button edit;
    @FXML
    private TextArea list;
    private UserInfo user = UserInfo.getInstance();

    @FXML
    void event(Event event) {
    
    	if(userInfo.isSelected())
    	{
    		name.setText(getName());
    		id.setText(user.getId()); 
    	}
    	else if(memoList.isSelected())
    	{
    		list.setText(new MemoDAO().editMemo(user.getId()));    		
    	}
    }
    // 메모 추가
    @FXML
    void add_handle(ActionEvent event) 
    {
    	if(event.getSource() == add)
    	{
    		new MemoDAO().addMemo(user.getId(), text.getText());
    	}
    }
    // 로그아웃
    @FXML
    void yes_handle(ActionEvent event) throws IOException 
    {
    	new NewPage().loadPage("SignIn.fxml");
    }
    // 메모 편집
    @FXML
    void edit_handle(ActionEvent event)
    {
    	if(event.getSource() == edit)
    	{
    		
    	}
    } 
    
    String getName() 
    {
    	Connection con = MyConn.connect();
    	PreparedStatement pstmt;
    	ResultSet rs = null;
    	String query = "Select name from user where id=?";
    	String str = null;
    	try {
    		pstmt = con.prepareStatement(query);
    		str = user.getId();
    		pstmt.setString(1, user.getId());
    		rs = pstmt.executeQuery();
    		if(rs.next()) {
    			return rs.getString(1);	
    		}
    		rs.close();
    		pstmt.close();
    		con.close();
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	return "실패";
    }
}
