package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

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
