package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Builders.AtmosphereBuilder;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.Atmosphere;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    @Autowired
    private DatabaseHelper dbHelper;

    public void insertAtmosphere(int humidity,double pressure, double visibility, int rising) throws SQLException {
        String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s) values (?,?,?,?)",
                TABLE_NAME, COLUMN_HUMIDITY, COLUMN_PRESSURE, COLUMN_VISIBILITY, COLUMN_RISING);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlInsert);
        preparedStmt.setInt(1, humidity);
        preparedStmt.setDouble(2, pressure);
        preparedStmt.setDouble(3, visibility);
        preparedStmt.setInt(3, rising);
        preparedStmt.execute();
    }

    public void insertAtmosphere(Atmosphere atmosphere) throws SQLException {
        String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s) values (?,?,?,?)",
                TABLE_NAME, COLUMN_HUMIDITY, COLUMN_PRESSURE, COLUMN_VISIBILITY, COLUMN_RISING);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlInsert);
        preparedStmt.setInt(1, atmosphere.getHumidity());
        preparedStmt.setDouble(2, atmosphere.getPressure());
        preparedStmt.setDouble(3, atmosphere.getVisibility());
        preparedStmt.setInt(4, atmosphere.getRising());
        preparedStmt.execute();
    }

    public int getIdByAtmosphere(Atmosphere atmosphere) throws SQLException {
        ResultSet result = getAtmosphereByValues(atmosphere.getHumidity(),
                                                atmosphere.getPressure(),
                                                atmosphere.getRising(),
                                                atmosphere.getVisibility());
        int id;
        if(result.next()){
            id = result.getInt(1);
        }else{
            id=0;
        }
        return id;

    }

    private ResultSet getAtmosphereByValues(int humidity, double pressure, int rising, double visibility) throws SQLException {
        String sqlScript = String.format("Select * from %s where %s = ? and %s = ? and %s = ? and %s = ?",
                TABLE_NAME, COLUMN_HUMIDITY, COLUMN_PRESSURE, COLUMN_RISING, COLUMN_VISIBILITY);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlScript);
        preparedStmt.setInt(1, humidity);
        preparedStmt.setDouble(2,pressure);
        preparedStmt.setInt(3, rising);
        preparedStmt.setDouble(4, visibility);
        return preparedStmt.executeQuery();
    }

    public ResultSet getAtmosphereById(int id) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    public Atmosphere getAtmosphereByIdObject(int id) throws SQLException{
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        System.out.println(dbHelper.getCon());
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);
        ResultSet result = preparedStmt.executeQuery();
        return fillAtmosphere(result);
    }

    public ResultSet getAllAtmospheres() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    public ArrayList<Atmosphere> getAllAtmospheresObjects() throws SQLException{
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        ResultSet result = preparedStmt.executeQuery();
        return fillAtmospheres(result);
    }

    private Atmosphere fillAtmosphere(ResultSet result) throws SQLException {
        Atmosphere atms;
        if(result.next()){
            atms = new AtmosphereBuilder()
                    .humidity(result.getInt(COLUMN_HUMIDITY))
                    .pressure(result.getDouble(COLUMN_PRESSURE))
                    .rising(result.getInt(COLUMN_RISING))
                    .visibility(result.getDouble(COLUMN_VISIBILITY))
                    .build();
        }else{
            atms=null;
        }
        return atms;
    }

    private ArrayList<Atmosphere> fillAtmospheres(ResultSet result) throws SQLException{
        ArrayList<Atmosphere> aAtms = new ArrayList<Atmosphere>();
        while(result.next()){
            Atmosphere a = new AtmosphereBuilder()
                    .humidity(result.getInt(COLUMN_HUMIDITY))
                    .pressure(result.getDouble(COLUMN_PRESSURE))
                    .rising(result.getInt(COLUMN_RISING))
                    .visibility(result.getDouble(COLUMN_VISIBILITY))
                    .build();
            aAtms.add(a);
        }
        return aAtms;

    }

    public AtmosphereDataSource() throws SQLException, ClassNotFoundException {
    }

}
