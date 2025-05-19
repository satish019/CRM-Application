package POMRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriverUtility.WebDriverUtility;

import org.openqa.selenium.WebDriver;
public class Login {

	WebDriver driver;
	 WebDriverUtility wLib = new WebDriverUtility();

	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}


	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
		
		public void loginToapp(String url, String username, String password) {
		wLib.waitForPageToLoad(driver);
		driver.get(url);

		usernameEdt.sendKeys(username);	
		passwordEdt.sendKeys(password);
		loginBtn.click();	
		}

		
		
	}

