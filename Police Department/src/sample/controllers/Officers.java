package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.database.DBConnector;
import sample.crates.Officer;
import sample.openNewScene;

public class Officers {

    @FXML
    private TableView<Officer> table;

    @FXML
    private TableColumn<Officer, String> Badge;

    @FXML
    private TableColumn<Officer, String> Surname;

    @FXML
    private TableColumn<Officer, String> Post;

    @FXML
    private TableColumn<Officer, String> Birthday;

    @FXML
    private TableColumn<Officer, String> Enrolment;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button PatrolsButton;

    @FXML
    private Button NewOfficer;

    @FXML
    private Button StatsButton;

    @FXML
    private Button BoatsButton;

    @FXML
    private Button DistrictsButton;

    ObservableList<Officer> oblist = FXCollections.observableArrayList();

    @FXML
    void initialize() {
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

        PatrolsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Patrols.fxml");
        });

        StatsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Stats.fxml");
        });

        BoatsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Boats.fxml");
        });

        DistrictsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Districts.fxml");
        });

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM officer");

            while (rs.next()) {
                oblist.add(new Officer(rs.getString("badge"), rs.getString("surname"), rs.getString("post"), rs.getString("enrolment"), rs.getString("birthday"), rs.getString("password")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Badge.setCellValueFactory(new PropertyValueFactory<>("badge"));
        Surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        Post.setCellValueFactory(new PropertyValueFactory<>("post"));
        Enrolment.setCellValueFactory(new PropertyValueFactory<>("enrolment"));
        Birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        table.setItems(oblist);
    }

}