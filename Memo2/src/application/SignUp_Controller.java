package application;

import java.io.IOException;

import database.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUp_Controller {

    @FXML
    private PasswordField pw;

    @FXML
    private TextField name;

    @FXML
    private TextField id;

    @FXML
    private Button ok;
    
    @FXML
    private Button back;

    @FXML
    void handle(ActionEvent event) throws IOException  {
    	
    	if(event.getSource() == ok) {
    		String inputName = name.getText();
    		String inputId = id.getText();
    		String inputPw = pw.getText();
    		new UserDAO().signUp(inputName, inputId, inputPw);   		
    		loadPage();
    	}
    	else if(event.getSource() == back) {
    		loadPage();
    	}

    }
    void loadPage() throws IOException {
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("SignInPage.fxml"));
		Scene scene = new Scene(root,340,268);
		primaryStage.setScene(scene);
		primaryStage.show();
    }

}
