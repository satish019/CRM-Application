package DataDrivenTesting;


import  org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.cj.jdbc.Driver; 
import org.openqa.selenium.devtools.CdpVersionFinder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateProjectAndVerifyData {
  public static void main(String[] args) throws SQLException
  {
	String employeeName = "big5";
	
	WebDriver driver = new ChromeDriver();
	 driver.get("http://49.249.28.218:8091/");
	
	 driver.findElement(By.id("username")).sendKeys("rmgyantra");
	 driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	 
	 driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	  
	   driver.findElement(By.linkText("Employees")).click();
	 driver.findElement(By.xpath("//span[text()='Add New Employee']")).click();
	 driver.findElement(By.name("text")).sendKeys(employeeName);
	 driver.findElement(By.name("email")).sendKeys("satish");
	 Select sel = new Select(driver.findElement(By.name("employee")));
	 sel.selectByIndex(0);
	 driver.findElement(By.xpath("//input[@value='Add']")).click();
	 boolean flag = false;
	 
	 //Verify the project in Backend using JDBC
	 Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema", "root" , "root");
		System.out.println("======Done======");
		Statement stat = conn.createStatement();
		ResultSet Resultset = stat.executeQuery("select * from character_sets;");
		while(Resultset.next()) {
			//System.out.println(Resultset.getString(1)+ "\t"  + Resultset.getString(2) + Resultset.getString(3));	
			String actProjectName = Resultset.getString(4);
			
			if(employeeName.equals(actProjectName))
			{
				 flag = true;
				System.out.println(employeeName + " is available==PASS");
			}
		}
		if(flag == false) {
		System.out.println(employeeName + " is not available==FAIL");
		
		}
		conn.close();
	

	
}
}