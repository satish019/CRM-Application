package TestNG;

import org.testng.annotations.Test;
public class OrderTest {
 @Test
 public void createOrderTest() {
	 
	 
	 System.out.println("execute createOrdertest==>123");
	 
 }
 @Test(dependsOnMethods = "createOrderTest")
 public void modifyOrderTest() {
	 
	 
	 System.out.println("execute billingAnOrdertest==>123");
}
 
 @Test(dependsOnMethods = "modifyOrderTest")
 public void billingAnOrderTest() {
	 
	 
	 System.out.println("execute billingAnOrdertest==>123");
}
}