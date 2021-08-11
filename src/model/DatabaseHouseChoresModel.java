package model;

import controller.HouseChoresLeaderTableCol;
import controller.HouseChoresPointTableCol;
import controller.HouseChoresRecordTableCol;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class DatabaseHouseChoresModel {
	private static DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
	private static Connection connectDB = connectNow.getConnection();

	public static ObservableList<HouseChoresPointTableCol> getHouseChoresPointTable(){
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
		ObservableList<HouseChoresRecordTableCol> list = FXCollections.observableArrayList();
		try {
			PreparedStatement preparedStatement = connectDB.prepareStatement(
					"SELECT username, houseChoresName, date,record_id  FROM demo_db.record_table \n" +
							"join housechores_table on record_table.houseChoresID = housechores_table.houseChoresID\n" +
							"ORDER BY date");
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

	public static int houseChoresNameToID(String name){
		String sql = "SELECT housechores_table.houseChoresID From housechores_table WHERE houseChoresName = ?;";
		int id = -1;
		try{
		PreparedStatement preparedStatement = connectDB.prepareStatement(sql);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				id = 	resultSet.getInt("houseChoresID");
			}
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return id;
	}

	public static void addHouseChoresRecordTable(String uerNameText, Integer houseChoresID, LocalDate dateText, Label houseChoresRegistryMessageLabel){

		try {

			String sql = "INSERT INTO record_table(username, houseChoresID, date) VALUES(?,?,?)";
			PreparedStatement preparedStatement = connectDB.prepareStatement(sql);
			preparedStatement.setString(1, uerNameText);
			preparedStatement.setInt(2, houseChoresID);
			preparedStatement.setDate(3, Date.valueOf(dateText));

			preparedStatement.executeUpdate();
			houseChoresRegistryMessageLabel.setText("Record successfully!");
		} catch (SQLIntegrityConstraintViolationException duplicate) {
			houseChoresRegistryMessageLabel.setText("formation incorrect\n");
		} catch (NumberFormatException numberFormatException) {
			houseChoresRegistryMessageLabel.setText("formation incorrect\n");
		}catch (NullPointerException e) {
			houseChoresRegistryMessageLabel.setText("Please fill in all the field\n");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static void updateHouseChoresRecordTable(Integer houseChoresID, String userName, LocalDate date, int record_id, Label houseChoresRegistryMessageLabel){
		try {
			String sql = "UPDATE record_table SET houseChoresID = ?, username = ?, date = ? WHERE record_id = ?";
			PreparedStatement statement = connectDB.prepareStatement(sql);
			statement.setString(2, userName);
			statement.setInt(1, houseChoresID);
			statement.setDate(3, Date.valueOf(date));
			statement.setInt(4, record_id);
			statement.execute();
			houseChoresRegistryMessageLabel.setText("Update successfully");
		}catch(DataTruncation dataTruncation){
			houseChoresRegistryMessageLabel.setText("name too long");
		}catch (NumberFormatException numberFormatException) {
			houseChoresRegistryMessageLabel.setText("formation incorrect\n");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}



	/**
	 * get the house chores name list
	 * @return the house chores name list
	 */
	public static ObservableList<String> getHouseChoresName(){
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

	public static ObservableList<HouseChoresLeaderTableCol> getWinnerTableList(Date startDate, Date endDate, String userName){
		ObservableList<HouseChoresLeaderTableCol> list = FXCollections.observableArrayList();
		try {
			PreparedStatement preparedStatement = connectDB.prepareStatement(
					"SELECT record_table.username, record_table.date, houseChoresName, \n" +
							"housechores_table.point\n" +
							"FROM demo_db.record_table " +
							"join housechores_table on record_table.houseChoresID = housechores_table.houseChoresID\n" +
							"WHERE username = ?\n" +
							"AND date between ? and ?\n" +
							"ORDER BY date;");
			preparedStatement.setString(1, userName);
			preparedStatement.setDate(2, startDate);
			preparedStatement.setDate(3, endDate);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				list.add(new HouseChoresLeaderTableCol(resultSet.getString("username"),
						resultSet.getDate("date"),
						resultSet.getString("houseChoresName"),
						resultSet.getInt("point")));
			}
		}catch(Exception e){
			e.printStackTrace();
			e.getCause();
		}
		return list;
	}

	public static ObservableList<XYChart.Data<String, Integer>> getWinnerChartBar(Date startDate, Date endDate){
		ObservableList<XYChart.Data<String, Integer>> list = FXCollections.observableArrayList();
		try {
			PreparedStatement preparedStatement = connectDB.prepareStatement(
					"SELECT record_table.username, SUM(housechores_table.point)\n" +
							"FROM demo_db.record_table " +
							"join housechores_table on record_table.houseChoresID = housechores_table.houseChoresID\n" +
							"WHERE date between ? and ?\n" +
							"GROUP BY record_table.username\n" +
							"ORDER BY point DESC;");
			preparedStatement.setDate(1, startDate);
			preparedStatement.setDate(2, endDate);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				list.add(new XYChart.Data(resultSet.getString("username"),
						resultSet.getInt("SUM(housechores_table.point)")));
			}
		}catch(Exception e){
			e.printStackTrace();
			e.getCause();
		}
		return list;
	}

}
