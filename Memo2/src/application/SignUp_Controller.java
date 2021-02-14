package application;

import java.io.IOException;

import database.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUp_Controller {

    @FXML
    private PasswordField pw;

    @FXML
    private TextField name;

    @FXML
    private Button Back;

    @FXML
    private TextField id;

    @FXML
    private Button Ok;

    @FXML
    void handle(ActionEvent event) throws IOException {
    	if(event.getSource() == Ok)
    	{
    		String inputName = name.getText();
    		String inputId = id.getText();
    		String inputPw = pw.getText();
    		new UserDAO().signUp(inputName, inputId, inputPw);
    		new NewPage().loadPage("SignIn.fxml");
    	}
    	else if(event.getSource() == Back)
    	{
    		new NewPage().loadPage("SignIn.fxml");	
    	}
    }
}
