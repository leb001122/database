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
    	// �α���
    	if(event.getSource() == signIn) 
    	{
    		String inputId = id.getText();
    		String inputPw = pw.getText();
    		String str = "";
    	
    		int num = new UserDAO().signIn(inputId, inputPw);

    		// �α��� ����
    		if(num == 1) 
    		{
    			str = "�α��� ����";
    			System.out.println(str);
    			UserInfo user = UserInfo.getInstance();
    			user.setId(inputId);
    			user.setPassWord(inputPw);
    			new NewPage().loadPage("Home.fxml");
    		}
    		// �н����� �ٸ�
    		else if(num == 0)
    		{
    			str = "�н����尡 Ʋ�Ƚ��ϴ�.";
    			showAlert(str);
    		}
    		// ���̵� ����
    		else if(num == -1) 
    		{
    			str = "�������� �ʴ� ���̵��Դϴ�.";
    			showAlert(str);
    		}
    		// �����ͺ��̽� ����
    		else if(num == -2)
    		{
    			str = "�α��� ����";
    			System.out.println(str);
    		}
    	}
    	// ȸ������
    	else if(event.getSource() == signUp) 
    	{
    		new NewPage().loadPage("SignUp.fxml");
    	}
    }
     
    void showAlert(String str) 
    {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("�α��� ����");
		alert.setContentText(str);
		alert.showAndWait();    	
    }


}
