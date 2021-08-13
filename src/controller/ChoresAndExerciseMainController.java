package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import model.DatabaseADMModel;
import model.ImageAdder;
import model.Screen;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
/**
 * ChoresAndExerciseMainController is the controller to control the ChoresAndExerciseMainController main menu
 * extends SystemAbstractController implements Initializable.
 */
public class ChoresAndExerciseMainController extends SystemAbstractController implements Initializable {
	private String CODE = "ABX87";
	private String codeInput = "";
	@FXML
	private ImageView welcomeImage;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		super.initialize(url, resourceBundle);
		super.systemSelectionMessageLabel.setText("Chores and exercise system");
		ImageAdder image = new ImageAdder("images/cat2.jpg",welcomeImage);
	}


	/**
	 * access control, it would pop up a textInputDialog to ask for password
	 * if the password is correct, point list can be accessed
	 */
	private void admCodeVerify() {

		TextInputDialog dialog = new TextInputDialog();

		dialog.setTitle("Authorization required");
		dialog.setHeaderText("Enter the password:");
		dialog.setContentText("Password:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			codeInput = dialog.getEditor().getText();
			if (codeInput.equals(CODE)){
				String url = "../view_fxml/ChoresAndExerciseSubPointListScreen.fxml";
				Screen screen = new Screen(url,super.mainOperationPane);
				screen.switchPane();
			}else{
				dialog.close();
			}
		}
	}

	/**
	 * load point list screen if the user is one of the administrator, else ask for password.
	 * @param event mouse click event linked to point list button
	 * @throws IOException
	 */
	public void loadPointListScreen(ActionEvent event) {
		if (DatabaseADMModel.checkAuthority() || CODE.equals(codeInput)){
			String url = "../view_fxml/ChoresAndExerciseSubPointListScreen.fxml";
			Screen screen = new Screen(url,super.mainOperationPane);
			screen.switchPane();
		}else{
			admCodeVerify();
		}
	}

	/**
	 * load record list screen
	 * @param event mouse click event
	 * @throws IOException
	 */
	public void loadRecordListScreen(ActionEvent event) throws IOException {
		String url = "../view_fxml/ChoresAndExerciseSubRecordScreen.fxml";
		Screen screen = new Screen(url,super.mainOperationPane);
		screen.switchPane();
	}

	/**
	 * load leader board screen
	 * @param event mouse click event
	 * @throws IOException
	 */
	public void loadLeaderScreen(ActionEvent event) throws IOException {
		String url = "../view_fxml/ChoresAndExerciseSubLeaderScreen.fxml";
		Screen screen = new Screen(url,super.mainOperationPane);
		screen.switchPane();
	}

}