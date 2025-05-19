package POMRepository;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class PomClass1 {
	
	@FindBy(name="user_name")
	WebElement ele1;
	
	@FindBy(name="user_password")
	WebElement ele2;
	
	@FindBys({@FindBy(id="submitButton."), @FindBy(xpath="//input[@type='submit']")})
	private WebElement ele3;
	
	
	@Test
     public void sampleTest() {
    	 WebDriver driver = new ChromeDriver();
    	 driver.get("http://localhost:8888");
    	 PomClass1  pc = 	PageFactory.initElements(driver, PomClass1.class);
    	
    	 pc.ele1.sendKeys("admin");
    	 pc.ele2.sendKeys("admin");
    	
    	 pc.ele3.click();
    	 
     }
}
