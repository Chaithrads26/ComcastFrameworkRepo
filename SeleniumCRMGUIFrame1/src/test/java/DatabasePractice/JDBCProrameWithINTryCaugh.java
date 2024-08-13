package DatabasePractice;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.mysql.jdbc.Driver;

		public class JDBCProrameWithINTryCaugh 
		{
		Connection conn=null;
		//unit testing to test the back end
		//program to check whether expected value is available in databa
		
		@Test
		public void projectTestTest() throws SQLException 
		{
           try 
           {
			String PersonID = "1";//if u giver PersonId not present in the table result will fail
			boolean flag = false;
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			Statement state = conn.createStatement();
			ResultSet resultSet = state.executeQuery("select * from Persons");
			while (resultSet.next())
			{
				String actualPersonID = resultSet.getString(1);
				if (PersonID.equals(actualPersonID)) 
				{
					flag = true;
					System.out.println(PersonID+ "is available = Pass");
				}
			}
			if (flag == false) {
				System.out.println(PersonID + "is not available = Fail");
				Assert.fail();
			}
           }
           catch(Exception e)
           {
        	   System.out.println("handled exception");
           }
           finally
           {
        	   conn.close();
           }
		}
	}


