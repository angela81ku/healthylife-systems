package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.ImageAdder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * EntertainmentMainController is the controller to control the entertainment main menu
 * extends SystemAbstractController implements Initializable.
 */
public class TrashFoodMainController extends SystemAbstractController implements Initializable {
	@FXML
	private ImageView welcomeImage;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		super.initialize(url, resourceBundle);
		super.systemSelectionMessageLabel.setText("Trash food track System");
		ImageAdder image = new ImageAdder("images/cat4.jpg",welcomeImage);
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