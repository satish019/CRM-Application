
	package VerificationTest;





	import org.testng.Assert;
import org.testng.annotations.Test;

import TestNG.BaseClass;
	

	
	public class InvoiceTest1 extends BaseClass
 {

		@Test(retryAnalyzer = FileUtility.RetryListener.class)
		public void HomePageTest() {
			System.out.println("execute createInvoiceTest");
			
			
			
			Assert.assertEquals("", "");
			System.out.println("step-1");
			System.out.println("step-2");
			System.out.println("step-3");
			System.out.println("step-4");
		}
}
