package DataDrivenTesting;


	

	import java.io.FileInputStream;


	import java.io.IOException;
	import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

	public class CreateOrgTestUsingProperty {

		public static void main(String[] args) throws IOException, InterruptedException {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\New Text Document.txt");
			
			
			Properties pObj = new Properties();
			pObj.load(fis);
			
			String BROWSER =pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD =pObj.getProperty("password");
			
			FileInputStream fisl = new FileInputStream("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\ReadDataFromExcelTest.xlsx");
			Workbook wb = WorkbookFactory.create(fisl);
					
					Sheet sh = wb.getSheet("Sheet1");
					
					Row row = sh.getRow(1);
					
					
					String data = row.getCell(2).toString();
					
					
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
	
