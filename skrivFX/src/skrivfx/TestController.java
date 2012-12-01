/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skrivfx;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Tyler
 * 
 * Make sure you use the @FXML tag any time you need to interface
 * with the FXML file!
 */
public class TestController implements Initializable{
    
    //These are objects injected from the FXML file:
    @FXML
    private ToggleButton menuButton;
    @FXML
    private AnchorPane menuPane;
    @FXML
    private ToggleButton writeButton;
    @FXML
    private Button openButton;
    @FXML
    private Button newButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button closeButton;
    
    //attributes
    private ParallelTransition parallelTransition;
    
    //Button action methods:
    @FXML
    private void handleWriteButtonAction(ActionEvent e){
        if (writeButton.isSelected()){
            System.out.println("write button on");
        }
        else{
            System.out.println("write button off");
        } 
    }
    
    
    
    @FXML
    private void handleMenuButtonAction(){
        if (menuButton.isSelected()){
            menuPane.setVisible(true);
            this.menuButtonOpen();          
        }
        //No idea why the fade out transition doesnt work right.
        //the transition works if you remove the .setVisible line,
        //however if the buttons are left visible they are still 
        //clickable, which is undesirable
        else{
            this.menuButtonClose();
            menuPane.setVisible(false);
        }
    }
    
    private void menuButtonOpen(){
        FadeTransition fadeTransition = 
        new FadeTransition(Duration.millis(250), menuPane);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
        TranslateTransition translateTransition =
        new TranslateTransition(Duration.millis(250), menuPane);
        translateTransition.setFromY(-100);
        translateTransition.setToY(5);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        RotateTransition rotateTransition = 
        new RotateTransition(Duration.millis(150), menuButton);
        rotateTransition.setByAngle(90);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(true);

        parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition
        );
        parallelTransition.setCycleCount(1);
        parallelTransition.play();
}
    private void menuButtonClose(){
        FadeTransition fadeTransition = 
        new FadeTransition(Duration.millis(250), menuPane);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
        TranslateTransition translateTransition =
        new TranslateTransition(Duration.millis(250), menuPane);
        translateTransition.setFromY(5);
        translateTransition.setToY(-100);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        RotateTransition rotateTransition = 
        new RotateTransition(Duration.millis(150), menuButton);
        rotateTransition.setByAngle(-90);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(true);

        parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition
        );
        parallelTransition.setCycleCount(1);
        parallelTransition.play();
}
    
    
    @FXML
    private void handleNewButtonAction(){
        System.out.println("new button pressed");
        if(menuButton.isSelected()){
            this.menuButtonClose();
            menuButton.setSelected(false);
            menuPane.setVisible(false);

        }
    }
    
    @FXML
    private void handleOpenButtonAction(){
        System.out.println("open button pressed");
        if(menuButton.isSelected()){
            this.menuButtonClose();
            menuButton.setSelected(false);
            menuPane.setVisible(false);
            
//            DirectoryChooser dc = new DirectoryChooser();
//            dc.setTitle("Open skriv file...");
//            File defaultDirectory = new File(".");
//            dc.setInitialDirectory(defaultDirectory);
//            File selectedDirectory = dc.showDialog(new Stage());
            FileChooser fc = new FileChooser();
            fc.setTitle("Open skriv file...");
            File defaultDirectory = new File(".");
            fc.setInitialDirectory(defaultDirectory);
            fc.showOpenDialog(new Stage());
        }
    }
    
    @FXML
    private void handleSaveButtonAction(){
        System.out.println("save button pressed");
        if(menuButton.isSelected()){
            this.menuButtonClose();
            menuButton.setSelected(false);
            menuPane.setVisible(false);
            
            FileChooser fc = new FileChooser();
            fc.setTitle("Save skriv file...");
            File defaultDirectory = new File(".");
            fc.setInitialDirectory(defaultDirectory);
            //File selectedDirectory = dc.showDialog(new Stage());
            fc.showSaveDialog(new Stage());
        }
    }
    @FXML
    private void handleCloseButtonAction(){
        System.out.println("close button pressed");
        if(menuButton.isSelected()){
            this.menuButtonClose();
            menuButton.setSelected(false);
            menuPane.setVisible(false);
            
        }
    }
    
    
    
//    @Override // This method is called by the FXMLLoader when initialization is complete
//    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
//        assert menuButton != null : "fx:id=\"menuButton\" was not injected: check your FXML file 'jfxGUI.fxml'.";
//
//        // initialize your logic here: all @FXML variables will have been injected
//        menuButton.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                if (menuButton.isSelected()){
//                    menuPane.setVisible(true);
//                }
//                else{
//                    menuPane.setVisible(false);
//                }
//            }
//        });     
//
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // stuff, maybe...
    }
}
