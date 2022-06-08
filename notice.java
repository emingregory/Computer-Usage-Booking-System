package countdown;

import java.awt.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.*;

import javafx.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import java.awt.Frame;

//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javax.swing.JApplet;
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;
//import javax.swing.UIManager;



/*
*@resource loading.gif
*/

public class notice extends JFrame implements ActionListener


{
   // static ProgressIndicator pi = new ProgressIndicator();
    //static Image img = new Image(DisplayShelf.class.getResource("loading"+".gif").toExternalForm(),false);
    //static ImageView iView = new ImageView(img);
    static Toolkit tk = Toolkit.getDefaultToolkit();
    static Dimension d = tk.getScreenSize();
    private static JFXPanel fxContainer;
    static Book booking;
    Frame frame = new Frame();
    
    public static void begin()
    {
        new notice();
    }
    
    
    
    static boolean Override = false;
    JButton ok = new JButton("OK");
    JButton override = new JButton("Override");
    JButton book = new JButton("Book this computer");
    static int x;
    static int y;
    
    public notice()
            
            {    x = d.width / 4 ; 
                 y = d.height / 4; 
              
               this.setTitle("Library Computer Booking System");
               JLabel time = new JLabel();
               
               time.setForeground(Color.red);
               time.setText("You have " + CountDown.limit + " minutes remaining.");
               
               ok.addActionListener(this);
               override.addActionListener(this);
               book.addActionListener(this);
               JLabel message = new JLabel();
               JLabel message2 = new JLabel();
               //message.setAlignmentX(CENTER_ALIGNMENT);
               message.setForeground(Color.blue);
               message2.setForeground(Color.blue);
               message.setText("Please note that the computer will shutdown after your " + CountDown.limit + " minutes have expired.");
               
               message2.setText(" You will be reminded again 5 minutes before the shutdown.");
               
               message.setAutoscrolls(rootPaneCheckingEnabled);
               
               
               JPanel panel1 = new  JPanel();
               
               JPanel panel2 = new  JPanel();
               
               
               panel1.setLayout(new BorderLayout());
              
               panel2.add(time);
               panel2.add(message);
               panel2.add(message2);
               Box buttons = Box.createHorizontalBox();
               buttons.add(Box.createHorizontalStrut(10));
               
               panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 50,15));
               panel2.setBackground(Color.white);
               
               buttons.add(Box.createRigidArea(new Dimension(350, 10)));
               buttons.add(ok);
               buttons.add(Box.createRigidArea(new Dimension(20, 10)));
               buttons.add(override);
               buttons.add(Box.createRigidArea(new Dimension(20, 10)));
               buttons.add(book);
               buttons.add(Box.createHorizontalGlue());
               buttons.add(Box.createHorizontalStrut(50));
               
               
             
               panel1.add(buttons, BorderLayout.SOUTH);
               panel1.add(panel2);
               //buttons.setLayout();
               
               //buttons.setLocation(150, 100);
               panel1.setBackground(Color.WHITE);
               this.add(panel1);
               
               this.setSize(700,300);
               this.setLocation(x, y);
              // this.setLocation(Screen.getMainScreen());
               this.setResizable(false);
               //this.setUndecorated(true);
               this.setVisible(true);
               this.setDefaultCloseOperation(JFrame.NORMAL);
               
               
                
               
            }      
              
               
               
               
               
          
    
        
      
    
    
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == ok)
        {
            this.setVisible(false);
        }
        else if (e.getSource() == override)
            
        {   //this.setVisible(false);
            SwingPass pass = new SwingPass(new javax.swing.JFrame(), true);
            
            pass.setTitle("Authorisation Required");
            pass.setAlwaysOnTop(true);
            pass.setLocation(d.width/3,d.height/3);
            pass.setVisible(true);
            this.close();
            
        }
       else if (e.getSource() == book)
            
       {    this.setVisible(false);
            this.dispose();
            booking = new Book(new javax.swing.JFrame(), true);
            
            booking.setTitle("Book This Computer");
            booking.setAlwaysOnTop(true);
            booking.setLocation(d.width/4 + 20, d.height/4);
            booking.setVisible(true);
            
            
            
            
            
            
            
            
            
           
        }
    }
    
    
    public boolean override()
    {
        
        return Override;
    }
    
    
    public void close()
    {
        
        this.setVisible(false);
        this.dispose();
        
        
        
    }
    
}
