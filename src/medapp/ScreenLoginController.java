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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Terry
 */
public class ScreenLoginController implements Initializable {

    @FXML TextField usernameField = new TextField();
    @FXML PasswordField passwordField = new PasswordField();
    @FXML Label errorLabel = new Label();
    @FXML Label signupErrorLabel = new Label();
    
    @FXML TextField newUserField = new TextField();
    @FXML TextField newPasswordField = new TextField();
    @FXML TextField newPasswordConfirm = new TextField();
    @FXML TextField newEmail = new TextField();
    
    @FXML Label newUserFieldError = new Label();
    @FXML Label newPasswordFieldError = new Label();
    @FXML Label passwordConfirmError = new Label();
    @FXML Label emailError = new Label();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabel.setVisible(false);
        
        signupErrorLabel.setVisible(false);
        
        
        newUserFieldError.setVisible(false);
        
        
        passwordConfirmError.setVisible(false);
        
        
        newPasswordFieldError.setVisible(false);
        
        
        emailError.setVisible(false);        
        
        
        errorLabel.getStyleClass().add("errorLabel");
        
        
    }    
    @FXML
    private void signupButtonAction(ActionEvent event) throws IOException {
        String email = newEmail.getText();
        String newUsername = newUserField.getText();
        String newPassword = newPasswordField.getText();
        String passwordConfirm = newPasswordConfirm.getText();
        
        if (email.isEmpty()){
            emailError.setText("Email Required");
            emailError.setVisible(true);
        } else {
            emailError.setVisible(false);
        }
        if (newUsername.isEmpty()){
            newUserFieldError.setText("Username Required");
            newUserFieldError.setVisible(true);
        } else {
            newUserFieldError.setVisible(false);
        }
        if (newPassword.isEmpty()){
            newPasswordFieldError.setText("Password Required");
            newPasswordFieldError.setVisible(true);
        } else {
            newPasswordFieldError.setVisible(false);
        }
        if (passwordConfirm.isEmpty() && !newPassword.isEmpty() ){
            passwordConfirmError.setText("Confirm Password");
            passwordConfirmError.setVisible(true);
        } else if ((!passwordConfirm.equalsIgnoreCase(newPassword))){
            passwordConfirmError.setText("Passwords do not match");
            passwordConfirmError.setVisible(true);
            
        } else {
            passwordConfirmError.setVisible(false);   
        }
        
    }
    
    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if (username.isEmpty() && password.isEmpty()){  
            errorLabel.setText("Please enter username and password");
            errorLabel.setVisible(true);
        } else if (username.isEmpty()){
            errorLabel.setText("Please enter a username");
            errorLabel.setVisible(true);
        } else if (password.isEmpty()){
            errorLabel.setText("Please enter a password");
            errorLabel.setVisible(true);
        } else {
            errorLabel.setVisible(false);
            System.out.println("Do something username: " + username + ", password: " + password);  
        }
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
}
