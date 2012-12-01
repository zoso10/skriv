/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skrivfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 *
 * @author Tyler
 */
public class TestController implements Initializable{
    
    
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
        }
        else{
            menuPane.setVisible(false);
        }
    }
    
    @FXML
    private void handleNewButtonAction(){
        System.out.println("new button pressed");
    }
    
    @FXML
    private void handleOpenButtonAction(){
        System.out.println("open button pressed");
    }
    
    @FXML
    private void handleSaveButtonAction(){
        System.out.println("save button pressed");
    }
    @FXML
    private void handleCloseButtonAction(){
        System.out.println("close button pressed");
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
