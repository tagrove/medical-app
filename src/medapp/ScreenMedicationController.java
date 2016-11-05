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
public class ScreenMedicationController implements Initializable {

    @FXML private TextField textField = new TextField();
    @FXML private TextArea resultsField = new TextArea();
    @FXML private Label errorLabel = new Label();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      resultsField.setEditable(false);
      resultsField.setFocusTraversable(false);

      errorLabel.setVisible(false);
      errorLabel.getStyleClass().add("errorLabel");
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
  private void searchForMedication(){
      
      resultsField.setText("");
      if (textField.getText().isEmpty()){
          System.out.println("Empty medication!");
          
          errorLabel.setVisible(true);
      }else {
          // Troy, search the database for that medication
          
        errorLabel.setVisible(false);
        String medication = textField.getText();
        String results = "Results from searching for: " + medication;
        System.out.println("Searching for medication: " + medication);
        resultsField.appendText(results);
      }
      
  }
}
