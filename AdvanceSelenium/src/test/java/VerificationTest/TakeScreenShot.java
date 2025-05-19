package VerificationTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
public class TakeScreenShot {
@Test
public void amazonTest() throws IOException {
	WebDriver driver = new ChromeDriver();
	
	  driver.get("https://www.amazon.in/");
	 WebElement ele= driver.findElement(By.xpath("//a[@class='nav-a']"));
	 EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
	  File sourceFile = edriver.getScreenshotAs(OutputType.FILE);
	
	  File destinationFile= new File("./ScreenShots/test.png");
	  
	  try {
		  
	  
	 FileUtils.copyFile(sourceFile, destinationFile);
	 
} catch (IOException e) {
	e.printStackTrace();
}}
	
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
}	
		public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	System.out.println("Report ");
}


public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	System.out.println("Report ");
}
}

