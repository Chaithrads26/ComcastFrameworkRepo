package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException
{
	//get the excel path location & java object of physical excel
	FileInputStream fis=new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumCRMGUIFrame1\\src\\test\\resources\\testscriptdata1.xlsx");
	//open workbook in read mode
	Workbook wb = WorkbookFactory.create(fis);
	
	Sheet sh= wb.getSheet("org");
	Row row=sh.getRow(1);
	//int 
	String data = row.getCell(3).toString();
	
	System.out.println(data);
	wb.close();
	
}


}
