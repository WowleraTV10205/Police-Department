package sample.controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.crates.AddCheck;
import sample.crates.PatrolCheck;
import sample.database.DBConnector;
import sample.database.DatabaseHandler;

public class PatrolChecks {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<PatrolCheck> table;

    @FXML
    private TableColumn<PatrolCheck, String> ID;

    @FXML
    private TableColumn<PatrolCheck, String> Boat_Num;

    @FXML
    private TableColumn<PatrolCheck, String> District;

    @FXML
    private TableColumn<PatrolCheck, String> Start;

    @FXML
    private TableColumn<PatrolCheck, String> Intruders;

    @FXML
    private Button NewCheckButton;

    @FXML
    private TextField BadgeField;

    @FXML
    private TextField Patrol_IDField;

    ObservableList<PatrolCheck> oblist = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        NewCheckButton.setOnAction(event -> {
            AddNewCheck();
        });

       try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Patrol");

            while (rs.next()) {
                oblist.add(new PatrolCheck(rs.getString("ID"), rs.getString("boat_Num"), rs.getString("district"), rs.getString("start"), rs.getString("intruders")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Boat_Num.setCellValueFactory(new PropertyValueFactory<>("boat_Num"));
        District.setCellValueFactory(new PropertyValueFactory<>("district"));
        Start.setCellValueFactory(new PropertyValueFactory<>("start"));
        Intruders.setCellValueFactory(new PropertyValueFactory<>("intruders"));

        table.setItems(oblist);
    }

    private void AddNewCheck() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String Badge = BadgeField.getText();
        String Patrol_ID = Patrol_IDField.getText();

        AddCheck addcheck = new AddCheck(Badge, Patrol_ID);

        dbHandler.NewCheck(addcheck);
    }
}
