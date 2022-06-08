/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package countdown;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
import javafx.scene.control.*;
import java.util.Timer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
*@resource loading.gif
*/

/**
 *
 * @author Emin Gregory
 */
public class Database {
    
    
     static boolean error = false;
     static Statement s;
     static Connection conn;
     static String connectionURL;
     static String connectionURL2;
     static String driver;
     static String dbName;
     
     static String dropUser = "drop TABLE DVDtable";
     
     static String dropUserTable;
     static String createUserTable;
    
     
    public static void shut() throws FileNotFoundException, IOException, SQLException
            
    {
        connectionURL = "jdbc:derby:" + dbName + "; drop=true";
        connectionURL2 = "jdbc:derby: ;shutdown=true";
        //DriverManager.getConnection(connectionURL);
        DriverManager.getConnection(connectionURL2);
    }
     
 public static void connect() //throws FileNotFoundException, IOException, SQLException
              
      {
          
    
    // Create  SQL statement  and connection variables
    driver = "org.apache.derby.jdbc.EmbeddedDriver"; 
        
       
    dbName = "bookingSystem";
    
    connectionURL = "jdbc:derby:" + dbName + "; create=true";
    
    
    try 
    {
        Class.forName(driver);
        //System.out.println("Successful connection to the database");
        
    }catch(java.lang.ClassNotFoundException e)
    {
        System.out.println(e);
        
        
        
    }
    
    try 
    {
        
    
    
    conn = DriverManager.getConnection(connectionURL);
    
    s = conn.createStatement(
            ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
    
    //s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CLOSE_CURSORS_AT_COMMIT);
    
    }
    
    catch (SQLException se)
    {
        
    }
    
   
        
    }  
               
   
 public static Statement get_Statement()
 {
     return s;
 }

 
 
 
 
 
    public static void UpdateData() //throws FileNotFoundException, IOException, SQLException
 {
        //ConfirmationBox.show();
        //StockSearch.border.setCenter(iView);
       //Update up = new Update();
       
       
       
     
         
        
            //BufferedReader in = new BufferedReader(new FileReader(f));
            
           // String line = in.readLine();
       
        // Read a line from the database
        
        
      dropUserTable = "drop TABLE UserTable";
       
       try {
      
      
       
       createUserTable = "CREATE TABLE UserTable "
               
            + "(ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "Usage_Threshold INTEGER, "
            + "Username VARCHAR(200), "
            + "Last_Login_Date  VARCHAR(15), "
            + "Last_Login_Time VARCHAR(15), "
            + "Next_Login_Date DATE, " 
            + "Next_Login_Time VARCHAR(15),"
            + "Time_in_seconds INTEGER, "
            + "Time_in_millis INTEGER "
               
           
            
            + ")"; 
       
       
        
        //s.execute(dropUserTable);
        s.execute(createUserTable);
       
           
   
       
            
       
     
     
   
       
    }catch(Throwable e)
    
    {
     
        System.out.print(e);
        
     }
 }  
       
      
         
      
     
      
  
 

  
    
    
public static void write_user() //throws FileNotFoundException, IOException
 {
       
            
       
     
        int counter = 0;
        // get the first, second and fourth items from the list and assign the variables to
        // Number, title and genre
       
        
        
 }
    





}

