package login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
			Stage registerStage = new Stage();
			registerStage.setTitle("Healthy Life System");
//			registerStage.initStyle(StageStyle.UNDECORATED);
			registerStage.setScene(new Scene(root, sceneWidth, sceneLength));
			registerStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();

		}
	}
}
