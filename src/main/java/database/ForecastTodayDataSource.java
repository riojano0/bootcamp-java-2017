package database;

import utils.DateAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Daniel on 11/01/2017.
 */
public class ForecastTodayDataSource {
    private static final String TABLE_NAME = "forecast_today";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DATE_DAY = "Date_day";
    private static final String COLUMN_TEMP = "temp";
    private DatabaseHelper dbHelper= new DatabaseHelper();
    private Connection con = dbHelper.getCon();

    public void insertForecastToday(Date date, int temp) throws SQLException {
        String sqlInsert = String.format("Insert into %s(%s,%s) values (?,?)",TABLE_NAME,COLUMN_DATE_DAY,COLUMN_TEMP);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setDate(1, DateAdapter.dateSql(date));
        preparedStmt.setInt(2,temp);
        preparedStmt.execute();
    }

    public void insertForecastToday(java.sql.Date date, int temp) throws SQLException {
        String sqlInsert = String.format("Insert into %s(%s,%s) values (?,?)",TABLE_NAME,COLUMN_DATE_DAY,COLUMN_TEMP);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setDate(1, date);
        preparedStmt.setInt(2,temp);
        preparedStmt.execute();

    }

    public ResultSet getForecastTodayById(int id) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    public ResultSet getAllForecastToday() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    public ForecastTodayDataSource() throws SQLException, ClassNotFoundException {
    }
}
