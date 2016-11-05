package medapp;

import com.sun.javafx.css.Style;
import com.sun.javafx.css.Stylesheet;
import com.sun.javafx.geom.Rectangle;
import static java.awt.Color.red;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author Terry
 */
public class ScreenOptionsController implements Initializable {
    
    @FXML private Label darkErrorLabel = new Label();
    @FXML private Label darkLabel = new Label();
    @FXML private Button darkButton = new Button();
    @FXML private AnchorPane darkPane = new AnchorPane();
    @FXML private TextField darkTextField = new TextField();
    
    @FXML private Label lightErrorLabel = new Label();
    @FXML private Label lightLabel = new Label();
    @FXML private Button lightButton = new Button();
    @FXML private AnchorPane lightPane = new AnchorPane();
    @FXML private TextField lightTextField = new TextField();
 
    @FXML private Label cbErrorLabel = new Label();
    @FXML private Label cbLabel = new Label();
    @FXML private Button cbButton = new Button();
    @FXML private AnchorPane cbPane = new AnchorPane();
    @FXML private TextField cbTextField = new TextField();

    public ScreenOptionsController() {
   
    }

    /**
     * Initialize the "demo" units with custom styles that will not change
     */
    public void initialize(URL url, ResourceBundle rb) {
        // Dark theme demo
        darkErrorLabel.getStyleClass().add("darkErrorLabel");
        darkLabel.getStyleClass().add("darkLabel");
        darkPane.getStyleClass().add("darkBackground");
        darkButton.getStyleClass().add("darkButton");
        darkTextField.getStyleClass().add("darkTextField");
        darkPane.setVisible(true);
        
        // Light theme demo
        lightErrorLabel.getStyleClass().add("lightErrorLabel");
        lightLabel.getStyleClass().add("lightLabel");
        lightPane.getStyleClass().add("lightBackground");
        lightButton.getStyleClass().add("lightButton");
        lightTextField.getStyleClass().add("lightTextField");
        lightPane.setVisible(true);

        // Colorblind theme demo
        cbErrorLabel.getStyleClass().add("cbErrorLabel");
        cbLabel.getStyleClass().add("cbLabel");
        cbPane.getStyleClass().add("cbBackground");
        cbButton.getStyleClass().add("cbButton");
        cbTextField.getStyleClass().add("cbTextField");
        cbPane.setVisible(true);
    }    
    
    @FXML  
    /**
     * Takes the user back to main
     */
    private void mainButtonAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenMain.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        home_page_scene.getStylesheets().clear();
        Scene otherScene = (Scene) ((Node) event.getSource()).getScene();
        String style = otherScene.getStylesheets().toString();
        style = style.replace("[", "");
        style = style.replace("]", "");
        home_page_scene.getStylesheets().add(style);
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
  
    @FXML  
    /**
     * Reads the source of the event to determine which button was clicked.
     * From there, selects the appropriate CSS file and applies it to the scene.
     */
    private void guiButtonClicked(ActionEvent event) throws IOException {
        
        String sourceID = event.getSource().toString();
        sourceID = sourceID.substring(sourceID.indexOf('=') + 1, sourceID.indexOf(','));
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLScreenOptions.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        home_page_scene.getStylesheets().clear();
        
        if (sourceID.equalsIgnoreCase("guidarkbutton")){
            home_page_scene.getStylesheets().add("medapp/darkStyle.css");
        } else if (sourceID.equalsIgnoreCase("guilightbutton")){
            home_page_scene.getStylesheets().add("medapp/lightStyle.css");
        } else if (sourceID.equalsIgnoreCase("guicbbutton")){
            home_page_scene.getStylesheets().add("medapp/cbStyle.css");
        } else {
            System.out.println("Unknown gui!");
            System.exit(-1);
        } 
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}
