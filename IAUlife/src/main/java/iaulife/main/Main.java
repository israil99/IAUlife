package iaulife.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent panel = null;
        try {
            panel = FXMLLoader.load(getClass().getResource("signIn.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Parent panel = FXMLLoader.load(getClass().getResource("signIn.fxml"));

        Scene scene = new Scene(panel, 338,51);
        primaryStage.setTitle("International Ala-Too University Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
