/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package countdown;

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
import java.sql.ResultSet;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author LibraryAdmin
 */

public class CountDown extends Application {
    
    
   // Declare the variables 
    
   File currentUserFile;
   File currentTimeFile;
   File currentDateFile;
   File prevUser; 
   
      
   
   PrintWriter out;
   static String currentDate;
   static String currentYear;
   static String currentUser;
   static String currentTime;
   static String currentMonth;
   static String currentDay;
   static String currentHour;
   static String currentMins;
   static ResultSet results;
   static ResultSet results2;
   static ResultSet results3;
   static Calendar date;
   String lastUser = "";        
   
  
   String bookedUser = "";
   
   
   String lastLoginTime = ""; 
   String LastLoginSecs = "";
   int lastLogintime = 0;
   int lastLoginsecs = 0;
   int currenthour = 0;
   int currentmins = 0;
   static int currentSecs = 0;
   int bookedSecs = 0;
   String currentSeconds = "";
   BufferedReader latest;
   String current; 
   
   VBox v = new VBox();
   Pane root = new Pane();
  
   static Stage stage;
   static Long time;
   static int limit = 0;
   
   PrintWriter prev;
   PrintWriter curr;
   
    
    @Override
    public void start(final Stage primaryStage) { 
        
        
         
         date = Calendar.getInstance();
         
         
         
      
         com.sun.security.auth.module.NTSystem user = new com.sun.security.auth.module.NTSystem();
         
         
        // System.out.println(user.getName() + " " + date.get(Calendar.DAY_OF_MONTH) + "/" + date.get(Calendar.MONTH)  + "/" + date.get(Calendar.YEAR) + " time: " + date.get(Calendar.HOUR_OF_DAY));
             
        // Connect to the database
         
         Database.connect();
        
         //Database.UpdateData();
         
         
         
       
        
         
        // set the variable for database query
        results = null;
        results2 = null;
        results3 = null;
     
           
            try {
            
                
                
          // Query the database and get the usage threshold limit set by the admin    
           results2 =  Database.get_Statement().executeQuery("Select " 
                + "Usage_Threshold from UserTable where Usage_Threshold >= 0");
           
           
                 while (results2.next())
                 {
                     limit = results2.getInt(1);
                     
                 }   
                
                 }
            
                 catch (SQLException e2)
                {
                    System.out.println("Error 2" + e2);
                }    
            
            
            
       
        
         
        
         currentUser = user.getName();
         currentYear = Integer.toString(date.get(Calendar.YEAR));
         currentMonth = Integer.toString(date.get(Calendar.MONTH) + 1);
         currentDay =  Integer.toString(date.get(Calendar.DAY_OF_MONTH));
         currentDate =  currentYear +  "-" + currentMonth + "-" + currentDay;
         
         if (date.get(Calendar.HOUR) <= 9)
         
           {
            currentHour = "0" + Integer.toString(date.get(Calendar.HOUR)); 
          }  
           
         else
         {
            currentHour = Integer.toString(date.get(Calendar.HOUR));  
         }
         
         if (date.get(Calendar.MINUTE) <= 9)
         {
            currentMins = "0" + Integer.toString(date.get(Calendar.MINUTE)); 
         }
         
         else if (date.get(Calendar.MINUTE) > 9)
         {
          currentMins = Integer.toString(date.get(Calendar.MINUTE));   
         }
         
         
          
         currentHour = Integer.toString(date.get(Calendar.HOUR_OF_DAY));
         currentTime = currentHour + ":" + currentMins;  
         currentSecs = (Integer.parseInt(currentHour) * 60 * 60);
         currentSecs = currentSecs + (Integer.parseInt(currentMins) * 60);
         
         //limit = 90;
         //System.out.println("Current time is: " + currentTime + " time in seconds is: " + currentSecs);
         //System.out.println("'" + currentUser + "', '" + currentDate + "', '" +  currentTime + "' " + currentSecs);
                
             
          
          
        time = System.currentTimeMillis();  
        
         
        try 
        {
          
        
        Database.get_Statement().executeUpdate("insert into UserTable (UserName, Last_Login_Date, "
                + "Last_Login_Time) values ('" + currentUser + "', '" + currentDate + "', '" +  currentTime + "')" );
        
         
            
         results =  Database.get_Statement().executeQuery("Select UserName, Last_Login_Date, "
                + "Last_Login_Time from UserTable where Last_Login_Date = '" + currentDate + "'");
        }
        
         //where Username = " + currentUser
          catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                  
              
                    
               try {
               
                   
                 // Get the last loged in user's details from the database
                 while (results.next()) 
                {
                   
                        
                        lastLoginTime = results.getString(3).substring(0,1);
                        LastLoginSecs = results.getString(3).substring(3,4);
                        lastUser =  results.getString(1);          
                
                }
             
              
              
               // Convert current time to seconds
               currenthour = Integer.parseInt(currentHour) * 60 * 60;
               currentmins = Integer.parseInt(currentMins) * 60;
               currenthour = currenthour + currentmins;
               
               // If someone has loged into the system 
               if (!lastLoginTime.equals(""))
                   {
               // Convert last login time into seconds
               lastLogintime = Integer.parseInt(lastLoginTime) * 60 * 60;
               lastLoginsecs = Integer.parseInt(LastLoginSecs) * 60;
               lastLogintime = lastLogintime + lastLoginsecs;
               
                   }
                                      
               
              }   catch (SQLException e)
                {
                    
                    System.out.println("Error 2" + e);
                } 
        
                
               
               try 
               {
                   
               
               // Get current day's usage booking
               results =  Database.get_Statement().executeQuery("Select UserName,  "
                + " Next_Login_Date, Next_Login_Time, Time_in_seconds from UserTable where (Next_Login_Date = '" + currentDate + "' AND Time_in_seconds > " + currentSecs + " AND Time_in_seconds < " + currentSecs + " + 5400)"); // and Last_Login_Date = '" + currentDate + "')");
              }
         
          catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                } 
               
                 try 
                 
               {  
               
                // Get the booked user details
                while (results.next()) 
                {
                    
                       
                  
                   bookedSecs = Integer.parseInt(results.getString(4));
                   limit = ( bookedSecs - currentSecs) / 60 - 5;
                   
                 
                
                }
               }
                catch (SQLException e)
                {
                    
                }
               
               
               System.out.println("This is the limit " + limit);
               
               try 
               {
                   
               
               // Get current day's usage booking
               results =  Database.get_Statement().executeQuery("Select UserName,  "
                + " Next_Login_Date, Next_Login_Time, Time_in_seconds from UserTable where (Next_Login_Date = '" + currentDate + "' AND " + currentSecs + "BETWEEN Time_in_seconds AND Time_in_seconds + 5340)"); // and Last_Login_Date = '" + currentDate + "')");
              }
         
          catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                } 
               
              
                    
                     // This window is for admin user only 
                      if (currentUser.equals("LibraryAdmin") ) // || currentUser.equals("nishanbakunts")) 
                          {
                                 
            
                                     Admin admin = new Admin();
                                     admin.start();
                               
                          }
                   
               
               
                try 
                 
               {  
               
                // Get the booked user details
                while (results.next()) 
                {
                   bookedUser = results.getString(1);
                  
                   
                   // If the system has been booked by the current logged in user and the current logged in user is not the admin
                                     
                   if (bookedUser.equals(currentUser) && !currentUser.equals("LibraryAdmin") ) //&& !currentUser.equals("nishanbakunts"))
                       
                   {
                       // Display the notice screen with admin set threshold
                       limit = 90;
                       notice.begin();
                       run();
                       
                   }
                   
                   // If the current user is not the booked user
                   else if (!bookedUser.equals(currentUser) && (!currentUser.equals("LibraryAdmin") )) //|| currentUser.equals("nishanbakunts")))
                   
                   {    
                       try 
                       {
                         // Shutdown the system with five minute warning
                         Runtime.getRuntime().exec("shutdown -s /t 300");  
                           
                       }
                       
                       catch (IOException ie)
                       {
                       }
                       
                        // Show the system booking conflict screen to notify the current user that the system has been booked by another user
                        Confirm.show("Login violation", "                                 There is a booking for this computer for current time. \n"
                                                           + currentUser + " may not login as " +  results.getString(1) + " has booked to use this system on " + results.getString(2) + " " + results.getString(3) + "\n"
                                                  + "                             Shutdown of the computer has been initiated - thank you.", "OK");
                                                     
                   }
             
                     }         
                   
                     // If there are no current bookings and there is a booking for the next session
                     // then display the notice with the remaining time up to the next session 
                     if ( (!results.next() && bookedUser.equals("")) && (!currentUser.equals("LibraryAdmin") && limit < 90 && limit > 0) )// && (!currentUser.equals("nishanbakunts")) )
                   
                       {
                       System.out.println("Booked user 1: " + bookedUser);
                      // System.out.println("No bookings for anybody today");
                       
                       notice.begin();
                       run();
                       
                       
                       
                       }
                     
                      // If there are no current bookings or bookings for the next session
                     // then display the notice with the 90 minute warning
                    else if ( (!results.next() && bookedUser.equals("")) && (!currentUser.equals("LibraryAdmin") && limit == 0) )// && (!currentUser.equals("nishanbakunts")) )
                   
                       {
                       System.out.println("Booked user 2: " + bookedUser);
                      // System.out.println("No bookings for anybody today");
                       limit = 90;
                       notice.begin();
                       run();
                       
                       
                       
                       }
                   
                   //
                   //System.out.println("Current time ins seconds: " + currentSecs +  " Next login time in seconds: " + results.getString(4));
                              
                   
               
               
               }
               catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                    
                } 
               
         
        // Set the stage 
        stage = new Stage();
        
           
       
        
       stage.setOnCloseRequest(new EventHandler<WindowEvent>()
    {
        
        @Override public void handle(WindowEvent e)
        {
            e.consume();
           
            
        }
        
        
    });
        
    }

    
    
    public void writeUser(String user, PrintWriter out) //throws IOException
    {
      out.println(user);
      out.flush();
      out.close();
    }
    
    
    
  
    
    
   
      public void run() 
        
        { 
           try 
           {
               
           
        
           Long time2 = System.currentTimeMillis();
          
           while (time2 < time + (limit * 60 * 1000))
           {
               
           time2 = System.currentTimeMillis();
           
           
           
           if (time2 == time + (limit * 60 * 1000))
           {
               Runtime.getRuntime().exec("shutdown -s /t 300");
               //System.out.println("Shutdown");
               
               try 
               {
                   Database.shut();
               }
               catch (SQLException se)
               {
                   System.out.println(se);
               }
               break;
           }
          
           }
           } catch (IOException i2)
           
            {
               System.out.println("Error running the system command " + i2); 
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
   /* public static void main(String[] args) {
        launch(args);
    }*/
}
