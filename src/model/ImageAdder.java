package model;

import javafx.scene.image.ImageView;

import java.io.File;

public class ImageAdder {

	private String pathName;
	private ImageView imageView;



	public ImageAdder(String pathName, ImageView imageView) {
		this.pathName = pathName;
		this.imageView = imageView;
		addImage();
	}

	public void addImage(){

			File file = new File(pathName);
			javafx.scene.image.Image image = new javafx.scene.image.Image(file.toURI().toString());
			imageView.setImage(image);
	}
}
