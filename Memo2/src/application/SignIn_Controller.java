package application;

import java.io.IOException;

import database.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignIn_Controller {

    @FXML
    private PasswordField pw;

    @FXML
    private Button signIn;

    @FXML
    private TextField id;

    @FXML
    private Button signUp;

    @FXML
    void handle(ActionEvent event) throws IOException {
    	// 로그인
    	if(event.getSource() == signIn) 
    	{
    		String inputId = id.getText();
    		String inputPw = pw.getText();
    		String str = "";
    	
    		int num = new UserDAO().signIn(inputId, inputPw);

    		// 로그인 성공
    		if(num == 1) 
    		{
    			str = "로그인 성공";
    			System.out.println(str);
    			UserInfo user = UserInfo.getInstance();
    			user.setId(inputId);
    			user.setPassWord(inputPw);
    			new NewPage().loadPage("Home.fxml");
    		}
    		// 패스워드 다름
    		else if(num == 0)
    		{
    			str = "패스워드가 틀렸습니다.";
    			showAlert(str);
    		}
    		// 아이디 없음
    		else if(num == -1) 
    		{
    			str = "존재하지 않는 아이디입니다.";
    			showAlert(str);
    		}
    		// 데이터베이스 오류
    		else if(num == -2)
    		{
    			str = "로그인 실패";
    			System.out.println(str);
    		}
    	}
    	// 회원가입
    	else if(event.getSource() == signUp) 
    	{
    		new NewPage().loadPage("SignUp.fxml");
    	}
    }
     
    void showAlert(String str) 
    {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("로그인 실패");
		alert.setContentText(str);
		alert.showAndWait();    	
    }


}
