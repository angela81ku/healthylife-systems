package controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EntertainingMainController extends SystemAbstractController implements Initializable {

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		super.initialize(url, resourceBundle);
		super.systemSelectionMessageLabel.setText("Entertaining budget track System");
	}


}