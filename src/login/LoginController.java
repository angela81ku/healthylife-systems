package login;

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



	public void RegistryButtonAction(ActionEvent event){
		createAccountForm();
	}


	public void CancelButtonAction(ActionEvent event){
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();

	}

	public void loginButtonOnAction(ActionEvent actionEvent){

		if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false){
			validateLogin();

//			loginMessageLabel.setText("You try to login.");
		} else{
			loginMessageLabel.setText("Please enter username and password");
		}
	}

	public void validateLogin(){
		DatabaseConnection connection = new DatabaseConnection();
		Connection connectDB = connection.getConnection();

		String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" +
		   usernameTextField.getText() + "' AND password = '" + enterPasswordField.getText() + "'";
		try{
			Statement statement = connectDB.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);
			while(queryResult.next()){
				if(queryResult.getInt(1) == 1){
						userName = usernameTextField.getText();
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
		String url = "../FXML/register.fxml";
		int sceneWidth = 520;
		int sceneLength = 415;
		Form accountForm = new Form(url ,sceneWidth, sceneLength);
		accountForm.creatForm();
	}

	public void createMainMenuForm(){
		String url = "../FXML/MainMenu.fxml";
		int sceneWidth = 520;
		int sceneLength = 400;
		Form accountForm = new Form(url ,sceneWidth, sceneLength);
		accountForm.creatForm();
	}

	public static String getUserName(){
		return userName;
	}
}