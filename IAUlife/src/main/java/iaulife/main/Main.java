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
            panel = FXMLLoader.load(getClass().getResource("../resources/signIn.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Parent panel = FXMLLoader.load(getClass().getResource("../resources/signIn.fxml"));

        Scene scene = new Scene(panel, 588,593);
        primaryStage.setTitle("International Ala-Too University Life");

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
