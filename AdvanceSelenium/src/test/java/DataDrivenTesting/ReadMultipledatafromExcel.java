package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipledatafromExcel {
 
     public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\ReadMultipleDataFromExcel.xlsx");
	
	//Create the work book where the test data is stored
	Workbook workbook = WorkbookFactory.create(fis);
	
	//Access the sheet where the data is present for you to work on
	Sheet sheet = workbook.getSheet("Sheet2");
	

	//To take the rows that have been used in excel file
	int rowcount = sheet.getLastRowNum();
	for(int i = 1; i <=rowcount;i++) {
	Row row = sheet.getRow(i);

	String Column1Data = row.getCell(0).toString();
	String Column2Data = row.getCell(1).toString();

			System.out.print(Column1Data +"\t" + Column2Data);
		
	}
	workbook.close();
}
}


