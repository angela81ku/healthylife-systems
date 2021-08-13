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
import model.Form;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

/**
 * log in page controller
 */
public class LoginController implements Initializable {
//TODO keyboard listener for enter


	private static String userName = "This person has no name LOL";
	@FXML
	private Button cancelButton;
	@FXML
	private Label loginMessageLabel;
	@FXML
	private ImageView brandingImageView;
	@FXML
	private ImageView lockImageView;
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField enterPasswordField;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		File brandingFile = new File("images/welcomeImage.jpg");
		Image brandingImage = new Image(brandingFile.toURI().toString());
		brandingImageView.setImage(brandingImage);

		File lockFile = new File("images/padlock.png");
		Image lockImage = new Image(lockFile.toURI().toString());
		lockImageView.setImage(lockImage);
	}


	/**
	 * registry button mouse click event, will go to the registry page
	 * @param event
	 */
	public void RegistryButtonAction(ActionEvent event){
		createAccountForm();
	}

	/**
	 * cancel button mouse click event, will end the application
	 * @param event
	 */
	public void CancelButtonAction(ActionEvent event){
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();

	}
	/**
	 * login button mouse click event, will log in to the main page
	 * @param event
	 */
	public void loginButtonOnAction(ActionEvent event){

		if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false){
			validateLogin();

//			loginMessageLabel.setText("You try to login.");
		} else{
			loginMessageLabel.setText("Please enter username and password");
		}
	}

	/**
	 * validate the login, if it match username and password in the database, log in success.
	 */
	public void validateLogin(){
		DatabaseConnectionModel connection = new DatabaseConnectionModel();
		Connection connectDB = connection.getConnection();

		String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" +
		   usernameTextField.getText() + "' AND password = '" + enterPasswordField.getText() + "'";
		try{
			Statement statement = connectDB.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);
			while(queryResult.next()){
				if(queryResult.getInt(1) == 1){
						userName = usernameTextField.getText();
						Stage stage = (Stage) cancelButton.getScene().getWindow();
						stage.close();
						createMainMenuForm();
						loginMessageLabel.setText("");
				}else{
					loginMessageLabel.setText("Invalid login. Please try again");
				}
			}

		}catch(Exception e){
			e.printStackTrace();
			e.getCause();
   }

	}

	public void createAccountForm(){
		String url = "../view_fxml/register.fxml";
		int sceneWidth = 520;
		int sceneLength = 415;
		Form accountForm = new Form(url ,sceneWidth, sceneLength);
		accountForm.creatForm();
	}

	public void createMainMenuForm(){
		String url = "../view_fxml/mainMenuNavigate.fxml";
		int sceneWidth = 1010;
		int sceneLength = 700;
		Form accountForm = new Form(url ,sceneWidth, sceneLength);
		accountForm.creatForm();
	}

	public static String getUserName(){
		return userName;
	}
}