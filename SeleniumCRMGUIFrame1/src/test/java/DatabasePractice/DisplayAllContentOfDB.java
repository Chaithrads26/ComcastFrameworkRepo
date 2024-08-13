package DatabasePractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DisplayAllContentOfDB 
{
	public static void main(String[] args) throws SQLException 
	{
		
	//step1:register driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
	//step2:Connection for database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("------done------");
		
	//step3:create sql statement
		Statement stat = conn.createStatement();
		
	//step4:execute query and get result
		ResultSet resset = stat.executeQuery("SELECT* FROM Persons");
		while(resset.next())
		{
			//first column data
			//System.out.println(resset.getInt(1));
			//for all column data
			System.out.println(resset.getInt(1)+"/t"+resset.getString(2)+"/t"+resset.getString(3)+"/t"
			+resset.getString(4)+"/t"+resset.getString(5)+"/t");
		}
		
	//step5:close the connection
		conn.close();
		
	}
	}



	
	


