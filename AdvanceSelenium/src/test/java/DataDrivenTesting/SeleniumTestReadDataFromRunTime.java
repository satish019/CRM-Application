package DataDrivenTesting;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTestReadDataFromRunTime {
	  
	@Test
	public void seleniumTest() throws IOException, InterruptedException
	{
		FileInputStream fisl = new FileInputStream("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\New Text Document.txt");
		Properties wb = new Properties();
		wb.load(fisl);
		String BROWSER = wb.getProperty("browser");
		String URL = wb.getProperty("url");
		String USERNAME = wb.getProperty("username");
		String PASSWORD = wb.getProperty("password");
		
		
		
		
		
		WebDriver  driver = null;
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
			
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		
		
		driver.get(URL);
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.linkText("Create an Organization")).click();
		driver.findElement(By.name("accountname")).sendKeys(USERNAME);	
		driver.findElement(By.name("button")).click();	
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).click();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().build().perform();
		Thread.sleep(2000);
		driver.quit();
	}

}


		
		
	
