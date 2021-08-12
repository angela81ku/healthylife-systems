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

public class HouseChoresMainController extends SystemAbstractController implements Initializable {
	private String CODE = "ABX87";
	private String codeInput = "";
	@FXML
	private ImageView welcomeImage;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		super.initialize(url, resourceBundle);
		super.systemSelectionMessageLabel.setText("House chores System");
		ImageAdder image = new ImageAdder("images/cat2.jpg",welcomeImage);
	}
	private void admCodeVerify() {

		TextInputDialog dialog = new TextInputDialog();

		dialog.setTitle("Authorization required");
		dialog.setHeaderText("Enter the password:");
		dialog.setContentText("Password:");

		Optional<String> result = dialog.showAndWait();
		System.out.println(result);
		if (result.isPresent()){
			codeInput = dialog.getEditor().getText();
			if (codeInput.equals(CODE)){
				String url = "../view_fxml/houseChoresSubPointListScreen.fxml";
				Screen screen = new Screen(url,super.mainOperationPane);
				screen.switchPane();
			}else{
				dialog.close();
			}
		}
	}
	public void loadPointListScreen(ActionEvent event) throws IOException {
		if (DatabaseADMModel.checkAuthority() || CODE.equals(codeInput)){
			String url = "../view_fxml/houseChoresSubPointListScreen.fxml";
			Screen screen = new Screen(url,super.mainOperationPane);
			screen.switchPane();
		}else{
			admCodeVerify();
		}


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