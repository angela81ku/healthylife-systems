package login;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HouseChoresSubLeaderController implements Initializable {

	private DatabaseConnectionModel connectNow = new DatabaseConnectionModel();

	private Connection connectDB = connectNow.getConnection();

	private ObservableList<XYChart.Data<String, Integer>> listBarChart;

//	String userName,  Date date, String houseChoresName,int point

	private ObservableList<HouseChoresLeaderTableCol> userDetailList;

	@FXML
	private TableView<HouseChoresLeaderTableCol> userDetailTable;

	@FXML
	private TableColumn<HouseChoresLeaderTableCol, String> colUsername;

	@FXML
	private TableColumn<HouseChoresLeaderTableCol, Date> colDate;

	@FXML
	private TableColumn<HouseChoresLeaderTableCol, String> colChoreName;

	@FXML
	private TableColumn<HouseChoresLeaderTableCol, Integer> colPoint;

	@FXML
	private Button winnerCalculateButton;

	@FXML
	private Label houseChoresRegistryMessageLabel;

	@FXML
	private ComboBox<String> userNameComboBox;

	@FXML
	private DatePicker startDatepicker;

	@FXML
	private DatePicker endDatepicker;

	@FXML
	private BarChart<String, Integer> barChart;

	//this is to set up the index when clicking the selecting row in the table
	private int index = -1;
//	Connection connection = null;
//	ResultSet resultSet = null;
//	PreparedStatement preparedStatement = null;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		//the PropertyValueFactory takess the variable name of the HouseChoresLeaderTableCol.

		colUsername.setCellValueFactory(new PropertyValueFactory<HouseChoresLeaderTableCol, String>("userName"));
		colChoreName.setCellValueFactory(new PropertyValueFactory<HouseChoresLeaderTableCol, String>("houseChoresName"));
		colDate.setCellValueFactory(new PropertyValueFactory<HouseChoresLeaderTableCol, Date>("date"));
		colPoint.setCellValueFactory(new PropertyValueFactory<HouseChoresLeaderTableCol, Integer>("point"));
//		updateHouseChoresTable();
		// fill the combo box
		LocalDate endDate = LocalDate.now();
		LocalDate startDate = endDate.withDayOfMonth(1);

		startDatepicker.setValue(startDate);
		endDatepicker.setValue(endDate);
		winnerCalculate(Date.valueOf(startDate),Date.valueOf(endDate));
		fillUserNameComboBox();
	}
//
//	private void updateHouseChoresTable() {
//		listM = DatabaseHouseChoresModel.getHouseChoresRecordTable();
//		recordTable.setItems(listM);
//	}

	/**
	 * fill the userNameComboBox with all username
	 */
	public void fillUserNameComboBox(){
		userNameComboBox.getItems().setAll(DatabaseADMModel.getUserName());
	}


	/**
	 * when click the add button, this will initiate addHouseChores function
	 * @param event action event.
	 */
	public void winnerCalculateButtonOnAction(ActionEvent event) {
		winnerCalculate(Date.valueOf(startDatepicker.getValue()),Date.valueOf(endDatepicker.getValue()));

	}
	private void winnerCalculate(Date startDate, Date endDate) {
		listBarChart = DatabaseHouseChoresModel.getWinnerChartBar(startDate,endDate);
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
		Integer userNumber = listBarChart.size();

		series.getData().addAll(listBarChart);
		barChart.getData().clear();
		barChart.setCategoryGap(userNumber);
		barChart.setTitle("Leader Board");
		barChart.getData().add(series);
	}

	public void updateHouseChoresTableOnAction(ActionEvent e) {
		userDetailList = DatabaseHouseChoresModel.getWinnerTableList(Date.valueOf(startDatepicker.getValue()),
				Date.valueOf(endDatepicker.getValue()),userNameComboBox.getValue());
		userDetailTable.setItems(userDetailList);
	}


}
