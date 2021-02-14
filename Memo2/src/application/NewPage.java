package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewPage {
    void loadPage(String fxmlAddress) throws IOException 
    {
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource(fxmlAddress));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
    }
}
