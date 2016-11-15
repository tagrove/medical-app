/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medapp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;
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
public class ScreenTreatmentController implements Initializable {
    
    @FXML TextField textField = new TextField();
    @FXML TextArea resultsField = new TextArea();
    @FXML Label errorLabel = new Label();
    /**
     * Initializes the controller class.
     */
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
  private void searchButtonAction(ActionEvent event) throws IOException, SQLException {
      
      String illness = textField.getText();
      System.out.println("Illness = " + illness);
      resultsField.setText("");
      
      if (illness.isEmpty()){
          errorLabel.setVisible(true);
          System.out.println("No illness entered!");
      } else {
          if (errorLabel.isVisible() == true){
                errorLabel.setVisible(false);
            }
          
        String host = "jdbc:mysql://localhost:3306/medical_app?verifyServerCertificate=false&useSSL=true";
        String uName = "root";
        String uPass= "csci490pass";
        Connection con = DriverManager.getConnection(host, uName, uPass);
        System.out.println("Working");
        Statement stmt = con.createStatement(); 
	ResultSet rs = stmt.executeQuery("select treatments from medical_app.illness where illnessName ='" + illness + "'");    
	System.out.println("Results:\n\n");
        String treatString = "";
        //put the ResultSet into the string treatString
	while (rs.next()) {
            treatString = rs.getString("treatments");
	}
        String printList = "";
        Scanner in = new Scanner(treatString).useDelimiter(", ");
        //creates a string called treatList that capitalizes the first letter of each treatment
        //then creates a string called printList that has a numbered list of each treatment
    	for(int i = 1;in.hasNext(); i++){
    		String treatList = in.next();
    		treatList = treatList.substring(0, 1).toUpperCase() + treatList.substring(1);
    		System.out.println(i + ". " + treatList);
    		printList = printList + i + ". " + treatList + "\n";
    	}    
        //if the results from the query are empty then the illness is not in the database
        if(printList.equals("")){
            System.out.println("No treatments for illness " + illness);
            resultsField.setText("No treatments for illness " + illness);
        }else{
            resultsField.setText(printList);
        }
      }  
    }
}
