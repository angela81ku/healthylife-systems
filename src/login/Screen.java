package login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class Screen {

	private String url;
	private Pane pane;


	public Screen(String url, Pane pane) {
		this.url = url;
		this.pane = pane;
	}

	public void switchPane(){
		try {
			Parent root = FXMLLoader.load(getClass().getResource(url));
			pane.getChildren().setAll(root);

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
}
