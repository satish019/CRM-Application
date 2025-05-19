package CreateContactTest;

	import java.io.FileInputStream;



	import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

import FileUtility.ExcelUtility;
import FileUtility.FileUtility;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

public class CreateContactWithOrg {

		public static void main(String[] args) throws IOException, InterruptedException {
			FileUtility fLib = new FileUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			ExcelUtility eLib = new ExcelUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriver driver = null;
			
			
			String orgName = eLib.getDataFromExcel("Sheet1", 7, 2) + jLib.getRandomNumber();
			String contactLastName = eLib.getDataFromExcel("Sheet1", 7, 3);
			
				
					
					
			
					
					driver.findElement(By.linkText("Organizations")).click();
					driver.findElement(By.linkText("Create an Organization")).click();
						
					driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
					driver.findElement(By.name("accountname")).sendKeys(orgName);
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
					
					String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					if(headerinfo.contains(orgName)) {
						System.out.println(orgName + "is verified==PASS");
					} else {
						System.out.println(orgName + "is not verified==FAIL");
						
					}
					
					
					driver.findElement(By.linkText("Contacts")).click();
					
						
					driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
					
					driver.findElement(By.name("lastname")).sendKeys(contactLastName);
					driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
					
					
					wLib.switchNewBrowserTab(driver, "module=Accounts");
					
					
					
				
					
					driver.findElement(By.name("search_text")).sendKeys(orgName);
					driver.findElement(By.name("search")).click();
					driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
					
					wLib.switchNewBrowserTab(driver, "Contacts&action");
					
					
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					if(headerInfo.contains(orgName)) {
						System.out.println(orgName + "is verified==PASS");
					} else {
						System.out.println(orgName + "is not verified==FAIL");
						
					}
					String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
					if(actOrgName.contains(contactLastName)) {
						System.out.println(contactLastName + "is created==PASS");
					} else {
						System.out.println(contactLastName + "is not created==FAIL");
						
					}
				
				}

			}
	