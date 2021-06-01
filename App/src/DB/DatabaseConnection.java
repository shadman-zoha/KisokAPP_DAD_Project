package DB;

import java.sql.*;

public class DatabaseConnection {
		
	private String databaseName = "kioskappdb_dev";
	private String username = "root";
	private String password = "";
	Connection connection = null;
	
	public DatabaseConnection() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ databaseName, username, password);// the username and password for mysql


		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	PreparedStatement prepareStatement(String query) throws SQLException {
		return connection.prepareStatement(query);
	}
	
		
}