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
import java.util.ResourceBundle;

public class HouseChoresSubRecordController implements Initializable {

	private DatabaseConnectionModel connectNow = new DatabaseConnectionModel();

	private Connection connectDB = connectNow.getConnection();

	@FXML
	private TableView<HouseChoresPoint> pointTable;

	@FXML
	private TableColumn<HouseChoresPoint, Integer> colID;

	@FXML
	private TableColumn<HouseChoresPoint, String> colChoreName;

	@FXML
	private TableColumn<HouseChoresPoint, Integer> colPoint;

	@FXML
	private Button addButton;

	@FXML
	private Button updateButton;

	@FXML
	private Button deleteButton;

	@FXML
	private TextField houseChoresIDTextField;

	@FXML
	private TextField choresNameTextField;

	@FXML
	private TextField pointTextField;

	@FXML
	private Label houseChoresRegistryMessageLabel;

	ObservableList<HouseChoresPoint> listM;

	private int index = -1;
//	Connection connection = null;
//	ResultSet resultSet = null;
//	PreparedStatement preparedStatement = null;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		//the PropertyValueFactory tales the variable name of the HouseChoresPoint.
		colID.setCellValueFactory(new PropertyValueFactory<HouseChoresPoint, Integer>("houseChoresID"));
		colChoreName.setCellValueFactory(new PropertyValueFactory<HouseChoresPoint, String>("houseChoresName"));
		colPoint.setCellValueFactory(new PropertyValueFactory<HouseChoresPoint, Integer>("point"));

		updateHouseChoresTable();
	}

	private void updateHouseChoresTable() {
		listM = DatabaseConnectionModel.getHouseChoresPointTable();
		pointTable.setItems(listM);
	}

	public void addButtonOnAction(ActionEvent event) {
		addHouseChores();

	}

	public void updateButtonOnAction(ActionEvent event) {


	}

	public void deleteButtonOnAction(ActionEvent event) {


	}


	private void addHouseChores() {
		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
		Connection connectDB = connectNow.getConnection();
		try {
			int houseChoresIDColumnText = Integer.parseInt(houseChoresIDTextField.getText());
			String choresNameText = choresNameTextField.getText();
			int pointColumnText = Integer.parseInt(pointTextField.getText());

			String sql = "INSERT INTO housechores_table(houseChoresID, houseChoresName, point) VALUES(?,?,?)";
			PreparedStatement statement = connectDB.prepareStatement(sql);
			statement.setInt(1, houseChoresIDColumnText);
			statement.setString(2, choresNameText);
			statement.setInt(3, pointColumnText);

			statement.executeUpdate();
			houseChoresRegistryMessageLabel.setText("House chore registers successfully!");
		} catch (SQLIntegrityConstraintViolationException duplicate) {
			houseChoresRegistryMessageLabel.setText("House Chores ID should be unique\n");
		} catch (NumberFormatException numberFormatException) {
			houseChoresRegistryMessageLabel.setText("House Chores ID should be integer\n" +
					"House Point should be integer\n");
		} catch (SQLException e) {
			houseChoresRegistryMessageLabel.setText("House Chores ID should be unique");
			e.printStackTrace();
			e.getCause();
		}
		updateHouseChoresTable();
	}

	/**
	 * select the row of the point_table and fill in the corresponding textfield
	 *
	 * @param event the mouse click event
	 */
	public void getSelected(MouseEvent event) {
		index = pointTable.getSelectionModel().getSelectedIndex();
		if (index <= -1) return;

		houseChoresIDTextField.setText(colID.getCellData(index).toString());
		choresNameTextField.setText(colChoreName.getCellData(index));
		pointTextField.setText(colPoint.getCellData(index).toString());
	}

	/**
	 * sql syntax for update the housechores_table and update the vision of the table as well
	 */
	public void edit() {
		try {
			String sql = "UPDATE housechores_table SET houseChoresName = ?, point = ? WHERE houseChoresID = ?";
			PreparedStatement statement = connectDB.prepareStatement(sql);
			statement.setString(1, choresNameTextField.getText());
			statement.setString(2, pointTextField.getText());
			statement.setString(3, houseChoresIDTextField.getText());
			statement.execute();
			updateHouseChoresTable();
			houseChoresRegistryMessageLabel.setText("Update successfully");
		}catch(DataTruncation dataTruncation){
			houseChoresRegistryMessageLabel.setText("House Chores ID should be integer\n"+
					"House Point should be integer");
		}catch (NumberFormatException numberFormatException) {
			houseChoresRegistryMessageLabel.setText("House Chores ID should be integer\n" +
					"House Point should be integer\n");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void delete() {
		String sql = "DELETE FROM housechores_table WHERE houseChoresID = ?";
		try {
			PreparedStatement statement = connectDB.prepareStatement(sql);
			statement.setString(1, houseChoresIDTextField.getText());
			statement.execute();
			houseChoresRegistryMessageLabel.setText("Delete successfully");
			updateHouseChoresTable();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

}
