package FileUtility;

	import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import com.aventstack.extentreports.Status;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TestNG.BaseClass;
import WebDriverUtility.UtilityClassObject;


@Listeners(ListenerClass.class)   

public class CreateOrganization extends BaseClass{
@Test(groups="smokeTest")
		public  void CreateOrganisationTestUsingGenericUtility() throws IOException, InterruptedException {
	 UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
			
			String orgName = eLib.getDataFromExcel("contact", 3, 2) + jLib.getRandomNumber();
		
			 UtilityClassObject.getTest().log(Status.INFO, "Navigate To Org Page");
					driver.findElement(By.linkText("Organizations")).click();
			
					 UtilityClassObject.getTest().log(Status.INFO, "Navigate To Create Org Page");
					driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
					
					driver.findElement(By.name("accountname")).sendKeys(orgName);
					 UtilityClassObject.getTest().log(Status.INFO, "Navigate To Create Org Page");
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					 UtilityClassObject.getTest().log(Status.INFO, "Navigate To Create Org Page");
					String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					Assert.assertEquals(true,headerinfo.contains(orgName)); 
				
				}

	
@Test(groups="regressionTest")
			public  void GenericUtilityWithIndustries() throws IOException, InterruptedException {
				String data = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
		
		String Industry = eLib.getDataFromExcel("contact", 4, 3);
		String type = eLib.getDataFromExcel("contact", 4, 4);
		

driver.findElement(By.linkText("Organizations")).click();


driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

driver.findElement(By.name("accountname")).sendKeys(data);
WebElement wbsele = driver.findElement(By.name("industry"));
Select sel = new Select(wbsele);
sel.selectByVisibleText(Industry);
WebElement wbsele2 = driver.findElement(By.name("accounttype"));
Select sel2 = new Select(wbsele2);
sel2.selectByVisibleText(type);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();

//if(actIndustries.contains(Industry)) {
//	System.out.println(Industry + "information is created==PASS");
//} else {
//	System.out.println(Industry + "information is not created==FAIL");
	Assert.assertEquals(true,actIndustries.contains(Industry)); 
	
	String actType = driver.findElement(By.id("dtlview_Type")).getText();	

//if(actType.contains(type)) {
//	System.out.println(type + "information is created==PASS");
//} else {
//	System.out.println(type + "information is not created==FAIL");
	Assert.assertEquals(true,actType.contains(type)); 

}

@Test(groups="regressionTest")
public  void GenericUtilityWithPhoneNumber() throws IOException, InterruptedException {
	String data = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
	String PhoneNumber = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
	
	
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
