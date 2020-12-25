package sample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector extends Configs{

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/police","root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
}
