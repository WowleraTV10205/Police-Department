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
import javafx.scene.control.cell.PropertyValueFactory;
import sample.crates.Boat;
import sample.crates.Patrol;
import sample.database.DBConnector;
import sample.openNewScene;

public class Patrols {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Patrol> table;

    @FXML
    private TableColumn<Patrol, String> ID;

    @FXML
    private TableColumn<Patrol, String> Boat_Num;

    @FXML
    private TableColumn<Patrol, String> District;

    @FXML
    private TableColumn<Patrol, String> Start;

    @FXML
    private TableColumn<Patrol, String> Intruders;

    @FXML
    private TableColumn<Patrol, String> Reward;

    @FXML
    private TableColumn<Patrol, String> Loss;

    @FXML
    private Button BoatsButton;

    @FXML
    private Button NewPatrol;

    @FXML
    private Button StatsButton;

    @FXML
    private Button DistrictButton;

    @FXML
    private Button OfficersButton;

    ObservableList<Patrol> oblist = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        NewPatrol.setOnAction(event -> {
            new openNewScene("/sample/fxmls/NewPatrol.fxml");
        });

        BoatsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Boats.fxml");
        });

        StatsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Stats.fxml");
        });

        DistrictButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Districts.fxml");
        });

        OfficersButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Officers.fxml");
        });

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT patrol.Boat_Num, patrol.District, " +
                    "patrol.`Start`, patrol. Intruders, patrol.Intruders * district.priority as Reward, patrol.Loss\n" +
                    "FROM  patrol, district\n" +
                    "WHERE (Patrol.District=district.ID);");

            while (rs.next()) {
                oblist.add(new Patrol(rs.getString("boat_Num"), rs.getString("district"), rs.getString("start"),
                        rs.getString("intruders"),rs.getString("loss"),rs.getString("reward")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Boat_Num.setCellValueFactory(new PropertyValueFactory<>("boat_Num"));
        District.setCellValueFactory(new PropertyValueFactory<>("district"));
        Start.setCellValueFactory(new PropertyValueFactory<>("start"));
        Intruders.setCellValueFactory(new PropertyValueFactory<>("intruders"));
        Loss.setCellValueFactory(new PropertyValueFactory<>("loss"));
        Reward.setCellValueFactory(new PropertyValueFactory<>("reward"));

        table.setItems(oblist);

    }
}
