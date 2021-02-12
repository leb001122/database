package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class TapPane_Controller {

    @FXML
    private Button add;

    @FXML
    private Button yes;

    @FXML
    private Text name;

    @FXML
    private Text id;

    @FXML
    private TextArea text;

    @FXML
    void add_handle(ActionEvent event) {
    	if(event.getSource() == add) {
    		String inputMemo = text.getText();
    		
        		
    	}
    	
    }

    @FXML
    void yes_handle(ActionEvent event) {

    }

}

