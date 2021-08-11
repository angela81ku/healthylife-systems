package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseADMModel {

	public static ObservableList<String> getUserName(){
		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
		Connection connectDB = connectNow.getConnection();
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

}
