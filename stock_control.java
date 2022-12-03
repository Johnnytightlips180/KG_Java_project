/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bike_shop_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kian Barker & Gaving Judge 28/11/22
 */
public class stock_control extends javax.swing.JFrame {

    /**
     * Creates new form stock_control
     */
    public stock_control() {
        initComponents();
        ArrayList readValues = new ArrayList();
        ArrayList readRentedValues = new ArrayList();
        ArrayList howManyValues = new ArrayList();
        
        stock_items.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Push Bike", "Electric Bike", "Petrol Bike", "HelmetS", "Lights", "Chains" }));
        current_stock.setEditable(false);
        rented_stock.setEditable(false);
       
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
        
        try {
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
        // Step 2: Opening database connection
        try {
            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM current_stock");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                readValues.add(resultSet.getInt(2));
                readValues.add(resultSet.getInt(3));
                readValues.add(resultSet.getInt(4));
                readValues.add(resultSet.getInt(5));
                readValues.add(resultSet.getInt(6));
                readValues.add(resultSet.getInt(7));
               
            }
             

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        } finally {

            // Step 3: Closing database connection
            try {
                if (null != connection) {
                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();
                    // and then finally close connection
                    connection.close();
                }
            } catch (SQLException sqlex) {
                System.err.println(sqlex.getMessage());
            }
        }
        
     //   System.out.println(readValues.getClass());
     //   System.out.println(readValues.get(1).getClass());
        int value1 = 0;
        value1 = (int) readValues.get(1);
       
        current_stock.append((String) "Push bike: " + readValues.get(0)+ "\nElectric bike: " + readValues.get(1) + "\nPetrol Bike: " + readValues.get(2)+ "\nHelmets:" + readValues.get(3) + "\nLights: " + readValues.get(4) + "\nChains : " + readValues.get(5));
        
        
        try {
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
        // Step 2: Opening database connection
        try {
            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM rented_stock");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                readRentedValues.add(resultSet.getInt(4));
                howManyValues.add(resultSet.getString(3));
                
               
            }
             

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        } finally {

            // Step 3: Closing database connection
            try {
                if (null != connection) {
                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();
                    // and then finally close connection
                    connection.close();
                }
            } catch (SQLException sqlex) {
                System.err.println(sqlex.getMessage());
            }
        }
        
        for(int i = 0; i < readRentedValues.size(); i++)
        {
            rented_stock.append((String) howManyValues.get(i)+ ": " + readRentedValues.get(i) + "\n");
        }           
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        current_stock = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        rented_stock = new javax.swing.JTextArea();
        stock_items = new javax.swing.JComboBox<>();
        how_many_items = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Welcome to stock control center");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Stock control center");

        jLabel1.setText("Current stock");

        jLabel3.setText("Rented stock");

        jLabel4.setText("Add and subtract stock");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_shop_application/add.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bike_shop_application/exit.png"))); // NOI18N
        jButton2.setText("Subtract");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        current_stock.setColumns(20);
        current_stock.setRows(5);
        jScrollPane1.setViewportView(current_stock);

        rented_stock.setColumns(20);
        rented_stock.setRows(5);
        jScrollPane2.setViewportView(rented_stock);

        stock_items.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(how_many_items, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(stock_items, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                .addGap(60, 88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(45, 45, 45)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(stock_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(how_many_items, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(134, 134, 134))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ArrayList readValues = new ArrayList();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
        
        try {
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
        // Step 2: Opening database connection
        try {
            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM current_stock");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                readValues.add(resultSet.getInt(2));
                readValues.add(resultSet.getInt(3));
                readValues.add(resultSet.getInt(4));
                readValues.add(resultSet.getInt(5));
                readValues.add(resultSet.getInt(6));
                readValues.add(resultSet.getInt(7));
               
            }
             

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        } finally {

            // Step 3: Closing database connection
            try {
                if (null != connection) {
                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();
                    // and then finally close connection
                    connection.close();
                }
            } catch (SQLException sqlex) {
                System.err.println(sqlex.getMessage());
            }
        }
        
        String tempValue = stock_items.getSelectedItem().toString();
        String subtract = how_many_items.getText();
        int newSubtract = Integer.parseInt(subtract);
        
        
        String value = "";
        int number = 0;
        
        if (tempValue == "Push Bike")
        {
            int x = (int) readValues.get(0);
            value = "push_bikes";
            number = x - newSubtract;
                    
        } else if (tempValue == "Electric Bike")
        {
            int x = (int) readValues.get(1);
            value = "electric_bike";
            number = x - newSubtract;
        }  else if (tempValue == "Petrol Bike")
        {
            int x = (int) readValues.get(2);
            value = "petrol_bike";
            number = x - newSubtract;
        }  else if (tempValue == "Helmets")
        {
            int x = (int) readValues.get(3);
            value = "helmets";
            number = x - newSubtract;
        }  else if (tempValue == "Lights")
        {
            int x = (int) readValues.get(4);
            value = "lights";
            number = x - newSubtract;
        } else 
        {
            int x = (int) readValues.get(5);
            value = "chains";
            number = x - newSubtract;
        }
        
        // Step 1: Loading or registering JDBC driver class
        try {
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }

        // Step 2: Opening database connection
        try {

            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            String sqlQuery = "UPDATE current_stock SET " + value + " = " + number + " WHERE product_id = 1";
            System.out.println(sqlQuery);
            statement.executeUpdate(sqlQuery);

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
        
        String welcomeMessage = " you have subtracted " + newSubtract + " " + tempValue;
        JOptionPane.showMessageDialog(null, welcomeMessage);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList readValues = new ArrayList();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
        
        try {
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
        // Step 2: Opening database connection
        try {
            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM current_stock");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                readValues.add(resultSet.getInt(2));
                readValues.add(resultSet.getInt(3));
                readValues.add(resultSet.getInt(4));
                readValues.add(resultSet.getInt(5));
                readValues.add(resultSet.getInt(6));
                readValues.add(resultSet.getInt(7));
               
            }
             

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        } finally {

            // Step 3: Closing database connection
            try {
                if (null != connection) {
                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();
                    // and then finally close connection
                    connection.close();
                }
            } catch (SQLException sqlex) {
                System.err.println(sqlex.getMessage());
            }
        }
        
        String tempValue = stock_items.getSelectedItem().toString();
        String subtract = how_many_items.getText();
        int newAdd = Integer.parseInt(subtract);
        
        
        String value = "";
        int number = 0;
        
        if (tempValue == "Push Bike")
        {
            int x = (int) readValues.get(0);
            value = "push_bikes";
            number = x + newAdd;
                    
        } else if (tempValue == "Electric Bike")
        {
            int x = (int) readValues.get(1);
            value = "electric_bike";
            number = x + newAdd;
        }  else if (tempValue == "Petrol Bike")
        {
            int x = (int) readValues.get(2);
            value = "petrol_bike";
            number = x + newAdd;
        }  else if (tempValue == "Helmets")
        {
            int x = (int) readValues.get(3);
            value = "helmets";
            number = x + newAdd;
        }  else if (tempValue == "Lights")
        {
            int x = (int) readValues.get(4);
            value = "lights";
            number = x + newAdd;
        } else 
        {
            int x = (int) readValues.get(5);
            value = "chains";
            number = x + newAdd;
        }
        
        // Step 1: Loading or registering JDBC driver class
        try {
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }

        // Step 2: Opening database connection
        try {

            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement
            statement = connection.createStatement();

            String sqlQuery = "UPDATE current_stock SET " + value + " = " + number + " WHERE product_id = 1";
            statement.executeUpdate(sqlQuery);

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
        
        String welcomeMessage = " you have added " + newAdd + " " + tempValue;
        JOptionPane.showMessageDialog(null, welcomeMessage);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(stock_control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stock_control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stock_control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stock_control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stock_control().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea current_stock;
    private javax.swing.JTextField how_many_items;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea rented_stock;
    private javax.swing.JComboBox<String> stock_items;
    // End of variables declaration//GEN-END:variables
}
