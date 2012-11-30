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
import javafx.scene.control.ToggleButton;

/**
 *
 * @author Tyler
 */
public class TestController implements Initializable{
    
    @FXML
    private Accordion menu;
    
    @FXML
    private ToggleButton menuButton;
    
    @FXML
    private void handleButtonAction(ActionEvent e){
        System.out.println("dont touch me there");
    }
    
    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert menuButton != null : "fx:id=\"menuButton\" was not injected: check your FXML file 'jfxGUI.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
        menuButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (menuButton.isSelected()){
                    //menu.setOpacity(1.0);
                    menu.setVisible(true);
                }
                else{
                    //menu.setOpacity(0.0);
                    menu.setVisible(false);
                }
            }
        });

    }
    
//    @Override
//    public void initialize(URL url, ResourceBundle rb){
//        // stuff, maybe...
//    }
}
