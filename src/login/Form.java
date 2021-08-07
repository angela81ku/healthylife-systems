package login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class Form {

	private String url;
	private int sceneWidth;
	private int sceneLength;


	public Form(String url, int sceneWidth, int sceneLength) {
		this.url = url;
		this.sceneWidth = sceneWidth;
		this.sceneLength = sceneLength;
	}

	public void creatForm(){

		try {
			Parent root = FXMLLoader.load(getClass().getResource(url));
			Stage stage = new Stage();
			stage.setTitle("Healthy Life System");
			File iconFile = new File("images/hubCoral.png");
			Image iconImage = new Image(iconFile.toURI().toString());
			stage.getIcons().add(iconImage);
			
//			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(new Scene(root, sceneWidth, sceneLength));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();

		}
	}
}
