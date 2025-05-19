package POMRepository;

import org.openqa.selenium.By;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
public class OrgInfoPage {

	WebDriver driver;
	public OrgInfoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		this.driver = driver;
	 PageFactory.initElements(driver, this);
}
	

	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(name="lastname")
	private WebElement contacttextfield;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//img[@title='Create Contact...']")
    private WebElement CreateContact;

	


	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLink;
	
	
	
	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public void setOrgLink(WebElement orgLink) {
		this.orgLink = orgLink;
	}

	public void setContactLink(WebElement contactLink) {
		this.contactLink = contactLink;
	}

	public void navigateCampaignLink() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
		
		
	}
	public void LogOut() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		SignOutLink.click();
	}


	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
 
	public WebElement getCreateContact() {
		return CreateContact;
	}
	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
		
	}
	public WebElement getContacttextfield() {
		return contacttextfield;
	}

	public void getContacttextfield(String lastName) {
		// TODO Auto-generated method stub
		contacttextfield.sendKeys(lastName);
		
	}
}
	
	
	
	
	
	
	
	
	

	
