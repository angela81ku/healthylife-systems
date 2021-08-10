package login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHouseChoresModel {

	public static ObservableList<HouseChoresPointTableCol> getHouseChoresPointTable(){
		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
		Connection connectDB = connectNow.getConnection();
		ObservableList<HouseChoresPointTableCol> list = FXCollections.observableArrayList();
		try {
			PreparedStatement preparedStatement = connectDB.prepareStatement(
					"select * from housechores_table ORDER BY houseChoresID");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				list.add(new HouseChoresPointTableCol(
						resultSet.getInt("houseChoresID"),
						resultSet.getString("houseChoresName"),
						resultSet.getInt("point")
				));
			}
		}catch(Exception e){
		}
		return list;
	}

	/**
	 * get the full house chores record table
	 * @return the full house chores record table using the list containing HouseChoresRecordTableCol object
	 */
	public static ObservableList<HouseChoresRecordTableCol> getHouseChoresRecordTable(){
		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
		Connection connectDB = connectNow.getConnection();
		ObservableList<HouseChoresRecordTableCol> list = FXCollections.observableArrayList();
		try {
			PreparedStatement preparedStatement = connectDB.prepareStatement(
					"select * from record_table ");
			ResultSet resultSet = preparedStatement.executeQuery();
//String userName, String houseChoresName, Date date
			while (resultSet.next()){
				list.add(new HouseChoresRecordTableCol(
						resultSet.getString("username"),
						resultSet.getString("houseChoresName"),
						resultSet.getDate("date"),
						resultSet.getInt("record_id")
				));
			}
		}catch(Exception e){
		}

		return list;
	}
	/**
	 * get the house chores name list
	 * @return the house chores name list
	 */
	public static ObservableList<String> getHouseChoresName(){
		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
		Connection connectDB = connectNow.getConnection();
		ObservableList<String> list = FXCollections.observableArrayList();
		try {
			PreparedStatement preparedStatement = connectDB.prepareStatement(
					"select houseChoresName from housechores_table  ");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				list.add(
						resultSet.getString("houseChoresName"));
			}
		}catch(Exception e){
		}


		return list;
	}

}
