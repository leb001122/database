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

public class SignIn_Controller {
    @FXML
    private PasswordField password;

    @FXML
    private Button signIn;

    @FXML
    private TextField id;

    @FXML
    private Button signUp;
    
    @FXML
    void handle(ActionEvent event) throws IOException {
    	
    	if(event.getSource() == signIn) {
    		String inputId = id.getText();
        	String inputPw = password.getText();
        	String s = "";
        	
        	if(new UserDAO().signIn(inputId, inputPw) == 1) {
        		s = "로그인";
        		loadPage("MemoPage.fxml");
    
        	}
        	else 
        		s = "로그인 실패";
        	System.out.println(s);
        	
    	}else if(event.getSource() == signUp) {
    		loadPage("SignUp.fxml");
    	}
    }

    void loadPage(String fxmlAddress) throws IOException {
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource(fxmlAddress));
		Scene scene = new Scene(root,340,268);
		primaryStage.setScene(scene);
		primaryStage.setScene(scene);
		primaryStage.show();
    }


}
