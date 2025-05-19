package POMRepository;

import org.openqa.selenium.By;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		this.driver = driver;
	 PageFactory.initElements(driver, this);
}
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	
	
	@FindBy(name="accountname")
    private WebElement accountname;
	
	public WebElement getProductLink() {
		return productLink;
	}
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	
	

	

	

	

	

	

	public WebElement getAccountname() {
		return accountname;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	

	


public void CreateAOrg(String orgName) {
	
	
	accountname.sendKeys(orgName);
	SaveBtn.click();

}

}