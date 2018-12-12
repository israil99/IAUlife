package iaulife.controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import iaulife.animation.AlertHelper;
import iaulife.animation.Shake;
import iaulife.entity.Person;
import iaulife.entity.User;
import iaulife.handler.DataBaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Window;

public class RegistrationController extends AuthorizationController {// inherits methods from parent class
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField emailField;

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
    private DatePicker birthdayField;

    @FXML
    void initialize() {
        registerButton.setOnAction((ActionEvent event) -> {
            if (surnameField.getText().isEmpty()) {
                animation();
            } else if (emailField.getText().isEmpty() || passwordField.getText().isEmpty() || nameField.getText().isEmpty() || birthdayField.getValue().toString().isEmpty()) {
                animation();
            } else {
                try {
                    checkMail();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            alertCaller();
        });
        // when you press back button it switches you to authorization window
        backButton.setOnAction((ActionEvent event) -> {
            backButton.getScene().getWindow().hide();
            openNewWindow("../resources/signIn.fxml");
        });
    }


    private void animation() {

        Shake emailFieldAnimation = new Shake(emailField);
        Shake passwordFieldAnimation = new Shake(passwordField);
        Shake nameFieldAnimation = new Shake(nameField);
        Shake surnameFieldAnimation = new Shake(passwordField);
        Shake genderFieldAnimation = new Shake(genderField);
        Shake birthdayFieldAnimation = new Shake(birthdayField);

        emailFieldAnimation.playShakeAnimation();
        passwordFieldAnimation.playShakeAnimation();
        nameFieldAnimation.playShakeAnimation();
        surnameFieldAnimation.playShakeAnimation();
        genderFieldAnimation.playShakeAnimation();
        birthdayFieldAnimation.playShakeAnimation();
    }

    private void checkMail() throws SQLException {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        Window owner = registerButton.getScene().getWindow();
        User user = new User();
        user.setMail(emailField.getText());
        ResultSet resultSet = dataBaseHandler.getEmail(user);

        int counter = 0;

        while (resultSet.next()) {
            counter++;
        }
        if (counter >= 1) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "This login is already engaged");
        } else {
            signUpNewUser();
            AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Registration Successful!",
                    "Welcome " + nameField.getText() + " " + surnameField.getText());
        }

    }

    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();

        String email = emailField.getText();
        String password = passwordField.getText();

        User user = new User(email, password, 1);

        dbHandler.signUpUser(user);

        String name = nameField.getText();
        String surname = surnameField.getText();
        String birthday = birthdayField.getValue().toString();

        Person person = new Person(name, surname, birthday);
        dbHandler.signUpPerson(person);

    }

    @FXML
    private void alertCaller() {
        Window owner = registerButton.getScene().getWindow();
        if (nameField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your name");
            return;
        }
        if (surnameField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your surname");
            return;
        }
        if (emailField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a email");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }
        if (birthdayField.getValue().toString().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a birthday");
            return;
        }


    }
}
