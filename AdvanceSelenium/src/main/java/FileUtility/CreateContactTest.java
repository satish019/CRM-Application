package FileUtility;



import java.io.IOException;



import org.openqa.selenium.By;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMRepository.OrgInfoPage;

import TestNG.BaseClass;
import junit.framework.Assert;



public class CreateContactTest extends BaseClass{
@Test(groups="smokeTest")
	public  void  createContactTest() throws IOException, InterruptedException {
		
		
		
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		
			
				
				OrgInfoPage oip = new OrgInfoPage(driver);
				oip.getContactLink().click();
				OrgInfoPage oip2 = new OrgInfoPage(driver);
				oip2.getCreateContact().click();
				OrgInfoPage oip3 = new OrgInfoPage(driver);
				oip3.getContacttextfield(lastName);
				
				String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
				
				if(actLastName.contains(lastName)) {
					System.out.println(lastName + "information is verified==PASS");
				} else {
					System.out.println(lastName + "information is not verified==FAIL");
					//boolean status = actLastName.contains(lastName);
					//Assert.assertEquals(status, true);
					SoftAssert soft = new SoftAssert();
					soft.assertEquals(actLastName, lastName);
			
				}
				}
	
@Test(groups = "regressionTest")
public void CreateContactWithSupportDate() throws IOException {
	String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
	
	
	OrgInfoPage oip = new OrgInfoPage(driver);
	oip.getContactLink().click();
	
	
	OrgInfoPage oip2 = new OrgInfoPage(driver);
	oip2.getCreateContact().click();
	OrgInfoPage oip3 = new OrgInfoPage(driver);
	oip3.getContacttextfield(lastName);
	String endDate = jLib.getSystemDateYYYYMMDD();
	String StartDate = jLib.getRequireDateYYYYMMDD(30);
	
	

	driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(StartDate);	

		
	
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	
			
			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
			String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
			
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actLastName, lastName);
			
		}
	


@Test(groups = "regressionTest")
public void CreateContactWithOrg() throws IOException {
	String orgName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
	String contactLastName = eLib.getDataFromExcel("contact", 1, 2);
	
		
			
			
	
			
			driver.findElement(By.linkText("Organizations")).click();
			
				
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
			boolean status = headerInfo.contains(orgName);
			Assert.assertEquals(status, true);
			String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actOrgName, contactLastName);
			
}}





