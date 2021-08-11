package login;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HouseChoresMainController extends SystemAbstractController implements Initializable {
	@FXML
	private ImageView welcomeImage;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		super.initialize(url, resourceBundle);
		super.systemSelectionMessageLabel.setText("House chores System");
		ImageAdder image = new ImageAdder("images/cat2.jpg",welcomeImage);
	}

	public void loadPointListScreen(ActionEvent event) throws IOException {
		String url = "../FXML/houseChoresSubPointListScreen.fxml";
		Screen screen = new Screen(url,super.mainOperationPane);
		screen.switchPane();
	}
	public void loadRecordListScreen(ActionEvent event) throws IOException {
		String url = "../FXML/houseChoresSubRecordScreen.fxml";
		Screen screen = new Screen(url,super.mainOperationPane);
		screen.switchPane();
	}

	public void loadLeaderScreen(ActionEvent event) throws IOException {
		String url = "../FXML/houseChoresSubLeaderScreen.fxml";
		Screen screen = new Screen(url,super.mainOperationPane);
		screen.switchPane();
	}

}