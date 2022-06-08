
package countdown;

//import com.sun.prism.paint.Color;
import static countdown.notice.d;
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
import java.io.*;
import javafx.scene.paint.Color;


public class Confirm {
    
    static Stage stage;
    static boolean btnYesClick;
    static Button bookings = new Button("Book This Computer");
    static Book booking;
    
    public static boolean show(String title, String message, String textYes)
    {
        
        btnYesClick = false;
        
       stage = new Stage();
        
       stage.setTitle(title);
       stage.setWidth(650);
       stage.setHeight(300);
        
       Label lbl = new Label();
       lbl.setText(message);
       lbl.setStyle("-fx-font-size: 13; -fx-font-weight: bold");
       lbl.setTextFill(javafx.scene.paint.Color.RED);
       Button btnYes = new Button();
       Button override = new Button("Override");
       override.setTextFill(Color.AQUA);
       btnYes.setTextFill(Color.AQUA);
       bookings.setTextFill(Color.AQUA);
       bookings.setStyle("-fx-background-color: black; -fx-font-weight: bold");
       btnYes.setStyle("-fx-background-color: black; -fx-font-weight: bold");
       override.setStyle("-fx-background-color: black; -fx-font-weight: bold");
       btnYes.setText(textYes);
       
       
       bookings.setOnAction(new EventHandler <ActionEvent>()
       {
           @Override public void handle(ActionEvent e) 
           {
               booking = new Book(new javax.swing.JFrame(), true);
            
            booking.setTitle("Book This Computer");
            booking.setAlwaysOnTop(true);
            booking.setLocation(d.width/4 + 20, d.height/4);
            booking.setVisible(true);
            
           }
       });
       
       override.setOnAction(new EventHandler <ActionEvent>()
       {
           @Override public void handle(ActionEvent e) 
           {
               stage.close();
               
               boolean pass = password.show("Authorisation Required", "Enter the Admin password:", "Ok", "Cancel");
               try
               {
                   if (pass)
                   {
                      Runtime.getRuntime().exec("shutdown /a ");   
                   }
                 
               }
               catch (IOException ie)
               {
                   
               }
               
           }
       });
       btnYes.setOnAction(new EventHandler <ActionEvent>()
       {
           @Override public void handle(ActionEvent e) 
           {
               stage.close();
               btnYesClick = true;
               
           }
       });
        
        
      
       
       HBox pane = new HBox(20);
       pane.setPadding(new Insets(10));
       
       pane.getChildren().addAll(btnYes, bookings, override);
       pane.setTranslateX(220);
       pane.setTranslateY(150);
       
       
       lbl.setTranslateY(50);
       lbl.setTranslateX(30);
       VBox root = new VBox();
       root.getChildren().addAll(lbl,pane);
       
       
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.showAndWait();
       return btnYesClick;
       
    }
    
    
}
