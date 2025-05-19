package POMRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {

	@FindBy(xpath="//input[@alt='Create Product...']")
	private WebElement createProductImgBtn;
	
	@FindBy(xpath="search")
	private WebElement ele;
	@FindBy(xpath="searchBtn")
	private WebElement ele1;
}
