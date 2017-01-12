package database;

import utils.DateAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Daniel on 11/01/2017.
 */
public class ForecastExtendedDataSource {
    private static final String TABLE_NAME = "forecast_extended";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DATE_DAY = "Date_day";
    private static final String COLUMN_DAYS_ID = "Days_id";
    private static final String COLUMN_TEMP_MIN = "Temp_min";
    private static final String COLUMN_TEMP_MAX = "Temp_max";
    private static final String COLUMN_DESCRIPTION= "Description";
    private static final HashMap<String,Integer> days;
    static {
        days = new HashMap<>();
        days.put("sunday",1);
        days.put("monday",2);
        days.put("tuesday",3);
        days.put("wednesday",4);
        days.put("thursday",5);
        days.put("friday",6);
        days.put("saturday",7);
    }
    private DatabaseHelper dbHelper= new DatabaseHelper();
    private Connection con = dbHelper.getCon();

    public void insertForecastExtended(int id, Object date, Object day, int tempMin, int tempMax, String description) throws SQLException, ParseException {
        java.sql.Date dateSql;
        int dayId;

        dateSql = (date instanceof Date)? DateAdapter.dateSql((Date)date):DateAdapter.dateSql((String)date);
        dayId = (day instanceof String)? days.get(((String) day).toLowerCase()):(int)day;

        String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s, %s) values (?, ?,?,?,?,?)",
                TABLE_NAME,COLUMN_ID,COLUMN_DATE_DAY,COLUMN_DAYS_ID,COLUMN_TEMP_MIN,COLUMN_TEMP_MAX,COLUMN_DESCRIPTION);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setInt(1,id);
        preparedStmt.setDate(2,dateSql);
        preparedStmt.setInt(3,dayId);
        preparedStmt.setInt(4,tempMin);
        preparedStmt.setInt(5,tempMax);
        preparedStmt.setString(6,description);

        preparedStmt.execute();

    }

    public ResultSet getForecastExtendedByDaysId(int id) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_DAYS_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);

        return preparedStmt.executeQuery();
    }

    public ResultSet getForecastExtendedByDaysName(String day) throws SQLException {

        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_DAYS_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,days.get(day.toLowerCase()));

        return preparedStmt.executeQuery();
    }

    public ResultSet getForecastExtendedByDateDay(String date) throws SQLException, ParseException {
        String dateFormat = "%Y-%m-%d";
        java.sql.Date dateSql = DateAdapter.dateSql(date);
        String sqlSelect = String.format("Select * from %s where Date_format(%s, ?)=?",TABLE_NAME,COLUMN_DATE_DAY);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1,dateFormat);
        preparedStmt.setDate(2,dateSql);

        return preparedStmt.executeQuery();
    }

    public ResultSet getForecastExtendedByBetweenDateDays(String dateBeg, String dateEnd) throws SQLException, ParseException {
        String dateFormat = "%Y-%m-%d";
        java.sql.Date dateSqlBeg = DateAdapter.dateSql(dateBeg);
        java.sql.Date dateSqlEnd = DateAdapter.dateSql(dateEnd);
        String sqlSelect = String.format("Select * from %s where Date_format(%s, ?) between ? and ?",TABLE_NAME,COLUMN_DATE_DAY);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1,dateFormat);
        preparedStmt.setDate(2,dateSqlBeg);
        preparedStmt.setDate(3,dateSqlEnd);

        return preparedStmt.executeQuery();
    }

    public ResultSet getForecastExtendedById(int id) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }


    public ResultSet getAllForecastExtended() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    public ForecastExtendedDataSource() throws SQLException, ClassNotFoundException {
    }
}
