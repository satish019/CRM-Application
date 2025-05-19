
package CreateOrganization;

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


public class CreateOrganisationTestUsingGenericUtility {

		public static void main(String[] args) throws IOException, InterruptedException {
			
			FileInputStream fis = new FileInputStream("./configappdata/New Text Document.txt");
			
			
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
					driver.findElement(By.linkText("Create an Organization")).click();
						
					driver.findElement(By.xpath("//img[@title='Create Organization..']")).click();
					CharSequence orgName = null;
					driver.findElement(By.name("accountname")).sendKeys(orgName);
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					if(headerinfo.contains(orgName)) {
						System.out.println(orgName + "is created==PASS");
					} else {
						System.out.println(orgName + "is not created==FAIL");
						
					}
					
					driver.quit();
				}

			}
	

