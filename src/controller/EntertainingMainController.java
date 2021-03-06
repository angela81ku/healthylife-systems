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
 * EntertainmentMainController is the controller to control the entertainment main menu
 * extends SystemAbstractController implements Initializable.
 */
public class EntertainingMainController extends SystemAbstractController implements Initializable {
	@FXML
	private ImageView welcomeImage;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		super.initialize(url, resourceBundle);
		super.systemSelectionMessageLabel.setText("Entertaining budget track System");
		ImageAdder image = new ImageAdder("images/cat3.jpg",welcomeImage);
	}


	private void admCodeVerify() {

//		TextInputDialog dialog = new TextInputDialog();
//
//		dialog.setTitle("Authorization required");
//		dialog.setHeaderText("Enter the password:");
//		dialog.setContentText("Password:");
//
//		Optional<String> result = dialog.showAndWait();
//		if (result.isPresent()){
//			codeInput = dialog.getEditor().getText();
//			if (codeInput.equals(CODE)){
//				String url = "../view_fxml/ChoresAndExerciseSubPointListScreen.fxml";
//				Screen screen = new Screen(url,super.mainOperationPane);
//				screen.switchPane();
//			}else{
//				dialog.close();
//			}
//		}
	}
	public void loadPointListScreen(ActionEvent event) throws IOException {
//
//		}		if (DatabaseADMModel.checkAuthority() || CODE.equals(codeInput)){
//			String url = "../view_fxml/ChoresAndExerciseSubPointListScreen.fxml";
//			Screen screen = new Screen(url,super.mainOperationPane);
//			screen.switchPane();
//		}else{
//			admCodeVerify();
	}
	public void loadRecordListScreen(ActionEvent event) throws IOException {
//		String url = "../view_fxml/ChoresAndExerciseSubRecordScreen.fxml";
//		Screen screen = new Screen(url,super.mainOperationPane);
//		screen.switchPane();
	}

	public void loadLeaderScreen(ActionEvent event) throws IOException {
//		String url = "../view_fxml/ChoresAndExerciseSubLeaderScreen.fxml";
//		Screen screen = new Screen(url,super.mainOperationPane);
//		screen.switchPane();
	}
}