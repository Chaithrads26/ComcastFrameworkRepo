package DatabasePractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBwithGUI {

	public static void main(String[] args) throws SQLException
	{
		//Create project in GUI using selenium code
		String projectName="instagram_02";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("http://106.51.90.215:8084");
		
		driver.findElement(By.id("username")).sendKeys("testyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("projectName");
		driver.findElement(By.name("createdBy")).sendKeys("ram");
		Select sel=new Select(driver.findElement(By.name("status")));
		sel.selectByIndex(0);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		//Verify the project in DB using jdbc
		boolean flag=false;
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);

		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		Statement state = conn.createStatement();
		ResultSet resultSet = state.executeQuery("select * from project");
		//int result=state.excuteUpdate("insert into Persons values("","","","","";)");
		while (resultSet.next())
		{
			String actualPersonID = resultSet.getString(1);
			if (projectName.equals(actualPersonID)) 
			{
				flag = true;
				System.out.println(projectName+ "is available = Pass");
			}
		}
		if (flag == false) {
			System.out.println(projectName + "is not available = Fail");
			//Assert.fail();
		}
	}
	}


