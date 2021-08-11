package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.DatabaseADMModel;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view_fxml/login.fxml"));
        primaryStage.setTitle("Healthy Life System");
        File iconFile = new File("images/hubCoral.png");
        Image iconImage = new Image(iconFile.toURI().toString());
        primaryStage.getIcons().add(iconImage);
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 520,400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //test
        DatabaseADMModel.getUserName();




        //////////////////////////////////////////////////


        launch(args);




    }
}
