
package countdown;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.scene.control.PasswordField;
import java.sql.SQLException;


public class password {
    
    static Stage stage;
    static boolean btnYesClick;
    static PasswordField basePass;
    
    
    
    public static boolean show(String title, String message, String textOK, String textNo)
    {
        
        btnYesClick = false;
        
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setWidth(400);
        
        
        Label lbl = new Label();
        lbl.setTextFill(Color.NAVY);
        lbl.setStyle("-fx-font-weight: bold");
        lbl.setText(message);
        lbl.setAlignment(Pos.CENTER);
        
       Button btnYes = new Button();
       Button cancel = new Button();
       btnYes.setText(textOK);
       cancel.setText("Cancel");
       basePass = new PasswordField();
       
       basePass.setAlignment(Pos.CENTER);
       basePass.setMinWidth(25);
       
       
       
       btnYes.setOnAction(new EventHandler <ActionEvent>()
       {
           @Override public void handle(ActionEvent e) 
           {
              //System.out.println(basePass.getText());
               
               
               if (basePass.getText().hashCode() == 1117544247)
                    {
                       
                        stage.close();
                        
                        //CountDown.stage.close();
                        btnYesClick = true;
                    }
               
               else 
               {
                  stage.close(); 
                  show("Wrong password!", "\n Wrong Password, Enter the Admin Password.", "OK", "Cancel");
               }
               
               
               
           }
       });
        
        
       basePass.setOnAction(new EventHandler <ActionEvent>()
       {
           
           
           
           @Override public void handle(ActionEvent e) 
           {
               
               
               int code = basePass.getText().hashCode();
               if (code == 1117544247)
                    {
                      
                        stage.close();
                        
                        //System.exit(0);
                        btnYesClick = true;
                    }
               
               else 
               {
                  stage.close(); 
                  show("Wrong password!", "\n Wrong Password, Enter the Admin Password.", "OK", "Cancel");
               }
               
               
               
           }
       });
       
       
        cancel.setOnAction(new EventHandler <ActionEvent>()
       {
           
           
           
           @Override public void handle(ActionEvent e) 
           {
       
               stage.close();
               btnYesClick = false;
       
            }
       });
       
       
       HBox pane = new HBox(20);
       pane.setPadding(new Insets(10));
       
       HBox.setMargin(btnYes, new Insets(20,100,20,10));
       HBox.setMargin(cancel, new Insets(20,100,20,10));
       btnYes.setTranslateX(100);
       //cancel.setTranslateX(100);
       pane.getChildren().addAll(btnYes, cancel);
       
       
       VBox root = new VBox();
       root.setPadding(new Insets(5));
       root.getChildren().addAll(lbl, basePass,  pane);
       root.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.showAndWait();
       return btnYesClick;
       
    }
    
    
}
