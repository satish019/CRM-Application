package DataDrivenTesting;

import static org.testng.Assert.fail;
import  org.testng.asserts.Assertion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;



import com.mysql.cj.jdbc.Driver;
public class ReadDataFromDataBase {

	@Test
	public void ProjectCheckTest() throws Throwable{
		String CHARACTER_SET_NAME  = "big5";
	boolean flag = false;
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	

	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema", "root" , "root");
	System.out.println("======Done======");
	Statement stat = conn.createStatement();
	ResultSet Resultset = stat.executeQuery("select * from character_sets;");
	while(Resultset.next()) {
		//System.out.println(Resultset.getString(1)+ "\t"  + Resultset.getString(2) + Resultset.getString(3));	
		String actProjectName = Resultset.getString(1);
		
		if(CHARACTER_SET_NAME.equals(actProjectName))
		{
			 flag = true;
			System.out.println(CHARACTER_SET_NAME + " is available==PASS");
		}
	}
	if(flag == false) {
	System.out.println(CHARACTER_SET_NAME + " is not available==FAIL");
	Assert.fail();
	}
	conn.close();
}}
