package iaulife.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController extends AuthorizationController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button newsButton;

    @FXML
    private Button eventsButton;

    @FXML
    private Button announcementsButton;

    @FXML
    private Button scheduleButton;

    @FXML
    private Button logOutButton;

    @FXML
    void initialize() {
        newsButton.setOnAction((ActionEvent event) -> {
            newsButton.getScene().getWindow().hide();
            openNewWindow("../resources/news.fxml");
        });
        eventsButton.setOnAction((ActionEvent event) -> {
            eventsButton.getScene().getWindow().hide();
                openNewWindow("../resources/events.fxml");
        });
        announcementsButton.setOnAction((ActionEvent event) -> {
            announcementsButton.getScene().getWindow().hide();
            openNewWindow("../resources/announcements.fxml");
        });
        scheduleButton.setOnAction((ActionEvent event) -> {
            scheduleButton.getScene().getWindow().hide();
            openNewWindow("../resources/schedule.fxml");
        });
        logOutButton.setOnAction((ActionEvent event) -> {
            logOutButton.getScene().getWindow().hide();
            openNewWindow("../resources/signIn.fxml");
        });


    }
}
