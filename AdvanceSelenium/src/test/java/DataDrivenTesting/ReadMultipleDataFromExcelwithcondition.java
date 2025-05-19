package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelwithcondition {
 
     public static void main(String[] args) throws Throwable {
    	 String Data = null;
    	String expectedTestId ="tc_02" ;
    	
    	String Data1 = "";
    	String Data2 = "";
    	String Data3 = "";
    	
	FileInputStream fis = new FileInputStream("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\ReadDataFromExcelTest.xlsx");
	
	//Create the work book where the test data is stored
	Workbook workbook = WorkbookFactory.create(fis);
	
	//Access the sheet where the data is present for you to work on
	Sheet sheet = workbook.getSheet("Sheet1");
	

	//To take the rows that have been used in excel file
	int rowcount = sheet.getLastRowNum();
	boolean flag = false;
	for(int i = 0; i <=rowcount;i++) {
		String data = "";
	try {

	 Data = sheet.getRow(i).getCell(0).toString();
	 if(Data.equals(expectedTestId)) {
	  flag = true;
		Data1 = sheet.getRow(i).getCell(1).toString();
		Data2 = sheet.getRow(i).getCell(2).toString();
		Data3 = sheet.getRow(i).getCell(3).toString();
		 
	 }
	 } catch (Exception e) {}
		
	}
	
	if(flag == true) {
		
	
		System.out.println(Data1);
		System.out.println(Data2);
		System.out.println(Data3);
		
	} else {
		
		System.out.println(expectedTestId + " data is not available");
	}
	
	
	
	
	workbook.close();
}
}