/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bike_shop_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class AllConnections {
    
    public void motifyUsersUserIdList(ArrayList<String> list, ArrayList<String> list2, ArrayList<String> list3){
        ArrayList firstName = new ArrayList();
        ArrayList lastName = new ArrayList();
        ArrayList user_id = new ArrayList();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;

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

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM users");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                user_id.add(resultSet.getString(1));
                firstName.add(resultSet.getString(4));
                lastName.add(resultSet.getString(5));
               
            }
            
            
            for(int i = 0; i < firstName.size(); i++){
                list.add((String) firstName.get(i));
            }
            
            for(int i = 0; i < lastName.size(); i++){
                list2.add((String) lastName.get(i));
            }
            
            for(int i = 0; i < user_id.size(); i++){
                list3.add((String) user_id.get(i));
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
        }
    
    public void overdueAccount(ArrayList<String> list){
        ArrayList user_id = new ArrayList();
        ArrayList item_rented = new ArrayList();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
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

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM rented_stock WHERE Overdue_date < 2022-12-04");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                user_id.add(resultSet.getString(1));
              //  item_rented.add(resultSet.getString(3));
               
               
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
        
        for(int i = 0; i < user_id.size(); i++){
                list.add((String) user_id.get(i));
            }
  
       
    }
    
    public void deleteFromRented(int reference_id){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
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


            String sqlQuery = "DELETE FROM rented_stock WHERE rented_id = '" + reference_id + "'";
            statement.executeUpdate(sqlQuery);
            String welcomeMessage = " you have returned your item ";
            JOptionPane.showMessageDialog(null, welcomeMessage);

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    
    public void deleteFromSales(int reference_id){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
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


            String sqlQuery = "DELETE FROM sales WHERE sale_id = '" + reference_id + "'";
            statement.executeUpdate(sqlQuery);
            String welcomeMessage = " you have returned your item ";
            JOptionPane.showMessageDialog(null, welcomeMessage);

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    
    public void selectFromRentStock(ArrayList<String> list){
        ArrayList how_many = new ArrayList();
        ArrayList item_rented = new ArrayList();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
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

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM rented_stock");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                how_many.add(resultSet.getString(4));
                item_rented.add(resultSet.getString(3));
               
               
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
        
        for(int i = 0; i < item_rented.size(); i++){
                list.add((String) item_rented.get(i));
            }
        
        
    }
    
    public void selectFromRentStockItem(ArrayList<String> list, ArrayList<String> list2){
        ArrayList how_many = new ArrayList();
        ArrayList item_rented = new ArrayList();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
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

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM rented_stock");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                how_many.add(resultSet.getString(4));
                item_rented.add(resultSet.getString(3));
               
               
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
        
        for(int i = 0; i < item_rented.size(); i++){
                list.add((String) item_rented.get(i));
            }
        
        for(int i = 0; i < how_many.size(); i++){
                list2.add((String) how_many.get(i));
            }
    }
    
    public void insertRented(int user_id_num, String item_to_rent, int number, LocalDate date){
        ArrayList readValues = new ArrayList();
        ArrayList referenceNum = new ArrayList();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
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
            
            String sqlQuery = "INSERT INTO rented_stock(user_id, item_rented, how_many_items, Overdue_date) VALUES('" + user_id_num + "', '" + item_to_rent + "', '" + number + "', '2022-12-03')";
            statement.executeUpdate(sqlQuery);
            
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        } 
    }
    
    public void motifySalesReferenceList(ArrayList<String> list){
        ArrayList salesReference = new ArrayList();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
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

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM sales");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                salesReference.add(resultSet.getString(1));
               
               
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
        
        for(int i = 0; i < salesReference.size(); i++){
                list.add((String) salesReference.get(i));
            }
    }
    
    public void motifySales(String what_item_to_purchase, int newSubtract, LocalDate date){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
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

            String sqlQuery = "INSERT INTO sales(user_id, item_bought, how_many, when_purchased) VALUES('3', '" + what_item_to_purchase + "', '" + newSubtract + "', '" + date + "')";
            
            statement.executeUpdate(sqlQuery);
            
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    
    public void subtractStock(String value, String tempValue, int number, ArrayList<Integer> readValues, int newSubtract){
        
        
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
    }
    
    public void updateCurrentStock(String value, int number){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;
        
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
    }
    
    
    public void selectAllCurrentStock(ArrayList<Integer> list){
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
        
        for(int i = 0; i < readValues.size(); i++){
                list.add((Integer) readValues.get(i));
            }
    }
    
    
    public void motifyUsersList(ArrayList<String> list, ArrayList<String> list2){
        ArrayList firstName = new ArrayList();
        ArrayList lastName = new ArrayList();
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;

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

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM users");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                firstName.add(resultSet.getString(4));
                lastName.add(resultSet.getString(5));
               
            }
            
            
            for(int i = 0; i < firstName.size(); i++){
                list.add((String) firstName.get(i));
            }
            
            for(int i = 0; i < lastName.size(); i++){
                list2.add((String) lastName.get(i));
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
        }
    
    public void add_user(String userName, String passWord, String firstName, String surName, int admin_id){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;

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
 
            String sqlQuery = "INSERT INTO users(user_name, password, first_name, surname, admin_id) VALUES('" + userName + "', '" + passWord + "', '" + firstName + "', '" + surName + "', '" + admin_id + "')";
            
            statement.executeUpdate(sqlQuery);
            String welcomeMessage = " Welcome " + firstName + " " + surName;
            JOptionPane.showMessageDialog(null, welcomeMessage);
            
            
        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    
    public void remove_user(String id_num){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;

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

  
            
            String sqlQuery = " DELETE FROM users WHERE user_id='" + id_num + "'";

            statement.executeUpdate(sqlQuery);
            String welcomeMessage = "The user has been removed from the database ";
            JOptionPane.showMessageDialog(null, welcomeMessage);
            

        } catch (SQLException sqlex) {
            System.err.println(sqlex.getMessage());
        }
    }
    
    public void selectFromUsersNameAndId(ArrayList<String> list, ArrayList<String> list2, ArrayList<String> list3){
        ArrayList firstName = new ArrayList();
        ArrayList lastName = new ArrayList();
        ArrayList user_id = new ArrayList();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String msAccDB = "..//Bike_Shop1.accdb"; // path to the DB file
        String dbURL = "jdbc:ucanaccess://" + msAccDB;

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

            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM users");

            // processing returned data and printing into console
            // Step 2.D: use data from ResultSet
            while (resultSet.next()) {
                firstName.add(resultSet.getString(4));
                lastName.add(resultSet.getString(5));
                user_id.add(resultSet.getString(1));
               
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
        for(int i = 0; i < firstName.size(); i++){
                list.add((String) firstName.get(i));
            }
        
        for(int i = 0; i < lastName.size(); i++){
                list2.add((String) lastName.get(i));
            }
        
        for(int i = 0; i < user_id.size(); i++){
                list3.add((String) user_id.get(i));
            }
        
    }
}
