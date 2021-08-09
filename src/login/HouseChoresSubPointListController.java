package login;

import com.sun.javafx.charts.Legend;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.FXML;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HouseChoresSubPointListController implements Initializable {

	private DatabaseConnection connectNow = new DatabaseConnection();

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

//	int index = -1;
//	Connection connection = null;
//	ResultSet resultSet = null;
//	PreparedStatement preparedStatement = null;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		//the PropertyValueFactory tales the variable name of the HouseChoresPoint.
		colID.setCellValueFactory(new PropertyValueFactory<HouseChoresPoint,Integer>("houseChoresID"));
		colChoreName.setCellValueFactory(new PropertyValueFactory<HouseChoresPoint,String>("houseChoresName"));
		colPoint.setCellValueFactory(new PropertyValueFactory<HouseChoresPoint,Integer>("point"));

		updateList();

	}

	private void updateList(){
		listM = DatabaseConnection.getPointTable();
		pointTable.setItems(listM);
	}

	public void addButtonOnAction(ActionEvent event){
		addHouseChoresID();

	}


	public void addHouseChoresID(){
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		try{
			int houseChoresIDColumnText = Integer.parseInt(houseChoresIDTextField.getText());
			String choresNameText = choresNameTextField.getText();
			int pointColumnText = Integer.parseInt(pointTextField.getText());

//		String insertFields = "INSERT INTO point_list (houseChoresIDColumn,houseChoresNameColumn,pointColumn) VALUES(";
//		String insertValues = houseChoresIDColumnText + ",'" + choresNameText + "','" + pointColumnText  + "');";
//		String insertToPointList = insertFields + insertValues;


			String sql = "INSERT INTO point_list(houseChoresIDColumn, houseChoresNameColumn, pointColumn) VALUES(?,?,?)";
			PreparedStatement statement = connectDB.prepareStatement(sql);
			statement.setInt(1, houseChoresIDColumnText);
			statement.setString(2, choresNameText);
			statement.setInt(3, pointColumnText);

			statement.executeUpdate();
			houseChoresRegistryMessageLabel.setText("House chore registers successfully!");
			System.out.println("Success");
		}catch(SQLIntegrityConstraintViolationException duplicate){
			houseChoresRegistryMessageLabel.setText("House Chores ID should be integer\n" +
					"House Point should be integer\n");
		}catch(NumberFormatException numberFormatException){
			houseChoresRegistryMessageLabel.setText("House Chores ID should be integer\n" +
					"House Point should be integer\n");
		}catch(SQLException e){
			houseChoresRegistryMessageLabel.setText("House Chores ID should be unique");
			e.printStackTrace();
			e.getCause();
		}
		updateList();
	}
}
