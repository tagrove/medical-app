/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Terry
 */
public class ScreenConflictingController implements Initializable {

    
    @FXML private TextField textField1 = new TextField();
    @FXML private TextField textField2 = new TextField();
    @FXML private TextArea resultsField = new TextArea();

    

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    
    }    
    
  @FXML  
  private void mainButtonAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenMain.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
    }
    
  @FXML
  private void searchForConflicting(){
      String med1 = textField1.getText();
      String med2 = textField2.getText();
      System.out.println("Med1 = " + med1 + ".  Med2 = " + med2);
      
      String results = "True or False: " + med1 + " and " + med2 + " conflict";
      resultsField.setText(results);
      resultsField.setEditable(false);
      
      
  }    
}
