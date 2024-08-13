package PracticeDDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadTheDataBackToExcel
{

public static void main(String[] args) throws IOException 
{
		FileInputStream fis=new FileInputStream("./src/test/resources/testscriptdata3.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("org");
		 Row row = sh.getRow(1);
		 Cell cel = row.getCell(4);
		 cel.setCellType(CellType.STRING);
		 cel.setCellValue("FAIL");
	//to save the excel open in write mode
		 FileOutputStream fos=new FileOutputStream("./src/test/resources/testscriptdata3.xlsx");
		  wb.write(fos);
          wb.close();
		 System.out.println("-------excuted------");      
	}
	}


