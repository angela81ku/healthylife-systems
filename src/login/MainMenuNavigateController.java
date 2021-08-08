package login;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuNavigateController implements Initializable {

	private int SLIDER_WIDTH = 236;
	@FXML
	private AnchorPane slider;

	@FXML
	private Button houseChoresButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Button healthTrackButton;

	@FXML
	private Button trashFoodTrackButton;

	@FXML
	private Button entertainingBudgetButton;

	@FXML
	private ImageView houseImage;

	@FXML
	private ImageView entertainImage;

	@FXML
	private ImageView sportImage;

	@FXML
	private ImageView friesImage;

	@FXML
	private ImageView exitImage;

	@FXML
	private ImageView hubImage;

	@FXML
	private Label menuButton;

	@FXML
	private ImageView pointListImage;

	@FXML
	private ImageView recordImage;

	@FXML
	private ImageView leaderImage;

	@FXML
	private ImageView calendarImage;

	@FXML
	private ImageView allocationImage;

	@FXML
	private Label menuCloseButton;

	@FXML
	private ImageView menuImage;

	@FXML
	private Label systemSelectionMessageLabel;

	@FXML
	private AnchorPane greetingLabel;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		displayImage();
		// slider setting
		slider.setTranslateX(-SLIDER_WIDTH);
		menuButton.setOnMouseClicked(event -> {
				TranslateTransition slide = new TranslateTransition();
				slide.setDuration(Duration.seconds(0.4));
				slide.setNode(slider);

				slide.setToX(0);
				slide.play();
				slider.setTranslateX(-SLIDER_WIDTH);

				slide.setOnFinished((ActionEvent e) ->{
					menuButton.setVisible(false);
					menuCloseButton.setVisible(true);
				});
		});

		menuCloseButton.setOnMouseClicked(event2 -> {
					TranslateTransition slide1 = new TranslateTransition();
					slide1.setDuration(Duration.seconds(0.4));
					slide1.setNode(slider);

					slide1.setToX(-SLIDER_WIDTH);
					slide1.play();
					slider.setTranslateX(0);

					slide1.setOnFinished((ActionEvent e) ->{
						menuButton.setVisible(true);
						menuCloseButton.setVisible(false);
					});
		});
		systemSelectionMessageLabel.setText("House chores workload");



		}

		public void displayImage(){
			ImageAdder image = new ImageAdder("images/house-2-64.png",houseImage);
			ImageAdder image1 = new ImageAdder("images/emoticon-48-64.png",entertainImage);
			ImageAdder image2 = new ImageAdder("images/soccer-4-64.png",sportImage);
			ImageAdder image3 = new ImageAdder("images/french-fries-64.png",friesImage);
			ImageAdder image4 = new ImageAdder("images/add-list-64.png",pointListImage);
			ImageAdder image5 = new ImageAdder("images/record.png",recordImage);
			ImageAdder image6 = new ImageAdder("images/win-64.png",leaderImage);
			ImageAdder image7 = new ImageAdder("images/calendar-2-128.png",calendarImage);
			ImageAdder image8 = new ImageAdder("images/user-5-64.png",allocationImage);
			ImageAdder image9 = new ImageAdder("images/exit-64.png",exitImage);
			ImageAdder image10 = new ImageAdder("images/hubCoral.png",hubImage);

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