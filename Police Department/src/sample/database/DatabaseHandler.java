package sample.database;

import sample.crates.Officer;
import sample.crates.Patrol;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" +dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void NewOfficer(Officer officer) {
        String insert = "INSERT INTO " + Const.OFFICERS_TABLE + "(" +
                Const.OFFICERS_BADGE + "," + Const.OFFICERS_SURNAME + "," +
                Const.OFFICERS_POST + "," + Const.OFFICERS_ENROLMENT + "," +
                Const.OFFICERS_BIRTHDAY + "," + Const.OFFICERS_PASSWORD + ")" +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(insert);
            prST.setString (1,officer.getBadge());
            prST.setString (2,officer.getSurname());
            prST.setString (3,officer.getPost());
            prST.setString (4,officer.getEnrolment());
            prST.setString (5,officer.getBirthday());
            prST.setString (6,officer.getPassword());
            prST.executeUpdate();

            JOptionPane.showMessageDialog(null, "Офицер успешно зарегистрирован!");
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, throwables);
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void NewPatrol(Patrol patrol) {
        String insert = "INSERT INTO " + Const.PATROLS_TABLE + "(" +
                Const.PATROLS_BOAT_NUM + "," + Const.PATROLS_DISTRICT + "," +
                Const.PATROLS_START + "," + Const.PATROLS_INTRUDERS + "," +
                Const.PATROLS_LOSS + "," + Const.PATROLS_REWARD + ")" +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prST = getDbConnection().prepareStatement(insert);
            prST.setString (1,patrol.getBoat_Num());
            prST.setString (2,patrol.getDistrict());
            prST.setString (3,patrol.getStart());
            prST.setString (4,patrol.getIntruders());
            prST.setString (5,patrol.getLoss());
            prST.setString (6,patrol.getReward());
            prST.executeUpdate();

            JOptionPane.showMessageDialog(null, "Информация о патруле успешно добавлена!");
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, throwables);
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getOfficer (Officer officer) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.OFFICERS_TABLE + " WHERE " +
                Const.OFFICERS_BADGE + "=? AND " + Const.OFFICERS_PASSWORD + "=?";

        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST.setString (1,officer.getBadge());
            prST.setString (2,officer.getPassword());

            resSet = prST.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }
}
