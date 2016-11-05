/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medapp;

import com.sun.javafx.css.Style;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Terry
 */
public class MedApp extends Application {
    
    @FXML private TextArea updateArea;
    @FXML private Button confirm;
    
    
    
    public void start(Stage stage) throws Exception {
        
       AnchorPane ap = new AnchorPane();
       ap.setMaxHeight(400);
       ap.setMaxWidth(560);
     
       TextArea updateArea = new TextArea();
       updateArea.setLayoutX(15);
       updateArea.setLayoutY(20);
       updateArea.setEditable(false);
       updateArea.setPrefHeight(202);
       updateArea.setPrefWidth(250);

       
       String updateString = "Update Thing.\nUpdate Thing 2.\nUpdate Thing 3.";
       stage.setTitle("E-EMT");
       confirm = new Button("Okay");
       confirm.setLayoutX(100);
       confirm.setLayoutY(275);
       confirm.prefHeight(34);
       confirm.prefWidth(137);

       updateArea.setText(updateString);
       
       //layoutX="232.0" layoutY="305.0" mnemonicParsing="false" prefHeight="34.0" prefWidth="137.0" text="Okay" />
       
       
       confirm.setOnAction(e -> {
           try {
               Parent root = FXMLLoader.load(getClass().getResource("FXMLScreenMain.fxml"));
               Scene scene2 = new Scene(root);
               stage.setScene(scene2);
               scene2.getStylesheets().add("medapp/lightStyle.css");
               stage.setTitle("E-EMT");;
               stage.setResizable(false);
               stage.show();
               stage.setHeight(850);
               stage.setWidth(560);
           } catch (IOException ex) {
               Logger.getLogger(MedApp.class.getName()).log(Level.SEVERE, null, ex);
           }
         }
       );
       
       
       ap.getChildren().addAll(updateArea, confirm);
       Scene scene = new Scene(ap);
       
       stage.setScene(scene);
       stage.setWidth(300);
       stage.setHeight(400);
       scene.getStylesheets().add("medapp/lightStyle.css");
       stage.setScene(scene);
       stage.show();
       /*
       AnchorPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/8" xmlns:fx="http://javafx.com/fxml/1" fx:controller="medapp.MedApp">
   <children>
      <Button fx:id="confirm" layoutX="232.0" layoutY="305.0" mnemonicParsing="false" prefHeight="34.0" prefWidth="137.0" text="Okay" />
      <TextArea fx:id="updateArea" layoutX="40.0" layoutY="37.0" prefHeight="232.0" prefWidth="521.0" />
   </children>
</AnchorPane>
       */
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); 
    }
}
