package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Builders.ForecastTodayBuilder;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.ForecastToday;
import com.montivero.bootcamp2017.utils.DataSourceUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Daniel on 11/01/2017.
 */
public class ForecastTodayDataSource {
    private static final String TABLE_NAME = "forecast_today";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DATE_DAY = "Date_day";
    private static final String COLUMN_TEMP = "temp";
    @Autowired
    private DatabaseHelper databaseHelper;
    @Autowired
    private DataSourceUtils dataSourceUtils;

    public void insertForecastToday(String date, int temp) throws SQLException {
        String sqlInsert = String.format("Insert into %s(%s,%s) values (?,?)",TABLE_NAME,COLUMN_DATE_DAY,COLUMN_TEMP);
        PreparedStatement preparedStmt = databaseHelper.getCon().prepareStatement(sqlInsert);
        preparedStmt.setString(1, date);
        preparedStmt.setInt(2,temp);
        preparedStmt.execute();
    }


    public void insertForecastToday(ForecastToday fToday) throws SQLException {
        String sqlInsert = String.format("Insert into %s(%s,%s) values (?,?)",TABLE_NAME,COLUMN_DATE_DAY,COLUMN_TEMP);
        PreparedStatement preparedStmt = databaseHelper.getCon().prepareStatement(sqlInsert);
        preparedStmt.setString(1, fToday.getDate());
        preparedStmt.setInt(2, fToday.getTemp());
        preparedStmt.execute();
    }

    public int getIdByForecastToday(ForecastToday fToday) throws SQLException, ClassNotFoundException {
        ResultSet result = getForecastTodayByValues(fToday.getDate(),fToday.getTemp());
        int id;
        if(result.next()){
            id = result.getInt(1);
        }else{
            id=0;
        }
        return id;

    }

    private ResultSet getForecastTodayByValues(String date, int temp) throws SQLException, ClassNotFoundException {
        String sqlScript = String.format("Select * From %s where %s = ? and %s = ?",TABLE_NAME,COLUMN_DATE_DAY,COLUMN_TEMP);
        PreparedStatement preparedStmt = databaseHelper.getCon().prepareStatement(sqlScript);
        preparedStmt.setString(1,date);
        preparedStmt.setInt(2,temp);
        return preparedStmt.executeQuery();
    }

    public ResultSet getForecastTodayById(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dataSourceUtils.prepareStatementCreator(TABLE_NAME, COLUMN_ID);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    public ForecastToday getForecastTodayByIdObject(int id) throws SQLException, ParseException, ClassNotFoundException {
        PreparedStatement preparedStmt = dataSourceUtils.prepareStatementCreator(TABLE_NAME, COLUMN_ID);
        preparedStmt.setInt(1,id);
        ResultSet result = preparedStmt.executeQuery();
        return fillForecastToday(result);
    }

    public ResultSet getAllForecastToday() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = databaseHelper.getCon().prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    public ArrayList<ForecastToday> getAllForecastTodayObjects() throws SQLException, ParseException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = databaseHelper.getCon().prepareStatement(sqlSelect);
        ResultSet result = preparedStmt.executeQuery();
        return fillForecastTodayArray(result);
    }

    private ForecastToday fillForecastToday(ResultSet result) throws SQLException, ParseException {
        ForecastToday fToday;
        if(result.next()){
            fToday = new ForecastTodayBuilder()
                    .temp(result.getInt(COLUMN_TEMP))
                    .date(result.getString(COLUMN_DATE_DAY))
                    .build();
        }else{
            fToday=null;
        }
        return fToday;
    }

    private  ArrayList<ForecastToday> fillForecastTodayArray(ResultSet result) throws SQLException, ParseException {
        ArrayList<ForecastToday> aForecastToday = new ArrayList<ForecastToday>();
        while(result.next()){
            ForecastToday fToday = new ForecastTodayBuilder()
                    .temp(result.getInt(COLUMN_TEMP))
                    .date(result.getString(COLUMN_DATE_DAY))
                    .build();

            aForecastToday.add(fToday);
        }
        return aForecastToday;
    }

    public ForecastTodayDataSource() throws SQLException, ClassNotFoundException {
    }
}
