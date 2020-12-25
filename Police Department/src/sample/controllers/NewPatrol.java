package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.crates.Patrol;
import sample.database.DatabaseHandler;

public class NewPatrol {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddPatrol;

    @FXML
    private TextField Boat_NumField;

    @FXML
    private TextField DistrictField;

    @FXML
    private TextField IntrudersField;

    @FXML
    private TextField LossField;

    @FXML
    private TextField StartField;

    @FXML
    void initialize() {
        AddPatrol.setOnAction(event -> {
            addNewPatrol();
        });
    }

    private void addNewPatrol() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String Boat_Num = Boat_NumField.getText();
        String District = DistrictField.getText();
        String Start = StartField.getText();
        String Intruders = IntrudersField.getText();
        String Loss = LossField.getText();
        String Reward = "NULL";

        Patrol patrol = new Patrol(Boat_Num, District, Start, Intruders, Loss, Reward);

        dbHandler.NewPatrol(patrol);
    }
}

