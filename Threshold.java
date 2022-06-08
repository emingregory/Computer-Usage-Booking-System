
package countdown;

import com.sun.prism.paint.Color;
import java.awt.Transparency;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.*;
import javafx.scene.control.ComboBox;

public class Threshold {
    
    static Stage stage;
    static boolean btnYesClick;
    static String timeLimit;
    
    
    public static String show(String title, String message, String textYes)
    {
        final ComboBox<String> threshold = new ComboBox<String>();
        //threshold.setVisible(true);
        
        threshold.getItems().addAll("5", "30", "60", "90", "120", "180", "");
        threshold.setPromptText("Choose Time Limit in minutes");
        threshold.setMinWidth(200);
        threshold.setMinHeight(15);
        
        
        btnYesClick = false;
        
        stage = new Stage();
        //stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setWidth(400);
        stage.setHeight(300);
        
        Label lbl = new Label();
        lbl.setText(message);
        lbl.setStyle("-fx-font-size: 12; -fx-font-weight: bold");
        lbl.setTextFill(javafx.scene.paint.Color.BLUE);
        Button btnYes = new Button();
        btnYes.setText(textYes);
        //btnYes.setTextFill(Color.BLUE);
       
        btnYes.setMinWidth(100);
       
       
       btnYes.setOnAction(new EventHandler <ActionEvent>()
       {
           @Override public void handle(ActionEvent e) 
           {
               Integer.parseInt(timeLimit = threshold.getValue());
               stage.close();
               btnYesClick = true;
               
               
           }
       });
        
        
      
       HBox fieldHolder = new HBox();
       VBox pane = new VBox(20);
       pane.setPadding(new Insets(10));
       //VBox.setMargin(btnYes, new Insets(20,10,20,10));
       pane.getChildren().addAll(btnYes);
       pane.setTranslateX(125);
       pane.setTranslateY(200);
       //pane.setAlignment(Pos.CENTER);
       
       //lbl.setTranslateY(25);
       //lbl.setTranslateX(5);
       VBox root = new VBox();
       fieldHolder.getChildren().addAll(lbl,threshold);
       fieldHolder.setTranslateX(5);
       fieldHolder.setTranslateY(50);
       fieldHolder.setSpacing(10);
       root.getChildren().addAll(fieldHolder, pane);
       //root.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(root);
       
       
    
    
     stage.setOnCloseRequest(new EventHandler<WindowEvent>()
    {
        
        @Override public void handle(WindowEvent e)
        {
            e.consume();
            System.exit(0);
           
        }     
        });
    
        stage.setScene(scene);
       stage.showAndWait();
       return timeLimit;
        
        
    }      
        
   
}
