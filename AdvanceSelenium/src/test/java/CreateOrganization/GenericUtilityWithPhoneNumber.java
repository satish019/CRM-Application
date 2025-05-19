package CreateOrganization;

	import java.io.FileInputStream;


	import java.io.IOException;
	import java.util.Properties;
import java.util.Random;

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

public class GenericUtilityWithPhoneNumber {

		public static void main(String[] args) throws IOException, InterruptedException {
			
			FileInputStream fis = new FileInputStream("./configappdata/New Text Document.txt");
			
			
			Properties pObj = new Properties();
			pObj.load(fis);
			
			String BROWSER =pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD =pObj.getProperty("password");
			
			Random random = new Random();
			int randomInt = random.nextInt(1000);
			
			FileInputStream fisl = new FileInputStream("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\ReadDataFromExcelTest.xlsx");
			Workbook wb = WorkbookFactory.create(fisl);
					
					Sheet sh = wb.getSheet("Sheet1");
					
					Row row = sh.getRow(7);
					
					
					String data = row.getCell(2).toString() + randomInt;
					String PhoneNumber = row.getCell(3).getStringCellValue();
					
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
					
						
					driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
					
					driver.findElement(By.name("accountname")).sendKeys(data);
					driver.findElement(By.id("phone")).sendKeys(PhoneNumber);
					
					
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
					
					if(actPhoneNumber.contains(PhoneNumber)) {
						System.out.println(PhoneNumber + "information is created==PASS");
					} else {
						System.out.println(PhoneNumber + "information is not created==FAIL");
						
						
				
				}
driver.quit();
					}}
	