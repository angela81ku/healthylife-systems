package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.ChoresAndExerciseRecordTableCol;
import model.DatabaseADMModel;
import model.DatabaseChoresAndExerciseModel;
import model.DatabaseConnectionModel;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * ChoresAndExerciseSubRecordController can control the scene of the record page embedded in the ChoresAndExerciseMainScreen
 */
public class ChoresAndExerciseSubRecordController implements Initializable {

	private DatabaseConnectionModel connectNow = new DatabaseConnectionModel();

	private Connection connectDB = connectNow.getConnection();

	private ObservableList<ChoresAndExerciseRecordTableCol> listM;

	private int record_id;

	@FXML
	private TableView<ChoresAndExerciseRecordTableCol> recordTable;

	@FXML
	private TableColumn<ChoresAndExerciseRecordTableCol, String> colUserName;

	@FXML
	private TableColumn<ChoresAndExerciseRecordTableCol, String> colChoreName;

	@FXML
	private TableColumn<ChoresAndExerciseRecordTableCol, Date> colDate;

	@FXML
	private Label messageLabel;

	@FXML
	private TableColumn<ChoresAndExerciseRecordTableCol, Integer> colRecordID;

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


	private int index = -1;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		//the PropertyValueFactory takes the variable name from the ChoresAndExerciseRecordTableCol.
//		String userName, String houseChoresName, Date date
		colUserName.setCellValueFactory(new PropertyValueFactory<ChoresAndExerciseRecordTableCol, String>("userName"));
		colChoreName.setCellValueFactory(new PropertyValueFactory<ChoresAndExerciseRecordTableCol, String>("choresAndExerciseName"));
		colDate.setCellValueFactory(new PropertyValueFactory<ChoresAndExerciseRecordTableCol, Date>("date"));
		colRecordID.setCellValueFactory(new PropertyValueFactory<ChoresAndExerciseRecordTableCol, Integer>("recordID"));
		updateEventRecordTable();
		// set default to current date
		LocalDate date = LocalDate.now();
		datePicker.setValue(date);
		// set default to login user
		userNameComboBox.setValue(LoginController.getUserName());
		// fill the combo box
		fillUserNameComboBox();
		fillChoresNameComboBox();
		setMessageLabel();
	}

	/**
	 * set the message label based on the login user's authorization, if it's admistrator, it will show it's
	 * adm mode, if it's a member then just show the instruction.
	 */
	private void setMessageLabel(){
		if(DatabaseADMModel.checkAuthority()){
			messageLabel.setText("You are in the administration mode");
		}else{
			messageLabel.setText("You can record your event!");
		}
	}

	/**
	 * update the event record table, administrator can record all members' event, while other can only
	 * record their own event.
	 */
	private void updateEventRecordTable() {
		if (DatabaseADMModel.checkAuthority()){
			listM = DatabaseChoresAndExerciseModel.getHouseChoresRecordTable();
			recordTable.setItems(listM);
		}else{
			listM = DatabaseChoresAndExerciseModel.getSingleUserHouseChoresRecordTable();
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
		choresNameComboBox.getItems().setAll(DatabaseChoresAndExerciseModel.getHouseChoresName());
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

		DatabaseChoresAndExerciseModel.addHouseChoresRecordTable(userNameText,
				DatabaseChoresAndExerciseModel.houseChoresNameToID(choresNameText),
				dateText,houseChoresRegistryMessageLabel);
		updateEventRecordTable();
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

		DatabaseChoresAndExerciseModel.updateEventRecordTable(
				DatabaseChoresAndExerciseModel.houseChoresNameToID(choresNameComboBox.getValue()),
				userNameComboBox.getValue(),
				datePicker.getValue(),
				record_id,
				houseChoresRegistryMessageLabel
		);
			updateEventRecordTable();

	}

	public void delete(ActionEvent event) {
		DatabaseChoresAndExerciseModel.deleteRecordIDRow("record_table",
				record_id,
				houseChoresRegistryMessageLabel);

			updateEventRecordTable();

	}

}
