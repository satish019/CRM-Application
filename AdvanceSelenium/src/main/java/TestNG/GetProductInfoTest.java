package TestNG;

import org.testng.annotations.Test;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import FileUtility.ExcelUtility;
public class GetProductInfoTest {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		String price = "//span[text()='"+productName+"']";
		String cost = driver.findElement(By.xpath(price)).getText();
		System.out.println(cost);
		driver.quit();
	}
	@org.testng.annotations.DataProvider
	public Object[][] getData()throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowCount("Products");
		Object[][] objArr = new Object [rowCount][2];
		for(int i=0; i<rowCount ; i++)
		{
		objArr[i][0] = eLib.getDataFromExcel("Products", i+1, 0);
		
	
		
		objArr[i][1] = eLib.getDataFromExcel("Products", i+1, 1);
	
		
		
		}
		
			return objArr;
		}
	
}
