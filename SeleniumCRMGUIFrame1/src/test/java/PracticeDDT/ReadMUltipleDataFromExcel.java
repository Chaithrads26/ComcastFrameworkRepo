package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMUltipleDataFromExcel
{
		public static void main(String[] args) throws EncryptedDocumentException, IOException
		{
			//get the excel path location & java object of physical excel
			FileInputStream fis=new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumCRMGUIFrame1\\src\\test\\resources\\testscriptdata2.xlsx");
			//open workbook in read mode
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh= wb.getSheet("sheet1");
			
			Row row=sh.getRow(1);
        int rowCount=sh.getLastRowNum();
			
			
			for (int i=0;i<=rowCount;i++)
			{
			
			String column1data = row.getCell(0).toString();
			String column2data = row.getCell(1).toString();
			
			System.out.println(column1data +"/t" + column2data  );
			}
			wb.close();
	}

}
