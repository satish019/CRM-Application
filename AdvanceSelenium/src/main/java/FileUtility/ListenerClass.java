package FileUtility;

import java.io.File;


import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestNG.BaseClass;
import WebDriverUtility.UtilityClassObject;

public class ListenerClass implements ITestListener, ISuiteListener {
	public static ExtentReports report;

	public static ExtentTest test;
	public void onStart(ISuite suite) {
		
		
		// TODO Auto-generated method stub
		System.out.println("Report Configuration");
		  String time = new Date().toString().replace("","_").replace(":","");
			
			 
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Report BackUp");
	
		report.flush();
		
		
	}
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=== ====>"+result.getMethod().getMethodName()+">===START====");
	 test = report.createTest(result.getMethod().getMethodName());
	 ExtentReports extent = null;
	ExtentTest test = extent.createTest("CreateOrganization");
	 UtilityClassObject.setTest(test);
	 test.log(Status.INFO, result.getMethod().getMethodName()+"===> STARTED <=====");
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("=== ====>"+result.getMethod().getMethodName()+">===END====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"===> COMPLETED <=====");
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		 TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		  String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
		  String time = new Date().toString().replace("","_").replace(":","");
		
		 test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);		  
		 test.log(Status.FAIL, result.getMethod().getMethodName()+"===> FAILED <=====");
	}

	
public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
}

	
public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
	
	
