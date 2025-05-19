package WebDriverUtility;





import java.io.FileInputStream;




import java.io.IOException;
import java.util.Properties;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import FileUtility.ExcelUtility;
import FileUtility.FileUtility;

public class CreateWebDriverUtility {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
	  WebDriverUtility wLib = new WebDriverUtility();
		
		
		String BROWSER =fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
			
				
				WebDriver driver = null;
				
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
				
				
				wLib.waitForPageToLoad(driver);
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				driver.findElement(By.linkText("Contacts")).click();
				
					
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				
				
				String startDate = jLib.getSystemDateYYYYMMDD();
				String endDate = jLib.getRequireDateYYYYMMDD(30);
				
				driver.findElement(By.name("lastname")).sendKeys(orgName);
				driver.findElement(By.name("support_start_date")).clear();
				driver.findElement(By.name("support_start_date")).sendKeys(startDate);
				driver.findElement(By.name("support_end_date")).clear();
				driver.findElement(By.name("support_end_date")).sendKeys(endDate);
				
				
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
				if(actStartDate .contains(startDate)) {
					System.out.println(startDate + "information is verified==PASS");
				} else {
					System.out.println(startDate + "information is not verified==FAIL");
					
					
			
			}
driver.quit();
				}}
