package main.java.iaulife.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField emailFIeld;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button backButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField genderField;

    @FXML
    private DatePicker birthday;

    @FXML
    void initialize() {
            
    }
}