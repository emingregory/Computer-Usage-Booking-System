/*
 *
 */
package countdown;



import static countdown.Book.weeklyBooking;
import static countdown.CountDown.currentUser;
import static countdown.notice.d;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;



/**
 *
 * @author Emin Gregory
 */
public class AllBookings  extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form SaveBookings
     */
    
    static ArrayList<String> myBookings; 
    static ResultSet results  = null;
    
    public AllBookings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }
    
    
    public static void begin()
    {
        
        myBookings = new ArrayList<String>();
      
        try 
               {
                 
               // Get all today's bookings 
               results =  Database.get_Statement().executeQuery("Select "
                + "Next_Login_Date, Next_Login_Time from UserTable where Next_Login_Date = CURRENT_DATE");
              
               }
          catch (SQLException e)
                {
                    System.out.println("Error " + e);
                }        
        //System.out.println(currentDate);
          String bookedData = "";
           try 
                 
               {  
                 while (results.next())  
                  {
                 
                 
                 
                 bookedData = results.getString(1) + " " + results.getString(2);
                 myBookings.add(bookedData);
                 //System.out.println(results.getString(1));
                  }
                
               
              
               }
           catch (SQLException e)
                {
                    System.out.println("Error - reading booked data " + e);
                } 
           
        
        
        
         AllBookings allBooking = new AllBookings(new javax.swing.JFrame(), true);
            
            allBooking.setTitle("Today's bookings");
            allBooking.setAlwaysOnTop(true);
            allBooking.setLocation(d.width/4 + 80, d.height/4);
            allBooking.setVisible(true);
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        okButton = new javax.swing.JButton("OK");
        cancelButton = new javax.swing.JButton();
        booking1 = new javax.swing.JCheckBox("", true);
        booking2 = new javax.swing.JCheckBox("", true);
        booking3 = new javax.swing.JCheckBox("", true);
        booking4 = new javax.swing.JCheckBox("", true);
        booking5 = new javax.swing.JCheckBox("", true);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
       cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
 
        try
        {
            if (myBookings.size() > 0)
            {
                booking1.setText(myBookings.get(0));
            }
            else
            {
                booking1.setVisible(false);
            }

        }
        catch (IndexOutOfBoundsException ie)
        {
            booking1.setSelected(false);
        }
        booking1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booking1ActionPerformed(evt);
            }
        });

        try
        {
            if (myBookings.size() > 1)
            {
                booking2.setText(myBookings.get(1));
            }

            else
            {
                booking2.setVisible(false);
                booking2.setSelected(false);
            }

            try
            {
                if (myBookings.size() > 2)
                {
                    booking3.setText(myBookings.get(2));
                }

                else
                {
                    booking3.setVisible(false);
                    booking3.setSelected(false);
                }

                try
                {
                    if (myBookings.size() > 3)
                    {
                        booking4.setText(myBookings.get(3));
                    }
                    else
                    {
                        booking4.setVisible(false);
                        booking4.setSelected(false);
                    }

                    try
                    {
                        if (myBookings.size() >= 5)
                        {
                            booking5.setText(myBookings.get(4));
                        }

                        else
                        {
                            booking5.setVisible(false);
                            booking5.setSelected(false);
                        }

                        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
                        jLabel1.setText("                Below are today's bookings.");

                       

                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cancelButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(booking5)
                                                        .addComponent(booking4)
                                                        .addComponent(booking3)
                                                        .addComponent(booking2)
                                                        .addComponent(booking1))
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
                        );

                        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

                        layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(booking1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(booking2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(booking3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(booking4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(booking5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cancelButton)
                                    .addComponent(okButton))
                                .addContainerGap())
                        );

                        getRootPane().setDefaultButton(okButton);
                    }

                    catch (IndexOutOfBoundsException ie)
                    {
                        booking2.setSelected(false);
                    }
                }

                catch (IndexOutOfBoundsException ie)
                {
                    booking3.setSelected(false);
                }
            }

            catch (IndexOutOfBoundsException ie)
            {
                booking4.setSelected(false);
            }
        }

        catch (IndexOutOfBoundsException ie)
        {
            booking5.setSelected(false);
        }

        pack();
    }// </editor-fold>                        

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        doClose(RET_OK);
        
   
    }                                        
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        doClose(RET_CANCEL);
    }                                            

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {                             
        doClose(RET_CANCEL);
    }                            

    private void booking1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SaveBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaveBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaveBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaveBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SaveBookings dialog = new SaveBookings(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    public static javax.swing.JCheckBox booking1;
    public static javax.swing.JCheckBox booking2;
    public static javax.swing.JCheckBox booking3;
    public static javax.swing.JCheckBox booking4;
    public static javax.swing.JCheckBox booking5;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton okButton;
    // End of variables declaration                   
    private int returnStatus = RET_CANCEL;


    
    
    
    
    }
