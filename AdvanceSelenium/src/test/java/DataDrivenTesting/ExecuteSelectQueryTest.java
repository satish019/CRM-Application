package DataDrivenTesting;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.cj.protocol.a.authentication.*;

import dev.failsafe.internal.util.Assert;

import com.mysql.cj.jdbc.Driver;
public class ExecuteSelectQueryTest {
	
	@Test
	public static void main(String[] args) throws Throwable{
		
		Connection conn = null;
		try {
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema", "root" , "root");
	System.out.println("======Done======");
	Statement stat = conn.createStatement();
	ResultSet Resultset = stat.executeQuery("select * from character_sets;");
	while(Resultset.next()) {
		System.out.println(Resultset.getString(1)+ "\t"  + Resultset.getString(2) + "\t" +  Resultset.getString(3) + "\t"+ Resultset.getString(4));	
		}
	}
	catch(Exception e) {
		System.out.println("Handle Exception");
	} finally {
		conn.close();
		System.out.println("=====close the connection=====");
	}
}}
	