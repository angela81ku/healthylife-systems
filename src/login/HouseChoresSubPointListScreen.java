package login;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class HouseChoresSubPointListScreen implements Initializable {

	@FXML
	private TableColumn<?, ?> houseCHoresIDColumn;

	@FXML
	private TableColumn<?, ?> houseChoresNameColumn;

	@FXML
	private TableColumn<?, ?> pointColumn;

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



	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){


	}




}
