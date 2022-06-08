/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package countdown;

import static countdown.CountDown.currentUser;
import static countdown.CountDown.currentDate;
import static countdown.CountDown.currentTime;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.lang.System;
import java.io.IOException;
import java.awt.event.ActionListener;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javax.swing.Timer;
import java.io.*;
import java.sql.SQLException;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import java.sql.*;
/**
 *
 * @author nishanbakunts
 */
public class Admin  {
    
    
    ResultSet results = null;
    VBox holder = new VBox();
    Pane root = new Pane();
    Label clock = new Label();
    Label message = new Label();
    Button override = new Button();
    Button admin = new Button();
    static Button ok = new Button();
    Button bookings = new Button("View Bookings");
    static Stage stage;
    String limit;
    
    //@Override
    public void start() {
        stage = new Stage();
        
       
        admin.setText("Administer");
        ok.setText("Exit");
        override.setText("Override");
        
        
        
       bookings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                
                
                
                
            }
            });
   
       override.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
               
               
             password.show("Authorisation Required", "Enter Admin password to override", "OK", "Cancel");
                
                System.exit(0);
                
                
                
                
            }
        });
        
        
        admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
               
              boolean pass = password.show("Authorisation Required", "Enter Admin password to override", "OK", "Cancel");
                 
              {
                  if (pass)
                  {
                      limit = Threshold.show("Set time limit",  "Set the login threshold:", "Set");
                     
                      try
                      {
                     
                      
         Database.get_Statement().executeUpdate("update UserTable set Usage_Threshold = " + limit  + "" );
          
                      
                  }
                  catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                } 
                  }
            
              }
              
                  
              
              
              CountDown.limit = Integer.parseInt(limit);  
              
              //System.out.println(Integer.parseInt(limit));
                   
                    
               
                     
               
              
             
            }
        });
       
        
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
               
               
              
                  stage.hide();
                   
            
                
            }
        });
        
        
       stage.setOnCloseRequest(new EventHandler<WindowEvent>()
    {
        
        @Override public void handle(WindowEvent e)
        {
            e.consume();
            System.exit(0);
           
            
        }
        
        
    });
       
       { 
        
        message.setText("This screen allows the Administrator to control the Library Booking System."
                );
        
       
        
        
        //clock.setTextFill(Color.RED);
        message.setTextFill(Color.BLUE);
        message.setStyle("-fx-font-size: 15");
        //clock.setStyle("-fx-font-size: 40");    
        HBox buttons = new HBox();
        buttons.setSpacing(25);
        buttons.setAlignment(Pos.CENTER);
        message.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll( ok, override, admin);
        buttons.setTranslateY(100);
        holder.getChildren().addAll( message, buttons);
        holder.setAlignment(Pos.CENTER);
        holder.setTranslateX(75);
        holder.setTranslateY(75);
        holder.setSpacing(20);
        root.getChildren().addAll(holder);
        
        Scene scene = new Scene(root, 650, 250);
        
        stage.setTitle("Countdown");
        
        //primaryStage.setScene(scene);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UTILITY);
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        
        
       
        } 
        
    
       
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
        //launch(args);
    }
}
