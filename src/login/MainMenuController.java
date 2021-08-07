package login;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

public class MainMenuController implements Initializable {

	@FXML
	private Label greetingLabel;
	@FXML
	private ImageView brandingImageView;
	@FXML
	private ImageView lockImageView;
	@FXML
	private Button cancelButton;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		File brandingFile = new File("images/cat.jpg");
		Image brandingImage = new Image(brandingFile.toURI().toString());
		brandingImageView.setImage(brandingImage);

		File lockFile = new File("images/padlock2.png");
		Image lockImage = new Image(lockFile.toURI().toString());
		lockImageView.setImage(lockImage);

		greetingLabel.setText("Welcome back " + LoginController.getUserName() + "!" +
				"\nWhat do you want to do today?");
	}

//	public void loginButtonOnAction(ActionEvent actionEvent){
//
//		if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false){
//			validateLogin();
////			loginMessageLabel.setText("You try to login.");
//		} else{
//			loginMessageLabel.setText("Please enter username and password");
//		}
//	}
//
//	public void RegistryButtonAction(ActionEvent event){
//		createAccountForm();
//	}
//
//
	public void CancelButtonAction(ActionEvent event){
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
		Platform.exit();

	}

//
//	public void createAccountForm() {
//		try {
//			Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
////        primaryStage.setTitle("Healthy Life System");
//			Stage registerStage = new Stage();
//			registerStage.initStyle(StageStyle.UNDECORATED);
//			registerStage.setScene(new Scene(root, 520, 415));
//			registerStage.show();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			e.getCause();
//		}
//	}
}