/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skrivfx;

import classes.ClearThread;
import classes.SmartPoint;
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
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Model;

/**
 *
 * @author Tyler
 * 
 * Make sure you use the @FXML tag any time you need to interface
 * with the FXML file!
 */
public class TestController implements Initializable{
    
    // Other stuff
    private Canvas canvas;
    private Model model;
    private boolean hasReachedEnd = false;
    private static ClearThread t;
    
    //These are objects injected from the FXML file:
    @FXML
    private ToggleButton menuButton;
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
    private Rectangle thumb;
    @FXML
    private ImageView track;
    @FXML
    private Pane drawingPane;
    @FXML
    private Pane page;
    
    
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
    
/*------------------------Animated Menu Button------------------------*/
    
    @FXML
    private void handleMenuButtonAction(){
        if (menuButton.isSelected()){
            newButton.setVisible(true);
            openButton.setVisible(true);
            saveButton.setVisible(true);
            closeButton.setVisible(true);
            this.menuButtonOpen();          
        }
        //No idea why the fade out transition doesnt work right.
        //the transition works if you remove the .setVisible line,
        //however if the buttons are left visible they are still 
        //clickable, which is undesirable
        else{
            this.menuButtonClose();
            Thread t = new Thread(new Runnable(){
                @Override
                public void run(){
                    try{
                        Thread.sleep(250);
                    } catch(Exception e){ System.out.println("pause exception"); }
                    newButton.setVisible(false);
                    openButton.setVisible(false);
                    saveButton.setVisible(false);
                    closeButton.setVisible(false);
                }
            });
            t.start(); 
        }
    }
    
    //code reuse goes out the window:
    
    private void menuButtonOpen(){
        FadeTransition newFade = 
        new FadeTransition(Duration.millis(50), newButton);
        newFade.setFromValue(0.0);
        newFade.setToValue(1.0);
        newFade.setCycleCount(1);
        newFade.setAutoReverse(true);
        
        TranslateTransition newTranslate =
        new TranslateTransition(Duration.millis(50), newButton);
        newTranslate.setFromY(-100);
        newTranslate.setToY(5);
        newTranslate.setCycleCount(1);
        newTranslate.setAutoReverse(true);
        
        FadeTransition openFade = 
        new FadeTransition(Duration.millis(100), openButton);
        openFade.setFromValue(0.0);
        openFade.setToValue(1.0);
        openFade.setCycleCount(1);
        openFade.setAutoReverse(true);
        
        TranslateTransition openTranslate =
        new TranslateTransition(Duration.millis(100), openButton);
        openTranslate.setFromY(-100);
        openTranslate.setToY(5);
        openTranslate.setCycleCount(1);
        openTranslate.setAutoReverse(true);
        
        FadeTransition saveFade = 
        new FadeTransition(Duration.millis(150), saveButton);
        saveFade.setFromValue(0.0);
        saveFade.setToValue(1.0);
        saveFade.setCycleCount(1);
        saveFade.setAutoReverse(true);
        
        TranslateTransition saveTranslate =
        new TranslateTransition(Duration.millis(150), saveButton);
        saveTranslate.setFromY(-100);
        saveTranslate.setToY(5);
        saveTranslate.setCycleCount(1);
        saveTranslate.setAutoReverse(true);
        
        FadeTransition closeFade = 
        new FadeTransition(Duration.millis(250), closeButton);
        closeFade.setFromValue(0.0);
        closeFade.setToValue(1.0);
        closeFade.setCycleCount(1);
        closeFade.setAutoReverse(true);
        
        TranslateTransition closeTranslate =
        new TranslateTransition(Duration.millis(250), closeButton);
        closeTranslate.setFromY(-100);
        closeTranslate.setToY(5);
        closeTranslate.setCycleCount(1);
        closeTranslate.setAutoReverse(true);
        
        RotateTransition rotateTransition = 
        new RotateTransition(Duration.millis(150), menuButton);
        rotateTransition.setByAngle(90);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(true);

        parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                newFade,
                newTranslate,
                
                openFade,
                openTranslate,
                
                saveFade,
                saveTranslate,
                
                closeFade,
                closeTranslate,
                
                rotateTransition
        );
        parallelTransition.setCycleCount(1);
        parallelTransition.play();
}
    private void menuButtonClose(){
        FadeTransition newFade = 
        new FadeTransition(Duration.millis(50), newButton);
        newFade.setFromValue(1.0);
        newFade.setToValue(0.0);
        newFade.setCycleCount(1);
        newFade.setAutoReverse(true);
        
        TranslateTransition newTranslate =
        new TranslateTransition(Duration.millis(50), newButton);
        newTranslate.setFromY(5);
        newTranslate.setToY(-100);
        newTranslate.setCycleCount(1);
        newTranslate.setAutoReverse(true);
        
        FadeTransition openFade = 
        new FadeTransition(Duration.millis(100), openButton);
        openFade.setFromValue(1.0);
        openFade.setToValue(0.0);
        openFade.setCycleCount(1);
        openFade.setAutoReverse(true);
        
        TranslateTransition openTranslate =
        new TranslateTransition(Duration.millis(100), openButton);
        openTranslate.setFromY(5);
        openTranslate.setToY(-100);
        openTranslate.setCycleCount(1);
        openTranslate.setAutoReverse(true);
        
        FadeTransition saveFade = 
        new FadeTransition(Duration.millis(150), saveButton);
        saveFade.setFromValue(1.0);
        saveFade.setToValue(0.0);
        saveFade.setCycleCount(1);
        saveFade.setAutoReverse(true);
        
        TranslateTransition saveTranslate =
        new TranslateTransition(Duration.millis(150), saveButton);
        saveTranslate.setFromY(5);
        saveTranslate.setToY(-100);
        saveTranslate.setCycleCount(1);
        saveTranslate.setAutoReverse(true);
        
        FadeTransition closeFade = 
        new FadeTransition(Duration.millis(75), closeButton);
        closeFade.setFromValue(1.0);
        closeFade.setToValue(0.0);
        closeFade.setCycleCount(1);
        closeFade.setAutoReverse(true);
        
        TranslateTransition closeTranslate =
        new TranslateTransition(Duration.millis(150), closeButton);
        closeTranslate.setFromY(5);
        closeTranslate.setToY(-100);
        closeTranslate.setCycleCount(1);
        closeTranslate.setAutoReverse(true);
        
        RotateTransition rotateTransition = 
        new RotateTransition(Duration.millis(150), menuButton);
        rotateTransition.setByAngle(-90);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(true);

        parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                newFade,
                newTranslate,
                
                openFade,
                openTranslate,
                
                saveFade,
                saveTranslate,
                
                closeFade,
                closeTranslate,
                
                rotateTransition
        );
        parallelTransition.setCycleCount(1);
        parallelTransition.play();
}
    
/*------------------------    Menu Buttons    ------------------------*/
    
    @FXML
    private void handleNewButtonAction(){
        System.out.println("new button pressed");
        if(menuButton.isSelected()){
            this.menuButtonClose();
            menuButton.setSelected(false);
            newButton.setVisible(false);
            openButton.setVisible(false);
            saveButton.setVisible(false);
            closeButton.setVisible(false);

        }
    }
    
    @FXML
    private void handleOpenButtonAction(){
        System.out.println("open button pressed");
        if(menuButton.isSelected()){
            this.menuButtonClose();
            menuButton.setSelected(false);
            newButton.setVisible(false);
            openButton.setVisible(false);
            saveButton.setVisible(false);
            closeButton.setVisible(false);
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
            newButton.setVisible(false);
            openButton.setVisible(false);
            saveButton.setVisible(false);
            closeButton.setVisible(false);
            
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
        //if(t != null){ t.kill(); }
        if(menuButton.isSelected()){
            this.menuButtonClose();
            menuButton.setSelected(false);
            newButton.setVisible(false);
            openButton.setVisible(false);
            saveButton.setVisible(false);
            closeButton.setVisible(false);
            
        }
    }

/*------------------------  Mouse & Keyboard  ------------------------*/
    
    @FXML
    private void scrollDragAction(MouseEvent evt){
        //System.out.println("Druggeded");
       // if (thumb.getHeight() track.getFitHeight())
        if(evt.getY()-thumb.getHeight()/2>0&&evt.getY()+thumb.getHeight()/2<track.getFitHeight()) {
            thumb.setY(evt.getY()-thumb.getHeight()/2);
        }
        if (evt.getY()-thumb.getHeight()/2<=0) {
            thumb.setY(0);
        }
        if (evt.getY()+thumb.getHeight()/2>=track.getFitHeight()) {
            thumb.setY(track.getFitHeight()-thumb.getHeight());
        }
    }
    
    @FXML
    private void keyboardShortcut(KeyEvent kp){ 
        System.out.println(kp.getText());
        
    }
    
    private void startLine(GraphicsContext gc, Point2D p){
        gc.beginPath();
        gc.moveTo(p.getX(), p.getY());
        gc.lineTo(p.getX()+.01, p.getY()+.01);
        gc.stroke();
    }
    
    private void updatePoint(GraphicsContext gc, Point2D p){
        gc.lineTo(p.getX(), p.getY());
        gc.stroke();
    }
    
    public static ClearThread getThread(){
        return t;
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
        model = new Model();
        canvas = new Canvas();
        canvas.widthProperty().bind(drawingPane.widthProperty());
        canvas.heightProperty().bind(drawingPane.heightProperty());
        
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        t = new ClearThread(gc);
        t.start();
        
        gc.setFill(Color.BLACK);
        gc.setLineWidth(2);
        
        canvas.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                Point2D p2d = new Point2D(e.getX(), e.getY());
                SmartPoint sp = new SmartPoint(p2d, false);
                t.reset();
                model.addPoint(sp);
                startLine(gc, p2d);
            }
        });
        
        canvas.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                Point2D p2d = new Point2D(e.getX(), e.getY());
                SmartPoint sp = new SmartPoint(p2d, false);
                if(e.getX() > canvas.getWidth()*.9){ hasReachedEnd = true; }
                model.addPointDirect(sp);
                updatePoint(gc, p2d);
            }
        });
        
        canvas.setOnMouseReleased(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                model.addPointDirect(new SmartPoint(e.getSceneX(), e.getSceneY(), true));
                if(hasReachedEnd){
                    t.restart();
                    hasReachedEnd = false;
                }
            }
        });
        
        drawingPane.getChildren().add(canvas);
    };
}