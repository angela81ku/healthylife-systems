package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import model.DatabaseConnectionModel;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

public class RegisterController implements Initializable{

	@FXML
	private ImageView shieldImageView;
	@FXML
	private Button closeButton;
	@FXML
	private Label registrationMessageLabel;
	@FXML
	private PasswordField setPasswordField;
	@FXML
	private PasswordField confirmPasswordField;
	@FXML
	private Label confirmPasswordLabel;
	@FXML
	private TextField firstnameTextField;
	@FXML
	private TextField lastnameTextField;
	@FXML
	private TextField usernameTextField;
	@FXML
	private Label usernameDuplicateLabel;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){

		File shieldFile = new File("images/approval.png");
		Image shieldImage = new Image(shieldFile.toURI().toString());
		shieldImageView.setImage(shieldImage);
	}

	public void closeButtonOnAction(ActionEvent event){
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
//		Platform.exit();
	}

	public void registerButtonOnAction(ActionEvent actionEvent) {
		if (setPasswordField.getText().equals(confirmPasswordField.getText())){
			usernameDuplicateLabel.setText("");
			registerUser();
			confirmPasswordLabel.setText("");

		}else{
			confirmPasswordLabel.setText("Password doesn't match");
		}

	}
  public void registerUser() {
		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
		Connection connectDB = connectNow.getConnection();

		String firstname = firstnameTextField.getText();
		String lastname = lastnameTextField.getText();
		String username = usernameTextField.getText();
		String password = setPasswordField.getText();

		String insertFields = "INSERT INTO user_account(lastname, firstname, username, password) VALUES ('";
		String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "');";
		String insertToRegistry = insertFields + insertValues;

		try{
			Statement statement = connectDB.createStatement();
			statement.executeUpdate(insertToRegistry);
			registrationMessageLabel.setText("User has been registered successfully!");
			usernameDuplicateLabel.setText("");

		}catch(SQLIntegrityConstraintViolationException duplicate){
			usernameDuplicateLabel.setText("Username already exists, please pick another one.");

		}catch(Exception e){
			e.printStackTrace();
			e.getCause();
		}
	}
}
