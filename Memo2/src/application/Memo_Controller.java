package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Memo_Controller {

    @FXML
    private Button logout;

    @FXML
    private TextArea memo;
    
    @FXML
    private Button add;
    

    @FXML
    void handle(ActionEvent event) throws IOException {
    	if(event.getSource() == logout) {
        	Stage primaryStage = new Stage();
    		Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
    		Scene scene = new Scene(root,340,268);
    		primaryStage.setScene(scene);
    		primaryStage.setScene(scene);
    		primaryStage.show();
    	}
    	else if(event.getSource() == add) {
    		String inputMemo = memo.getText();
    		//new MemoDAO().addMemo(, inputMemo);
    	}
    }

}
