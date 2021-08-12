package model;

import controller.HouseChoresMainController;
import controller.LoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseADMModel {
	static DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
	static Connection connectDB = connectNow.getConnection();

	public static ObservableList<String> getUserName(){

		ObservableList<String> list = FXCollections.observableArrayList();
		try {
			PreparedStatement preparedStatement = connectDB.prepareStatement(
					"select username from user_account  ");
			ResultSet resultSet = preparedStatement.executeQuery();
//String userName, String houseChoresName, Date date
			while (resultSet.next()){
				list.add(
						resultSet.getString("username"));
			}
		}catch(Exception e){
		}
		return list;
	}

	/**
	 * check if the user is the adm
	 * @return true is the user is the adm
	 */
	public static Boolean checkAuthority(){

		List<String> list = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connectDB.prepareStatement(
					"select username from user_account where authority = ?;");
			preparedStatement.setString(1,"adm");
			ResultSet resultSet = preparedStatement.executeQuery();
//String userName, String houseChoresName, Date date
			while (resultSet.next()){
				list.add(
						resultSet.getString("username"));
			}
		}catch(Exception e){
		}
		return (list.contains(LoginController.getUserName()));
	}
}
