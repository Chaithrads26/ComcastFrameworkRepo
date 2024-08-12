package com.camcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con;//closing of this method will be happening in the other 
	                //method so declare as a global variable
	public void getDbconnection(String url,String username,String password)throws SQLException
	{
		try {

		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		Connection con=DriverManager.getConnection(url,username,password);	
	}
		catch(Exception e)
		{
			
		}
}
	public void getDbconnection()throws SQLException
	{
		try {

		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");	
	}
		catch(Exception e)
		{
			
		}
}
	public void closeDbconnection() throws SQLException
	{
		try {
		con.close(); 
		}
		catch(Exception e)
		{
			
		}
	}
	public ResultSet exccuteConSelectQuery()
	{
		ResultSet result=null;
		try {
		Statement stat = con.createStatement();
		 String query = null;
		result = stat.executeQuery(query);	
	}
		catch(Exception e)
		{
			
		}
return result;
}
	public int excuteNonselectQuery(String query)
	{
		int result=0;
		try {
		Statement stat = con.createStatement(); 
		result = stat.executeUpdate(query);	
	}
		catch(Exception e)
		{
			
		}
return result;
	}
}
