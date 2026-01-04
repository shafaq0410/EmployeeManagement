
package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    
    private static Connection conn;
    static {
        
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-1TEM5OV:1522/xe" , "disha" ,"admindisha" );
        }
        catch(SQLException ex){
            System.out.println("Exception in  connecting to the DB !"+ ex.getMessage());
            
//            exit the code the right away if you're unable to get connected to the database 

             System.exit(0);
        }
        
    }
     public static Connection getConnection(){
            System.out.println("Connected Successfully ");
            return conn;
           
        }
      public static void closeConnection(){
//            close throws exception 
           try{
               conn.close();
               System.out.println("Disconnected Successfully ");
           }
           catch(SQLException ex){
                System.out.println("Exception occured in closing the data base !"+ ex.getMessage());
           }
           
        }
}
