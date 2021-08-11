//package login;
//
//import javafx.animation.TranslateTransition;
//import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
////TODO after summer term: trashFood, entertaining, health controller create, and connect to corresponding fxml file, right now they are all connected to housechorse one.
//public class OldMainMenuNavigateController implements Initializable {
//
//	private int SLIDER_WIDTH = 235;
//	@FXML
//	private BorderPane systemOperationPane;
//
//	@FXML
//	private AnchorPane slider;
//
//	@FXML
//	private Button houseChoresButton;
//
//	@FXML
//	private Button cancelButton;
//
//	@FXML
//	private Button healthTrackButton;
//
//	@FXML
//	private Button trashFoodTrackButton;
//
//	@FXML
//	private Button entertainingBudgetButton;
//
//	@FXML
//	private ImageView houseImage;
//
//	@FXML
//	private ImageView entertainImage;
//
//	@FXML
//	private ImageView sportImage;
//
//	@FXML
//	private ImageView friesImage;
//
//	@FXML
//	private ImageView exitImage;
//
//	@FXML
//	private ImageView hubImage;
//
//	@FXML
//	private AnchorPane mainOperationPane;
//
//	@FXML
//	private Label menuButton;
//
//	@FXML
//	private ImageView pointListImage;
//
//	@FXML
//	private ImageView recordImage;
//
//	@FXML
//	private ImageView leaderImage;
//
//	@FXML
//	private ImageView calendarImage;
//
//	@FXML
//	private ImageView allocationImage;
//
//	@FXML
//	private Label menuCloseButton;
//
//	@FXML
//	private ImageView menuImage;
//
//	@FXML
//	private ImageView menuCloseImage;
//
//	@FXML
//	private Label systemSelectionMessageLabel;
//
//
//	@Override
//	public void initialize(URL url, ResourceBundle resourceBundle){
//		displayImage();
//		// slider setting
//		slider.setTranslateX(-SLIDER_WIDTH);
//		menuButton.setOnMouseClicked(event -> {
//				TranslateTransition slide = new TranslateTransition();
//				slide.setDuration(Duration.seconds(0.4));
//				slide.setNode(slider);
//
//				slide.setToX(0);
//				slide.play();
//				slider.setTranslateX(-SLIDER_WIDTH);
//
//				slide.setOnFinished((ActionEvent e) ->{
//					menuButton.setVisible(false);
//					menuCloseButton.setVisible(true);
//				});
//		});
//
//		menuCloseButton.setOnMouseClicked(event2 -> {
//				TranslateTransition slide1 = new TranslateTransition();
//				slide1.setDuration(Duration.seconds(0.4));
//				slide1.setNode(slider);
//
//				slide1.setToX(-SLIDER_WIDTH);
//				slide1.play();
//				slider.setTranslateX(0);
//
//				slide1.setOnFinished((ActionEvent e) ->{
//					menuButton.setVisible(true);
//					menuCloseButton.setVisible(false);
//				});
//		});
//		systemSelectionMessageLabel.setText("Main Menu");
//
//		}
//
//		public void displayImage(){
//			ImageAdder image = new ImageAdder("images/house-2-64.png",houseImage);
//			ImageAdder image1 = new ImageAdder("images/emoticon-48-64.png",entertainImage);
//			ImageAdder image2 = new ImageAdder("images/soccer-4-64.png",sportImage);
//			ImageAdder image3 = new ImageAdder("images/french-fries-64.png",friesImage);
//			ImageAdder image4 = new ImageAdder("images/add-list-64.png",pointListImage);
//			ImageAdder image5 = new ImageAdder("images/record.png",recordImage);
//			ImageAdder image6 = new ImageAdder("images/win-64.png",leaderImage);
//			ImageAdder image7 = new ImageAdder("images/calendar-2-128.png",calendarImage);
//			ImageAdder image8 = new ImageAdder("images/user-5-64.png",allocationImage);
//			ImageAdder image9 = new ImageAdder("images/exit-64.png",exitImage);
//			ImageAdder image10 = new ImageAdder("images/hubCoral.png",hubImage);
//			ImageAdder image11 = new ImageAdder("images/activity-feed-64.png",menuImage);
//			ImageAdder image12 = new ImageAdder("images/activity-feed-64.png",menuCloseImage);
//
//		}
//
//
//
//	public void loadHouseChoresMainScreen(ActionEvent event) throws IOException {
//		String url = "../FXML/houseChoresMainScreen.fxml";
//		Screen screen = new Screen(url,systemOperationPane);
//		screen.switchPane();
//	}
//
//	public void loadEntertainingMainScreen(ActionEvent event) throws IOException {
//		String url = "../FXML/entertainingMainScreen.fxml";
//		Screen screen = new Screen(url,systemOperationPane);
//		screen.switchPane();
//	}
//
//	public void loadHealthMainScreen(ActionEvent event) throws IOException {
//		String url = "../FXML/healthMainScreen.fxml";
//		Screen screen = new Screen(url,systemOperationPane);
//		screen.switchPane();
//	}
//
//	public void loadTrashFoodMainScreen(ActionEvent event) throws IOException {
//		String url = "../FXML/trashFoodMainScreen.fxml";
//		Screen screen = new Screen(url,systemOperationPane);
//		screen.switchPane();
//	}
//
//
//
//	public void cancelButtonAction(ActionEvent event){
//		Stage stage = (Stage) cancelButton.getScene().getWindow();
//		stage.close();
//		Platform.exit();
//
//	}
//
//
//}