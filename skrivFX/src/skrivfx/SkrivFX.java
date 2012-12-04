/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skrivfx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Tyler_Ewing
 */
public class SkrivFX extends Application implements EventHandler<WindowEvent>{
        
    @Override
    public void start(Stage stage) throws Exception {        
        Parent root = FXMLLoader.load(getClass().getResource("jfxGUI.fxml"));
               
        Scene scene = new Scene(root);
        
        
        stage.setOnCloseRequest(this);
        
        stage.setScene(scene);
        stage.setTitle("skriv");
        stage.setResizable(false);
        stage.show();
    }
    
    @Override
    public void handle(WindowEvent e){
        // This is a bad way of doing it
        TestController.getThread().kill();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
