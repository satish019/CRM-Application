package DataBaseUtility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateDataBaseUtility {
	
	
	Connection con;
	private CreateDataBaseUtility dbUtil;
	
      public  void getDbconnection(String url, String username, String password) throws SQLException {
    	  try {
      
    	  Driver driver = new Driver();
    	  DriverManager.registerDriver(driver);
    	  Connection con = DriverManager.getConnection(url, username, password);
    	  
    	  
      } catch (Exception e) {
    	  
      }
}  
      
      public void getDbconnection() throws SQLException {
    	  try {
      
    	  Driver driver = new Driver();
    	  DriverManager.registerDriver(driver);
    	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema","root", "root");
    	  
    	  
    	  
      } catch (Exception e) {
    	  
      }
}  
      
      public static void main(String[] args) {
    	  CreateDataBaseUtility dbUtil = new CreateDataBaseUtility();
    	  try {
    		  dbUtil.getDbconnection();
    		  System.out.println("Database connection established succesfully");
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  }
      }
      
      
      
      
      
      
      
   //   public   void closeDbconnection() throws SQLException {
    //	  try {
    		  
		//		con.close();
		//	} catch (Exception e) {
				
		//	}
    	 
	
//}
      public ResultSet executeConSelectQuery(String query) throws Throwable {
    	ResultSet result = null;
    	  try {
    	 Statement stat =  con.createStatement();
    	result = stat.executeQuery(query);
    	 ResultSet rs = dbUtil.executeConSelectQuery("SELECT * FROM character_sets");
	        while (rs.next()) {
	            System.out.println("Row: " + rs.getString("character_set_name") + ", " + rs.getString("default_collate_name"));
      } }catch (Exception e) {
      }
    	 return result;
      }
      public ResultSet executeNonSelectQuery(String query) throws Throwable {
    	  int result = (Integer) null;
    	  try {
    	 Statement stat =  con.createStatement();
    result = stat.executeUpdate(query);
   
  	      ResultSet rs = dbUtil.executeNonSelectQuery("insert into character_sets values('PROJ2025' , 'Satish_Bokka', 'Satish Bokka' ,'3' ); ");
	        while (rs.next()) {
	            System.out.println("Row: " + rs.getString("character_set_name") + ", " + rs.getString("default_collate_name"));
	        }
      } catch (Exception e) {
      }
    	 return null;
      }
      
    	    
    	
public   void closeDbconnection() throws SQLException {
	  try {
		  
			con.close();
		} catch (Exception e) {
			
		}
	 
}
}
 

