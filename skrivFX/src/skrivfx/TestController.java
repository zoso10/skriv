/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skrivfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Tyler
 */
public class TestController implements Initializable{
    
    @FXML
    private void handleButtonAction(ActionEvent e){
        System.out.println("dont touch me there");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // stuff, maybe...
    }
}
