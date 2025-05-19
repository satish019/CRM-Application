package VerificationTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
@Test
public class SampleReportTest {

	ExtentReports report;
	@BeforeSuite
	
	public void ConfigBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	@AfterSuite
	public void ConfigAS() {
		report.flush();
		
	}
	@Test
	public void CreateContactTest(){
		
			WebDriver driver = new ChromeDriver();
			
			  driver.get("http://localhost:8888");
			
			 TakesScreenshot eDriver = (TakesScreenshot) driver;
			  String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
			
			 
		
		ExtentTest test = report.createTest("CreateContactTest");
		test.log(Status.INFO, "Login To App");
		test.log(Status.INFO,"Navigate to contact Page");
		test.log(Status.INFO,"Create Contact");
		
			if("Satish".equals("Satish")) {
				test.log(Status.PASS,"contact is created");
			} else {
				test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
			}
			
			report.flush();
	
	}
		@Test
	public void HomePageVT() {
		
		ExtentTest test = report.createTest("HomePageTest");
		test.log(Status.INFO, "Login To App");
		test.log(Status.INFO,"Navigate to Home Page");
		test.log(Status.INFO,"Verify Home Name");
		
			if("Home".equals("Home")) {
				test.log(Status.PASS,"contact is created");
			} else {
				test.log(Status.FAIL,"contact is not created");
			}
			
			report.flush();
			
	}
	



@Test
public void  VerifyLogoHomePage() {
	
	ExtentTest test = report.createTest("VerifyLogoHomePage");
	test.log(Status.INFO, "Login To App");
	test.log(Status.INFO,"Navigate to Logo Home Page");
	test.log(Status.INFO,"Verify Logo Home Name");
	
		if("vtiger-crm-logo.gif".equals("vtiger-crm-logo.gif")) {
			test.log(Status.PASS,"contact is created");
		} else {
			test.log(Status.FAIL,"contact is not created");
		}
		
		report.flush();
		
}


}



