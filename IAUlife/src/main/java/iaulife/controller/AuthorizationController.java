package iaulife.controller;

import iaulife.animation.Shake;
import iaulife.entity.User;
import iaulife.handler.DataBaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AuthorizationController extends DataBaseHandler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private Button registerButton;

    public static String getEmail;

    @FXML
    void initialize() {
        signInButton.setOnAction((ActionEvent event) -> {
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();
            if (!email.equals("") && !password.equals("")) {
                try {
                    loginUser(email, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                Shake userLoginAnimation = new Shake(emailField);
                Shake userPasswordAnimation = new Shake(passwordField);
                userLoginAnimation.playShakeAnimation();
                userPasswordAnimation.playShakeAnimation();
            }
        });
        // When you press register button it uses openNewWindow method and opens new window
        registerButton.setOnAction((ActionEvent event) -> {
            registerButton.getScene().getWindow().hide();
            openNewWindow("../resources/register.fxml");
        });

    }


    private void loginUser(String email, String password) throws SQLException {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        User user = new User();
        user.setMail(email);
        user.setPassword(password);
        ResultSet resultSet = dataBaseHandler.getUser(user);

        int counter = 0;

        while (resultSet.next()) {
            counter++;
            getEmail = emailField.getText();
        }
        if (counter >= 1) {
            signInButton.getScene().getWindow().hide();
            openNewWindow("../resources/news.fxml");

        } else {
            Shake emailFieldAnimation = new Shake(emailField);
            Shake passwordFieldAnimation = new Shake(passwordField);
            emailFieldAnimation.playShakeAnimation();
            passwordFieldAnimation.playShakeAnimation();
        }
    }

    // Method which calls fxml file and opens new window
    public void openNewWindow(String fxmlPath) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(fxmlPath));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
