package model;

import java.sql.*;

/**
 * This class is to connect the database
 */
public class DatabaseConnectionModel {
	private Connection databaseLink;

	public Connection getConnection(){
		String databaseName = "demo_db";
		String databaseUser = "root";
		String databasePassWord = "8MySQL@!7";
		String url = "jdbc:mysql://localhost/" + databaseName;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url,databaseUser,databasePassWord);

		}catch(Exception e){
			e.printStackTrace();
			e.getCause();
		}
		return databaseLink;
	}

}
