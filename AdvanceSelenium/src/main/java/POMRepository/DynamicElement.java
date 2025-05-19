package POMRepository;

	import java.io.IOException;
    import java.time.Duration;
	import java.util.Random;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	

import FileUtility.ExcelUtility;
import FileUtility.FileUtility;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.WebDriverUtility;

	public class DynamicElement {

		public static void main(String[] args) throws IOException, InterruptedException {
			
			FileUtility fLib = new FileUtility();
			ExcelUtility eLib = new ExcelUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			
			String BROWSER =fLib.getDataFromPropertiesFile("browser");
			String URL = fLib.getDataFromPropertiesFile("url");
			String USERNAME = fLib.getDataFromPropertiesFile("username");
			String PASSWORD = fLib.getDataFromPropertiesFile("password");
			
			Random random = new Random();
			int randomInt = random.nextInt(1000);
			
			String lastName = eLib.getDataFromExcel("contact", 1, 2) + randomInt;
				
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
				
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					driver.get(URL);
					
						Login l = new Login(driver);
						l.loginToapp("http://localhost:8888","admin", "admin");
			
						OrgInfoPage oip = new OrgInfoPage(driver);
						oip.getOrgLink().click(); 
						
						OrgPage op = new OrgPage(driver);
						op.getCreateNewOrgBtn().click();
					
						HomePage hp = new HomePage(driver);
						hp.CreateAOrg(lastName);
						
						OrganizationInfoPage Oip = new OrganizationInfoPage(driver);
						String actOrgName = Oip.getHeaderMsg().getText();
						
						if(actOrgName.contains(lastName)) {
							System.out.println(lastName + " name is verified ==PASS");
						}else {
							System.out.println(lastName + " name is not verified ==FAIL");
						}
						
						oip.getOrgLink().click(); 
						op.getSearchEdt().sendKeys(lastName);
						wLib.select(op.getSearchfld(), "Organization Name");
						op.getSearchbtn().click();
						driver.findElement(By.xpath("//a[text()='"+lastName+"']/../../td[8]/a[text()='del']")).click();
						oip.LogOut();
						driver.quit();
					}
		
		
		
		
		
		
					}
	
	

