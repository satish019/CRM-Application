package TestNG;

import org.testng.annotations.Test;

public class InvocationTest {

	@Test(invocationCount = 10)
	public void createOrderTest() {
		
	System.out.println("Execute createOrderTest ==> 123");
	
}
	@Test(enabled = true)
	public void billingAnOrderTest() {
	System.out.println("Execute billingAnOrderTest ==> 123");
}}