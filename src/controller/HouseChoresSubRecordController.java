package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.DatabaseADMModel;
import model.DatabaseConnectionModel;
import model.DatabaseHouseChoresModel;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HouseChoresSubRecordController implements Initializable {

	private DatabaseConnectionModel connectNow = new DatabaseConnectionModel();

	private Connection connectDB = connectNow.getConnection();

	private ObservableList<HouseChoresRecordTableCol> listM;

	private int record_id;

	@FXML
	private TableView<HouseChoresRecordTableCol> recordTable;

	@FXML
	private TableColumn<HouseChoresRecordTableCol, String> colUserName;

	@FXML
	private TableColumn<HouseChoresRecordTableCol, String> colChoreName;

	@FXML
	private TableColumn<HouseChoresRecordTableCol, Date> colDate;


	@FXML
	private TableColumn<HouseChoresRecordTableCol, Integer> colRecordID;

	@FXML
	private Button addButton;

	@FXML
	private Button updateButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Label houseChoresRegistryMessageLabel;

	@FXML
	private ComboBox<String> choresNameComboBox;

	@FXML
	private ComboBox<String> userNameComboBox;

	@FXML
	private DatePicker datePicker;

	//this is to set up the index when clicking the selecting row in the table
	private int index = -1;
//	Connection connection = null;
//	ResultSet resultSet = null;
//	PreparedStatement preparedStatement = null;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		//the PropertyValueFactory tales the variable name of the HouseChoresRecordTableCol.
//		String userName, String houseChoresName, Date date
		colUserName.setCellValueFactory(new PropertyValueFactory<HouseChoresRecordTableCol, String>("userName"));
		colChoreName.setCellValueFactory(new PropertyValueFactory<HouseChoresRecordTableCol, String>("houseChoresName"));
		colDate.setCellValueFactory(new PropertyValueFactory<HouseChoresRecordTableCol, Date>("date"));
		colRecordID.setCellValueFactory(new PropertyValueFactory<HouseChoresRecordTableCol, Integer>("recordID"));
		updateHouseChoresTable();
		// set default to current date
		LocalDate date = LocalDate.now();
		datePicker.setValue(date);
		// set default to login user
		userNameComboBox.setValue(LoginController.getUserName());
		// fill the combo box
		fillUserNameComboBox();
		fillChoresNameComboBox();
	}

	private void updateHouseChoresTable() {
		if (DatabaseADMModel.checkAuthority()){
			listM = DatabaseHouseChoresModel.getHouseChoresRecordTable();
			recordTable.setItems(listM);
		}else{
			listM = DatabaseHouseChoresModel.getSingleUserHouseChoresRecordTable();
			recordTable.setItems(listM);
		}
	}

	/**
	 * fill the userNameComboBox with all username if you are the adm,
	 * fill the userNameComboBox with the login username if you are the the adm,
	 */
	public void fillUserNameComboBox(){
		if (DatabaseADMModel.checkAuthority()) {
			userNameComboBox.getItems().setAll(DatabaseADMModel.getUserName());
		}else{
			userNameComboBox.getItems().setAll(LoginController.getUserName());}
	}

	/**
	 * fill the choresNameComboBox with all houseChoresName
	 */
	public void fillChoresNameComboBox(){
		choresNameComboBox.getItems().setAll(DatabaseHouseChoresModel.getHouseChoresName());
	}

	/**
	 * when click the add button, this will initiate addHouseChores function
	 * @param event action event.
	 */
	public void addButtonOnAction(ActionEvent event) {
		addHouseChores();
	}
	private void addHouseChores() {
		String userNameText = userNameComboBox.getValue();
		String choresNameText = choresNameComboBox.getValue();
		LocalDate dateText = datePicker.getValue();

		DatabaseHouseChoresModel.addHouseChoresRecordTable(userNameText,
				DatabaseHouseChoresModel.houseChoresNameToID(choresNameText),
				dateText,houseChoresRegistryMessageLabel);
		updateHouseChoresTable();
	}

	/**
	 * select the row of the record_table and fill in the corresponding textfield
	 *
	 * @param event the mouse click event
	 */
	public void getSelected(MouseEvent event) {
		index = recordTable.getSelectionModel().getSelectedIndex();
		if (index <= -1) return;
		record_id = colRecordID.getCellData(index);
		userNameComboBox.setValue(colUserName.getCellData(index));
		choresNameComboBox.setValue(colChoreName.getCellData(index));
		datePicker.setValue(colDate.getCellData(index).toLocalDate());
	}

	/**
	 * sql syntax for update the housechores_table and update the vision of the table as well
	 */
	public void edit(ActionEvent event) {

		DatabaseHouseChoresModel.updateHouseChoresRecordTable(
				DatabaseHouseChoresModel.houseChoresNameToID(choresNameComboBox.getValue()),
				userNameComboBox.getValue(),
				datePicker.getValue(),
				record_id,
				houseChoresRegistryMessageLabel
		);
			updateHouseChoresTable();

	}
//	String targetTableName, String deleteIDCol, int deleteID, Label houseChoresRegistryMessageLabel
	public void delete(ActionEvent event) {
		DatabaseHouseChoresModel.deleteRecordIDRow("record_table",
				record_id,
				houseChoresRegistryMessageLabel);

			updateHouseChoresTable();

	}

}
