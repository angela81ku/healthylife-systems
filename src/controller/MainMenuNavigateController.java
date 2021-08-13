package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.ImageAdder;

import java.net.URL;
import java.util.ResourceBundle;

//TODO after summer term: trashFood, entertaining, health controller create, and connect to corresponding fxml file, right now they are all connected to housechorse one.
public class MainMenuNavigateController extends SystemAbstractController implements Initializable {

	@FXML
	private ImageView welcomeImage;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		super.initialize(url, resourceBundle);
		super.systemSelectionMessageLabel.setText("Main Menu");
		ImageAdder image = new ImageAdder("images/cat.jpg",welcomeImage);
	}

}