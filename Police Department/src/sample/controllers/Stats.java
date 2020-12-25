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
import sample.crates.Stat;
import sample.database.DBConnector;
import sample.openNewScene;

public class Stats {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Stat> table;

    @FXML
    private TableColumn<Stat, String> Badge;

    @FXML
    private TableColumn<Stat, String> Surname;

    @FXML
    private TableColumn<Stat, String> Post;

    @FXML
    private TableColumn<Stat, String> Intruders;

    @FXML
    private TableColumn<Stat, String> Patrols;

    @FXML
    private Button PatrolsButton;

    @FXML
    private Button BoatsButton;

    @FXML
    private Button DistrictButton;

    @FXML
    private Button OfficersButton;

    ObservableList<Stat> oblist = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        PatrolsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Patrols.fxml");
        });

        BoatsButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Boats.fxml");
        });

        DistrictButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Districts.fxml");
        });

        OfficersButton.setOnAction(event -> {
            new openNewScene("/sample/fxmls/Officers.fxml");
        });

        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT Officer.Badge, Officer.Surname, Officer.Post, SUM(`patrol result`.Intruders) AS Intruders, COUNT(Patrol.ID) AS Patrols\n" +
                    "FROM stats, Officer, Patrol_Check, Patrol, `patrol result`\n" +
                    "WHERE (Stats.Officer_Badge = Officer.Badge AND Officer.Badge = Patrol_Check.Officer_Badge AND Patrol_Check.patrol_ID=Patrol.ID AND Patrol.ID = `patrol result`.patrol_id)\n" +
                    "GROUP BY Officer.Badge;");

            while (rs.next()) {
                oblist.add(new Stat(rs.getString("badge"), rs.getString("surname"), rs.getString("post"), rs.getString("intruders"), rs.getString("patrols")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Badge.setCellValueFactory(new PropertyValueFactory<>("badge"));
        Surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        Post.setCellValueFactory(new PropertyValueFactory<>("post"));
        Intruders.setCellValueFactory(new PropertyValueFactory<>("intruders"));
        Patrols.setCellValueFactory(new PropertyValueFactory<>("patrols"));

        table.setItems(oblist);
    }
}
