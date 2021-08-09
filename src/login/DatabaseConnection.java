package login;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnection {
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

	public static ObservableList<HouseChoresPoint> getPointTable(){
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		ObservableList<HouseChoresPoint> list = FXCollections.observableArrayList();
		try {
			PreparedStatement preparedStatement = connectDB.prepareStatement("select * from point_list");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				list.add(new HouseChoresPoint(
						resultSet.getInt("houseChoresIDColumn"),
						resultSet.getString("houseChoresNameColumn"),
						resultSet.getInt("pointColumn")
						));
			}
		}catch(Exception e){
		}
		return list;
	}
}
