package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
   
	WebDriver driver;
	public OrgPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchfld;
	
	@FindBy(name = "submit")
	private WebElement searchbtn;

	

	
	

	@FindBy(xpath = "//img[@alt='Create Organization...']")
		private WebElement createNewOrgBtn;

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchfld() {
		return searchfld;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
}
