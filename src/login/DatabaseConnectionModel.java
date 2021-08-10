package login;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

//	public static ObservableList<HouseChoresPointTableCol> getHouseChoresPointTable(){
//		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
//		Connection connectDB = connectNow.getConnection();
//		ObservableList<HouseChoresPointTableCol> list = FXCollections.observableArrayList();
//		try {
//			PreparedStatement preparedStatement = connectDB.prepareStatement(
//					"select * from housechores_table ORDER BY houseChoresID");
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()){
//				list.add(new HouseChoresPointTableCol(
//						resultSet.getInt("houseChoresID"),
//						resultSet.getString("houseChoresName"),
//						resultSet.getInt("point")
//						));
//			}
//		}catch(Exception e){
//		}
//		return list;
//	}
//
//	public static ObservableList<HouseChoresRecordTableCol> getHouseChoresRecordTable(){
//		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
//		Connection connectDB = connectNow.getConnection();
//		ObservableList<HouseChoresRecordTableCol> list = FXCollections.observableArrayList();
//		try {
//			PreparedStatement preparedStatement = connectDB.prepareStatement(
//					"select * from record_table ");
//			ResultSet resultSet = preparedStatement.executeQuery();
////String userName, String houseChoresName, Date date
//			while (resultSet.next()){
//				list.add(new HouseChoresRecordTableCol(
//						resultSet.getString("username"),
//						resultSet.getString("houseChoresName"),
//						resultSet.getDate("date")
//				));
//			}
//		}catch(Exception e){
//		}
//		System.out.println("list" + list);
//
//		return list;
//	}
}
