package DatabasePractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExcuteNonSelectQuery {
public static void main(String[] args) throws SQLException {
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	Statement state= conn.createStatement();
	int result = state.executeUpdate("insert into Persons values(6,'lm','Thomas','Italy','Rome');");
	System.out.println("Script execution successful");
	conn.close();
}
}
