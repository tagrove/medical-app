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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Terry
 */
public class ScreenSymptomsController implements Initializable {

    @FXML TextField textField1 = new TextField();
    @FXML TextField textField2 = new TextField();
    @FXML TextField textField3 = new TextField();
    @FXML TextArea resultsField = new TextArea();
    @FXML Label errorLabel = new Label();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       resultsField.setEditable(false);
       errorLabel.setVisible(false);
       errorLabel.getStyleClass().add("errorLabel");
       resultsField.setFocusTraversable(false);
    }    
    
  @FXML  
  private void mainButtonAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenMain.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      
        Scene otherScene = (Scene) ((Node) event.getSource()).getScene();
        String style = otherScene.getStylesheets().toString();
        style = style.replace("[", "");
        style = style.replace("]", "");
        home_page_scene.getStylesheets().add(style);
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
  @FXML 
  private void searchButtonAction(ActionEvent event) throws IOException {
      
      String symptom1 = textField1.getText();
      String symptom2 = textField2.getText();
      String symptom3 = textField3.getText();
      resultsField.setText("");
      if (symptom1.isEmpty() && symptom2.isEmpty() && symptom3.isEmpty()){
          errorLabel.setVisible(true);
      }else {
      if (errorLabel.isVisible() == true){
          errorLabel.setVisible(false);
      }
      String results = "Results for: " + symptom1 + " " + symptom2 + " "+ symptom3;
      resultsField.setText(results);
      }  
      
      
      
        
    }
    
    
    
    
}
