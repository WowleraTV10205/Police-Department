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
import sample.database.DBConnector;
import sample.crates.District;
import sample.openNewScene;

public class Districts {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<District> table;

    @FXML
    private TableColumn<District, String> ID;

    @FXML
    private TableColumn<District, String> Name;

    @FXML
    private TableColumn<District, String> Priority;

    @FXML
    private TableColumn<District, String> Enter_Coordinates;

    @FXML
    private TableColumn<District, String> Exit_Coordinates;

    @FXML
    private Button PatrolsButton;

    @FXML
    private Button StatsButton;

    @FXML
    private Button BoatsButton;

    @FXML
    private Button OfficersButton;

    ObservableList<District> oblist = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        PatrolsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Patrols.fxml");
        });

        StatsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Stats.fxml");
        });

        BoatsButton.setOnAction(event -> {
           new openNewScene("/sample/fxmls/Boats.fxml");
        });

        OfficersButton.setOnAction(event -> {
           new openNewScene("/sample/fxmls/Officers.fxml");
        });

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM district");

            while (rs.next()) {
                oblist.add(new District(rs.getString("ID"), rs.getString("name"), rs.getString("Priority"), rs.getString("Enter_Coordinates"), rs.getString("Exit_Coordinates")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Priority.setCellValueFactory(new PropertyValueFactory<>("Priority"));
        Enter_Coordinates.setCellValueFactory(new PropertyValueFactory<>("Enter_Coordinates"));
        Exit_Coordinates.setCellValueFactory(new PropertyValueFactory<>("Exit_Coordinates"));

        table.setItems(oblist);
    }
}
