package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.database.DatabaseHandler;
import sample.crates.Officer;

public class NewOfficer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button RegistButton;

    @FXML
    private TextField BadgeField;

    @FXML
    private TextField SurnameField;

    @FXML
    private TextField PostField;

    @FXML
    private TextField PasswordField;

    @FXML
    private TextField BirthdayField;

    @FXML
    private TextField EnrolmentField;

    @FXML
    void initialize() {
        RegistButton.setOnAction(event -> {
            addNewOfficer();
        });
     }

    private void addNewOfficer() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String Badge = BadgeField.getText();
        String Surname = SurnameField.getText();
        String Post = PostField.getText();
        String Enrolment = EnrolmentField.getText();
        String Birthday = BirthdayField.getText();
        String password = PasswordField.getText();

        Officer officer = new Officer(Badge, Surname, Post, Enrolment, Birthday, password);

        dbHandler.NewOfficer(officer);
    }
}
