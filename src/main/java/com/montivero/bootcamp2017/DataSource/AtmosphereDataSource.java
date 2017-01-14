package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Config.DatabaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Daniel on 11/01/2017.
 */
public class AtmosphereDataSource {

    private static final String TABLE_NAME = "Atmospheres";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_HUMIDITY = "Humidity";
    private static final String COLUMN_PRESSURE = "Pressure";
    private static final String COLUMN_VISIBILITY = "Visibility";
    private static final String COLUMN_RISING = "rising";
    private DatabaseHelper dbHelper= DatabaseHelper.getInstance();
    private Connection con = dbHelper.getCon();

    public void insertAtmosphere(int humidity,double pressure, double visibility, int rising) throws SQLException {
        String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s) values (?,?,?,?)",
                TABLE_NAME, COLUMN_HUMIDITY, COLUMN_PRESSURE, COLUMN_VISIBILITY, COLUMN_RISING);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setInt(1, humidity);
        preparedStmt.setDouble(2, pressure);
        preparedStmt.setDouble(3, visibility);
        preparedStmt.setInt(3, rising);
        preparedStmt.execute();
    }

    public ResultSet getAtmosphereById(int id) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    public ResultSet getAllAtmospheres() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }


    public AtmosphereDataSource() throws SQLException, ClassNotFoundException {
    }

}
