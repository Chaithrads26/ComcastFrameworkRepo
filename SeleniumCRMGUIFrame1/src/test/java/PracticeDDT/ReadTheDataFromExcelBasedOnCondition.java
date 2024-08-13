 package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcelBasedOnCondition 
{

		//test case id is available if there read the complete data
		//reading first column data compare with expected test case id if it is 
		//available ill break my loop and read the whole row data
		public static void main(String[] args) throws EncryptedDocumentException, IOException
		{
			
		String expectedTestid="tc_02";
		String data1="";
		String data2="";
		String data3="";
			FileInputStream fis=new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumCRMGUIFrame1\\src\\test\\resources\\testscriptdata3.xlsx");
			
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh= wb.getSheet("org");
			
			int rowCount=sh.getLastRowNum();
			
			boolean flag=false;
			for (int i=0;i<=rowCount;i++)
			{
				String data="";
				try {
			 data = sh.getRow(i).getCell(0).toString();
			 if(data.equals(expectedTestid))
					 {
				 flag=true;
				 data1 = sh.getRow(i).getCell(1).toString();
				 data2= sh.getRow(i).getCell(2).toString();
				 data3 = sh.getRow(i).getCell(3).toString();
					 }
				}
				
				catch(Exception e)
				{
				
				}
			}
			if(flag==true)
			{
				System.out.println(data1);
				System.out.println(data2);
				System.out.println(data3);
				
			}
			else
			{
				System.out.println("tc_100 not available");
			}
			
			
			
			wb.close();
		}	
}
