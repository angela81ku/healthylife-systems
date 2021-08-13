package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ChoresAndExerciseLeaderTableCol;
import model.DatabaseADMModel;
import model.DatabaseChoresAndExerciseModel;
import model.DatabaseConnectionModel;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * to control the ChoresAndExercise sub page "Leader"
 */
public class ChoresAndExerciseSubLeaderController implements Initializable {

	private DatabaseConnectionModel connectNow = new DatabaseConnectionModel();

	private Connection connectDB = connectNow.getConnection();

	private ObservableList<XYChart.Data<String, Integer>> listBarChart;

	private ObservableList<ChoresAndExerciseLeaderTableCol> userDetailList;

	@FXML
	private TableView<ChoresAndExerciseLeaderTableCol> userDetailTable;

	@FXML
	private TableColumn<ChoresAndExerciseLeaderTableCol, String> colUsername;

	@FXML
	private TableColumn<ChoresAndExerciseLeaderTableCol, Date> colDate;

	@FXML
	private TableColumn<ChoresAndExerciseLeaderTableCol, String> colChoreName;

	@FXML
	private TableColumn<ChoresAndExerciseLeaderTableCol, Integer> colPoint;

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

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		//the PropertyValueFactory takes the variable name of the ChoresAndExerciseLeaderTableCol.
		colUsername.setCellValueFactory(new PropertyValueFactory<ChoresAndExerciseLeaderTableCol, String>("userName"));
		colChoreName.setCellValueFactory(new PropertyValueFactory<ChoresAndExerciseLeaderTableCol, String>("eventName"));
		colDate.setCellValueFactory(new PropertyValueFactory<ChoresAndExerciseLeaderTableCol, Date>("date"));
		colPoint.setCellValueFactory(new PropertyValueFactory<ChoresAndExerciseLeaderTableCol, Integer>("point"));

		// fill the combo box with default value : start date : the 1st day of the current month; end date : now
		LocalDate endDate = LocalDate.now();
		LocalDate startDate = endDate.withDayOfMonth(1);
		startDatepicker.setValue(startDate);
		endDatepicker.setValue(endDate);

		// update the bar chart with the default date period
		winnerCalculate(Date.valueOf(startDate),Date.valueOf(endDate));
		fillUserNameComboBox();

		// set the user name to the log in user as default value
		userNameComboBox.setValue(LoginController.getUserName());
		updateHouseChoresTable();
	}

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

	/**
	 * set up the leader board bar chart with specified start date and end date
	 * @param startDate the start date of the specified period
	 * @param endDate the end date of the specified period
	 */
	private void winnerCalculate(Date startDate, Date endDate) {
		listBarChart = DatabaseChoresAndExerciseModel.getWinnerChartBar(startDate,endDate);
		XYChart.Series<String, Integer> series = new XYChart.Series<>();
		Integer userNumber = listBarChart.size();

		series.getData().addAll(listBarChart);
		barChart.getData().clear();
		barChart.setCategoryGap(userNumber);
		barChart.setTitle("Leader Board");
		barChart.getData().add(series);
	}

	/**
	 * update the houseChoresTable
	 * @param e the action event
	 */
	public void updateHouseChoresTableOnAction(ActionEvent e) {
		updateHouseChoresTable();

	}

	/**
	 * update the houseChoresTable by username specified in name combobox
	 */
	private void updateHouseChoresTable(){
		userDetailList = DatabaseChoresAndExerciseModel.getWinnerTableList(Date.valueOf(startDatepicker.getValue()),
				Date.valueOf(endDatepicker.getValue()),userNameComboBox.getValue());
		userDetailTable.setItems(userDetailList);
	}


}
