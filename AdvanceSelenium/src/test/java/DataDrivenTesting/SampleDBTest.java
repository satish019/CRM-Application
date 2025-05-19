package DataDrivenTesting;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;





import com.mysql.cj.jdbc.Driver;
public class SampleDBTest {

	@Test
	public static void main(String[] args) throws Throwable{
		
	
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema", "root" , "root");
	System.out.println("======Done======");
	Statement stat = conn.createStatement();
	
	
	
	ResultSet Resultset = stat.executeQuery("select * from character_sets;");
	while(Resultset.next()) {
		System.out.println(Resultset.getString(1)+ "\t"  + Resultset.getString(2) + "\t"+ Resultset.getString(3) + "\t" + Resultset.getInt(4));	}
	conn.close();
	}}