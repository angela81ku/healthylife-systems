package login;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public static ObservableList<HouseChoresPoint> getHouseChoresPointTable(){
		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
		Connection connectDB = connectNow.getConnection();
		ObservableList<HouseChoresPoint> list = FXCollections.observableArrayList();
		try {
			PreparedStatement preparedStatement = connectDB.prepareStatement(
					"select * from housechores_table ORDER BY houseChoresID");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				list.add(new HouseChoresPoint(
						resultSet.getInt("houseChoresID"),
						resultSet.getString("houseChoresName"),
						resultSet.getInt("point")
						));
			}
		}catch(Exception e){
		}
		return list;
	}
}
