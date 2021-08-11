package model;

import java.sql.*;

public class DatabaseConnectionModel {
	public Connection databaseLink;


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
