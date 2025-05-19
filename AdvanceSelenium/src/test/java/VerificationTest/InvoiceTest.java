package VerificationTest;

import org.openqa.selenium.WebDriver;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNG.BaseClass;
import VerificationTest.HomePageVT;

//@Listeners(FileUtility.ListenerUtility.class)
public class InvoiceTest extends BaseClass{

	@Test
	public void HomePageTest() {
		System.out.println("execute createInvoiceTest");
		
		String actTitle = driver.getTitle();
		
		Assert.assertEquals(actTitle, "");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	@Test
	public void VerifyLogoHomePage() {
		System.out.println("createInvoicewithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
}
