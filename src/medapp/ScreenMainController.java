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
import javafx.stage.Stage;

/**
 *
 * @author Terry
 */
public class ScreenMainController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void optionsButtonAction(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenOptions.fxml"));
        Scene home_page_scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.setTitle("E-EMT");
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @FXML
    private void medicationsButtonAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenMedications.fxml"));
        Scene home_page_scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.setTitle("E-EMT");
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @FXML
    private void conflictingButtonAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenConflicting.fxml"));
        Scene home_page_scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.setTitle("E-EMT");
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @FXML
    private void sideeffectsButtonAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenSideeffects.fxml"));
        Scene home_page_scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.setTitle("E-EMT");
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @FXML
    private void treatmentButtonAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenTreatments.fxml"));
        Scene home_page_scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.setTitle("E-EMT");
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    @FXML
    private void symptomsButtonAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenSymptoms.fxml"));
        Scene home_page_scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.setTitle("E-EMT");
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
     @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenLogin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.setTitle("E-EMT");
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
