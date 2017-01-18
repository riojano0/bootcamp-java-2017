package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Builders.ForecastExtendedBuilder;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.ForecastExtended;
import com.montivero.bootcamp2017.utils.DataSourceUtils;
import com.montivero.bootcamp2017.utils.DateAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;


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
        days = new HashMap<String,Integer>();
        days.put("sunday",1);
        days.put("monday",2);
        days.put("tuesday",3);
        days.put("wednesday",4);
        days.put("thursday",5);
        days.put("friday",6);
        days.put("saturday",7);
    }
    private DatabaseHelper dbHelper= DatabaseHelper.getInstance();
    private Connection con = dbHelper.getCon();

    public void insertForecastExtended(int id, Object date, Object day, int tempMin, int tempMax, String description) throws SQLException, ParseException {
        java.sql.Date dateSql;
        int dayId;
        dateSql = (date instanceof Date)? DateAdapter.dateSql((Date)date):DateAdapter.dateSql((String)date);
        dayId = (day instanceof String)? days.get(((String) day).toLowerCase()):(Integer)day;

        String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s, %s, %s) values (?, ?,?,?,?,?)",
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

    public int getIdByForecastExtendedArray(ForecastExtended[] fExtendedArray) throws SQLException {
        ResultSet result = getResultForecastExtendedByArray(fExtendedArray);
        int id;
        if(result.next()){
            id=result.getInt(1);
        }else{
            id=0;
        }
        return id;
    }


    private ResultSet getResultForecastExtendedByArray(ForecastExtended[] fExtendedArray) throws SQLException {

        String[] datesValues = new String[10];
        String dates = "('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
        Integer[] tempMinValues = new Integer[10];
        String tempMin = "(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)";
        Integer[] tempMaxValues = new Integer[10];
        String tempMax = "(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)";
        String[] descriptionValues = new String[10];
        String description = "('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
        int count = 0;
        for(ForecastExtended fExtend:fExtendedArray){
            datesValues[count]=fExtend.getSqlDate().toString();
            tempMinValues[count]=fExtend.getTempMin();
            tempMaxValues[count]=fExtend.getTempMax();
            descriptionValues[count]=fExtend.getDescription();
            count++;
        }
        String datesList=String.format(dates, (Object[]) datesValues);
        String tempMinList=String.format(tempMin, (Object[]) tempMinValues);
        String tempMaxList=String.format(tempMax, (Object[]) tempMaxValues);
        String descriptionList=String.format(description, (Object[]) descriptionValues);
        String sqlScript = String.format("Select * from %1s where "+
                                         "%2s in %3s "+
                                         "and %4s in %5s "+
                                         "and %6s in %7s "+
                                         "and %8s in %9s",
                                         TABLE_NAME,
                                        COLUMN_DATE_DAY,datesList,
                                        COLUMN_TEMP_MIN,tempMinList,
                                        COLUMN_TEMP_MAX,tempMaxList,
                                        COLUMN_DESCRIPTION,descriptionList);

        PreparedStatement preparetSmtm = con.prepareStatement(sqlScript);
        return preparetSmtm.executeQuery();

        }

    public ResultSet getForecastExtendedById(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_ID);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    public ForecastExtended[] getForecastExtendedByIdObjects(int id) throws SQLException,
            ClassNotFoundException, ParseException {

        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_ID);
        preparedStmt.setInt(1,id);
        ResultSet result = preparedStmt.executeQuery();
        return fillForecastExtendedArray(result);

    }

    public ResultSet getForecastExtendedByDaysId(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_DAYS_ID);
        preparedStmt.setInt(1,id);

        return preparedStmt.executeQuery();
    }

    public ResultSet getForecastExtendedByDaysName(String day) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_DAYS_ID);
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

    public ForecastExtended[] getForecastExtendedByBetweenDateDaysObjects(String dateBeg, String dateEnd) throws SQLException, ParseException {
        String dateFormat = "%Y-%m-%d";
        java.sql.Date dateSqlBeg = DateAdapter.dateSql(dateBeg);
        java.sql.Date dateSqlEnd = DateAdapter.dateSql(dateEnd);
        String sqlSelect = String.format("Select * from %s where Date_format(%s, ?) between ? and ?",TABLE_NAME,COLUMN_DATE_DAY);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1,dateFormat);
        preparedStmt.setDate(2,dateSqlBeg);
        preparedStmt.setDate(3,dateSqlEnd);
        ResultSet result = preparedStmt.executeQuery();
        return fillForecastExtendedArray(result);
    }

    public ResultSet getAllForecastExtended() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    private ForecastExtended[] fillForecastExtendedArray(ResultSet result) throws SQLException, ParseException {
        ForecastExtended[] aForecastExtended = new ForecastExtended[10];
        int count= 0;
        while (result.next()){
            ForecastExtended fExtended = new ForecastExtendedBuilder()
                    .date(result.getDate(COLUMN_DATE_DAY))
                    .day(result.getInt(COLUMN_DAYS_ID))
                    .tempMin(result.getInt(COLUMN_TEMP_MIN))
                    .tempMax(result.getInt(COLUMN_TEMP_MAX))
                    .description(result.getString(COLUMN_DESCRIPTION))
                    .build();

            aForecastExtended[count]=fExtended;
            count++;
        }

        return aForecastExtended;
    }

    public ForecastExtendedDataSource() throws SQLException, ClassNotFoundException {
    }
}
