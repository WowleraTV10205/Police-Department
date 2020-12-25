package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;
import sample.animations.shake;
import sample.crates.Officer;
import sample.openNewScene;


import javax.swing.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button NewOfficer;

    @FXML
    private TextField BadgeField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button LoginButton;

    @FXML
    void initialize() {

        LoginButton.setOnAction(event -> {
            String loginText = BadgeField.getText().trim();
            String loginPassword = PasswordField.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals(""))
                loginOfficer (loginText, loginPassword);
            else
                JOptionPane.showMessageDialog(null, "Логин или пароль не введены!");
        });

        NewOfficer.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxmls/NewOfficer.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage ();
            stage.setScene (new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginOfficer(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Officer officer =new Officer();
        officer.setBadge(loginText);
        officer.setPassword(loginPassword);
        ResultSet result = dbHandler.getOfficer(officer);

        int counter = 0;

        while(true) {
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }

        if (counter >=1) {
            new openNewScene("/sample/fxmls/Officers.fxml");
        } else {
            shake officerLoginAnim = new shake (BadgeField);
            shake officerPasswordAnim = new shake (PasswordField);
            officerLoginAnim.playAnim();
            officerPasswordAnim.playAnim();
            BadgeField.setStyle("-fx-text-inner-color: red;");
            PasswordField.setStyle("-fx-text-inner-color: red;");
        }

    }

}



