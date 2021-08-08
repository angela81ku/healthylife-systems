package login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ImageAdder {

	private String pathName;
	private ImageView imageView;



	public ImageAdder(String pathName, ImageView imageView) {
		this.pathName = pathName;
		this.imageView = imageView;
		addImage();
	}

	public void addImage(){
			System.out.println("add start");
			File file = new File(pathName);
			javafx.scene.image.Image image = new javafx.scene.image.Image(file.toURI().toString());
			imageView.setImage(image);
			System.out.println("add success");
	}
}
