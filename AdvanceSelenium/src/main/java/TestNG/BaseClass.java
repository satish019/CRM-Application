package TestNG;

import java.io.IOException;


import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.aventstack.extentreports.ExtentTest;
import DataBaseUtility.CreateDataBaseUtility;
import FileUtility.ExcelUtility;
import FileUtility.FileUtility;
import POMRepository.HomePage;
import POMRepository.Login;
import POMRepository.OrgInfoPage;
import WebDriverUtility.JavaUtility;
import WebDriverUtility.UtilityClassObject;
import WebDriverUtility.WebDriverUtility;

public class BaseClass {

	
	
	public CreateDataBaseUtility dLib = new CreateDataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public  WebDriver driver = null;
	public  static WebDriver sdriver = null;
	public ExtentSparkReporter spark;
	public ExtentReports report;
		@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	
		public void configBS() throws SQLException {
			System.out.println("====Connect to DB, Repoort config===");
			dLib.getDbconnection();
			ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
			spark.config().setDocumentTitle("CRM Test Suite Results");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			
			report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Windows-10");
			report.setSystemInfo("BROWSER", "CHROME-100");
		}
	
	//	@Parameters("BROWSER")
		
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
	public void configBC() throws IOException {
		System.out.println("===Launch a Browser====");
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
				//fLib.getDataFromPropertiesFile("browser");
	
		if(BROWSER.equals("chrome")) {
			driver  = new ChromeDriver();
			
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}
	
	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	
	public void configBM() throws IOException {
		System.out.println("====Login====");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		if(driver != null)
			try {
		
		Login lp = new Login(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	} catch(org.openqa.selenium.NoSuchSessionException e) {
		System.out.println("WebDriver session is already closed.");
	}
	}
	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	
	public void configAM() {
		System.out.println("====Logout====");
		if(driver != null)
		try {
		
		OrgInfoPage oip = new OrgInfoPage(driver);
		oip.LogOut();
		} catch(org.openqa.selenium.NoSuchSessionException e) {
			System.out.println("WebDriver session is already closed.");
		}
	}
	
	
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void configAC() {
		System.out.println("Close a Browser");
		if(driver != null)
		{
			System.out.println("Driver before quit:"
					+ ""+ driver);
		driver.quit();
	}}
	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	
	public void configAS() throws SQLException {
		System.out.println("====close DB, Report Backup====");
		dLib.closeDbconnection();
		
		
	
	}
	
	
	
	
	
}