package main.java.iaulife.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/gui/news.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 338,51));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
