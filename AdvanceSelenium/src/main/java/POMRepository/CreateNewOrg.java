package POMRepository;







import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class CreateNewOrg {
	WebDriver driver;
	public CreateNewOrg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
		@FindBy(name = "accountname")
		private WebElement orgNameEdt;
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		@FindBy(xpath = "industry")
		private WebElement industryDB;
		
		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}
		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		
		public void createOrg(String lastName, String pindustry) {
			orgNameEdt.sendKeys(lastName);
			Select sel= new Select(industryDB);
			sel.selectByVisibleText(pindustry);
			 saveBtn.click();
	}

}

	
		
		
		
		
	
		
			
				
				
				
			
				
				
				
			
