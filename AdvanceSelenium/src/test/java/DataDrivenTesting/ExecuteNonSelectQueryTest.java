package DataDrivenTesting;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.cj.protocol.a.authentication.*;

import dev.failsafe.internal.util.Assert;

import com.mysql.cj.jdbc.Driver;
public class ExecuteNonSelectQueryTest {

	@Test
	public static void main(String[] args) throws Throwable{
		
	
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema", "root" , "root");
	System.out.println("======Done======");
	Statement stat = conn.createStatement();
	
	int result = stat.executeUpdate("insert into character_sets values('PROJ2025' , 'Satish_Bokka', 'Satish Bokka' ,'3' ); ");
	System.out.println(result);
	
	conn.close();
	}}