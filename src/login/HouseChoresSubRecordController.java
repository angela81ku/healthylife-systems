package login;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
		// fill the combo box
		fillUserNameComboBox();
		fillChoresNameComboBox();
	}

	private void updateHouseChoresTable() {
		listM = DatabaseHouseChoresModel.getHouseChoresRecordTable();
		recordTable.setItems(listM);
	}

	/**
	 * fill the userNameComboBox with all username
	 */
	public void fillUserNameComboBox(){
		userNameComboBox.getItems().setAll(DatabaseADMModel.getUserName());
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
		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
		Connection connectDB = connectNow.getConnection();
		try {
			String uerNameText = userNameComboBox.getValue();
			String choresNameText = choresNameComboBox.getValue();
			LocalDate dateText = datePicker.getValue();

			String sql = "INSERT INTO record_table(username, houseChoresName, date) VALUES(?,?,?)";
			PreparedStatement statement = connectDB.prepareStatement(sql);
			statement.setString(1, uerNameText);
			statement.setString(2, choresNameText);
			statement.setDate(3, Date.valueOf(dateText));

			statement.executeUpdate();
			houseChoresRegistryMessageLabel.setText("Record successfully!");
		} catch (SQLIntegrityConstraintViolationException duplicate) {
			houseChoresRegistryMessageLabel.setText("formation incorrect\n");
		} catch (NumberFormatException numberFormatException) {
			houseChoresRegistryMessageLabel.setText("formation incorrect\n");
		}catch (NullPointerException e) {
			houseChoresRegistryMessageLabel.setText("fPlease fill in all the field\n");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
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
		try {
			String sql = "UPDATE record_table SET houseChoresName = ?, username = ?, date = ? WHERE record_id = ?";
			PreparedStatement statement = connectDB.prepareStatement(sql);
			statement.setString(1, choresNameComboBox.getValue());
			statement.setString(2, userNameComboBox.getValue());
			statement.setDate(3, Date.valueOf(datePicker.getValue()));
			statement.setInt(4, record_id);
			statement.execute();
			updateHouseChoresTable();
			houseChoresRegistryMessageLabel.setText("Update successfully");
		}catch(DataTruncation dataTruncation){
			houseChoresRegistryMessageLabel.setText("name too long");
		}catch (NumberFormatException numberFormatException) {
			houseChoresRegistryMessageLabel.setText("formation incorrect\n");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void delete(ActionEvent event) {
		String sql = "DELETE FROM record_table WHERE record_id = ?";
		try {
			PreparedStatement statement = connectDB.prepareStatement(sql);
			statement.setInt(1, record_id);
			statement.execute();
			houseChoresRegistryMessageLabel.setText("Delete successfully");
			updateHouseChoresTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

}
