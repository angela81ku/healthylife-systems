package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.ImageAdder;
import model.Screen;

import java.io.IOException;
import java.net.URL;
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
		String url = "../view_fxml/houseChoresSubPointListScreen.fxml";
		Screen screen = new Screen(url,super.mainOperationPane);
		screen.switchPane();
	}
	public void loadRecordListScreen(ActionEvent event) throws IOException {
		String url = "../view_fxml/houseChoresSubRecordScreen.fxml";
		Screen screen = new Screen(url,super.mainOperationPane);
		screen.switchPane();
	}

	public void loadLeaderScreen(ActionEvent event) throws IOException {
		String url = "../view_fxml/houseChoresSubLeaderScreen.fxml";
		Screen screen = new Screen(url,super.mainOperationPane);
		screen.switchPane();
	}

}