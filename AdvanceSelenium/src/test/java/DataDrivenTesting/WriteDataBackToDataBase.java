package DataDrivenTesting;






	



	import com.mysql.cj.jdbc.Driver;



	import java.sql.Statement;

	import java.sql.Connection;

import java.sql.DriverManager;
	import java.sql.ResultSet;


	 public class WriteDataBackToDataBase {
		public static void main(String[] args) throws Exception{
	    	  Driver driver = new Driver();
	    	  DriverManager.registerDriver(driver);
	    	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema","root","root");
	    	  Statement s = con.createStatement();
	    	 
	    	  ResultSet resultset = s.executeQuery("select * from character_sets");
	    	  while(resultset.next() )
	    	  {
	    		  System.out.println(resultset.getString(1) +"\t"+ resultset.getString(2) +"\t"+ resultset.getInt(3) );
	    	  
	      }
	    	  
	    	  s.executeUpdate(null);
	    	  System.out.println("Data written to database succesfully");
	    	  s.close();
	    	  con.close();
	}
	
	

}


