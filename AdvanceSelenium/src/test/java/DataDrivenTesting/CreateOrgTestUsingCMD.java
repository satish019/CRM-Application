package DataDrivenTesting;

import java.io.FileInputStream;





import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
import org.testng.annotations.Test;



public class CreateOrgTestUsingCMD {
	
	@Test
	public  void CreateOrgTest() throws IOException, InterruptedException {
		

		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
		FileInputStream fisl = new FileInputStream("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\ReadDataFromExcelTest.xlsx");
Workbook wb = WorkbookFactory.create(fisl);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		Row row = sh.getRow(1);
		
		
		String data = row.getCell(2).toString() + randomInt;
		
		
		wb.close();
	
		
		
		
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
		
		
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		//driver.findElement(By.linkText("Create an Organization")).click();
		//driver.findElement(By.name("accountname")).sendKeys(data);	
		//driver.findElement(By.name("button")).click();	
		//driver.findElement(By.xpath("//img[@title='Create Organization..']")).click();
		//driver.findElement(By.name("accountname")).sendKeys("facebook");
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).click();
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().build().perform();
		Thread.sleep(2000);
		driver.quit();
	}

}
