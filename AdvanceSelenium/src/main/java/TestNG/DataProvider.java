package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider.*;
public class DataProvider {

	@Test(dataProvider = "getData")
	public void CreateContactTest(String firstName, String lastName , long phonenumber){
		System.out.println("FirstName : " + firstName + ", LastName:" +lastName +" , phonenumber:" +phonenumber);
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][3];
		objArr[0][0] = "Satish";
		objArr[0][1] = "Bokka";
		objArr[0][2] = 8500680822l;
		objArr[1][0] = "deepak";
		objArr[1][1] = "hr";
		objArr[1][2] = 8331981209l;
		objArr[2][0] = "chinmayee";
		objArr[2][1] = "hr";
		objArr[2][2] = 9849891209l;
		
		
		
			return objArr;
		}
	}
	
	

