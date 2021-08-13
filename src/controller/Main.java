package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.DatabaseADMModel;
import model.DatabaseChoresAndExerciseModel;
import model.UserTableCol;

import javax.xml.crypto.Data;
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
        System.out.println(DatabaseADMModel.getUserName());
        System.out.println(DatabaseChoresAndExerciseModel.getHouseChoresName());
        System.out.println(DatabaseChoresAndExerciseModel.getHouseChoresPointTable());
        System.out.println(DatabaseChoresAndExerciseModel.getHouseChoresRecordTable());
        System.out.println(DatabaseChoresAndExerciseModel.getSingleUserHouseChoresRecordTable());
        System.out.println(DatabaseChoresAndExerciseModel.houseChoresNameToID("mopping - 5m"));
        //////////////////////////////////////////////////

        launch(args);


    }
}
