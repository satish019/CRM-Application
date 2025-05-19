package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcel {
   public static void main(String[] args) throws Throwable, IOException {
	   FileInputStream fis = new FileInputStream("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\ReadDataFromExcelTest.xlsx");
	   Workbook wb = WorkbookFactory.create(fis);
	   Sheet sh = wb.getSheet("Sheet1");
	   Row row = sh.getRow(1);
	   Cell cel =  row.createCell(4);
	   cel.setCellType(CellType.STRING);
	   cel.setCellValue("PASS");
	   
	   FileOutputStream fos = new FileOutputStream("C:\\Users\\B Satish\\eclipse-workspace\\AdvanceSelenium\\DataDrivenTesting\\ReadDataFromExcelTest.xlsx");
	   wb.write(fos);
	   wb.close();
	   System.err.println("====Executed====");
   }
}
