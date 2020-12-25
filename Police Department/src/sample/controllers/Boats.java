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
import sample.database.DBConnector;
import sample.openNewScene;


public class Boats {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Boat> table;

    @FXML
    private TableColumn<Boat, String> Boat_Num;

    @FXML
    private TableColumn<Boat, String> Mark;

    @FXML
    private TableColumn<Boat, String> Engine_Num;

    @FXML
    private TableColumn<Boat, String> Color;

    @FXML
    private TableColumn<Boat, String> Recorder;

    @FXML
    private Button PatrolsButton;

    @FXML
    private Button NewBoat;

    @FXML
    private Button StatsButton;

    @FXML
    private Button DistrictButton;

    @FXML
    private Button OfficersButton;

    ObservableList<Boat> oblist = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        PatrolsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Patrols.fxml");
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

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM boat");

            while (rs.next()) {
                oblist.add(new Boat(rs.getString("boat_Num"), rs.getString("mark"), rs.getString("engine_Num"), rs.getString("color"), rs.getString("recorder")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Boat_Num.setCellValueFactory(new PropertyValueFactory<>("boat_Num"));
        Mark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        Engine_Num.setCellValueFactory(new PropertyValueFactory<>("engine_Num"));
        Color.setCellValueFactory(new PropertyValueFactory<>("color"));
        Recorder.setCellValueFactory(new PropertyValueFactory<>("recorder"));

        table.setItems(oblist);

    }
}
