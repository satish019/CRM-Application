package CreateContactTest;

	import java.io.FileInputStream;




	import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import FileUtility.ExcelUtility;
import FileUtility.FileUtility;
import POMRepository.OrgInfoPage;
import TestNG.BaseClass;
import WebDriverUtility.JavaUtility;

public class CreateContactWithSupportDate extends BaseClass{

		public static void main(String[] args) throws IOException, InterruptedException {
			
			 FileUtility fLib = new FileUtility();
			 ExcelUtility eLib = new ExcelUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriver driver = null;
			
					
			String lastName = eLib.getDataFromExcel("Sheet1", 1, 3) + jLib.getRandomNumber();
					
					
			OrgInfoPage oip = new OrgInfoPage(driver);
			oip.getContactLink().click();
			
			
			OrgInfoPage oip2 = new OrgInfoPage(driver);
			oip2.getCreateContact().click();
				String endDate = jLib.getSystemDateYYYYMMDD();
					
				String startDate = jLib.getRequireDateYYYYMMDD(30);	
					
			
					
					driver.findElement(By.name("support_start_date")).clear();
					driver.findElement(By.name("support_start_date")).sendKeys(startDate);
					driver.findElement(By.name("support_end_date")).clear();
					driver.findElement(By.name("support_end_date")).sendKeys(endDate);
					
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
					
					if(actLastName.contains(lastName)) {
						System.out.println(lastName + "information is created==PASS");
					} else {
						System.out.println(lastName + "information is not created==FAIL");
						
				}
					String actStartName = driver.findElement(By.id("dtlview_Support Start Date")).getText();
					
					if(actStartName.contains(startDate)) {
						System.out.println(startDate + "information is created==PASS");
					} else {
						System.out.println(startDate + "information is not created==FAIL");
						
				}
					String actendName = driver.findElement(By.id("dtlview_Support End Date")).getText();
					if(actendName.contains(endDate)) {
						System.out.println(endDate + "information is created==PASS");
					} else {
						System.out.println(endDate + "information is not created==FAIL");
						
				}
					
driver.quit();
					}}