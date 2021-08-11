package login;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.annotation.Documented;
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
//	@Override
//	public void displayImage(){
//		super.displayImage();
//
//	}
}