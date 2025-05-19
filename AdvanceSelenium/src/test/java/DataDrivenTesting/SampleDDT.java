package DataDrivenTesting;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.Properties;

public class SampleDDT {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\New Text Document.txt");
		
		
		Properties pObj = new Properties();
		pObj.load(fis);
		
		System.out.println(pObj.getProperty("url"));
		
		
	}
	
	
}
