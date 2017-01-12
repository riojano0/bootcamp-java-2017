package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Daniel on 11/01/2017.
 */
public class StateDataSource {

    private static final String TABLE_NAME = "States";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_COUNTRIES_ID = "Countries_id";
    private static final String COLUMN_STATE = "State";
    private static final String COLUMN_STATE_SHORT = "State_short";
    private static final String COLUMN_STATE_AREA = "State_area";
    private static final String COLUMN_CAPITAL = "Capital";
    private DatabaseHelper dbHelper= new DatabaseHelper();
    private Connection con = dbHelper.getCon();

    public void insertState(int Country_id,String nameState, String shortName, double area, String capital) throws SQLException {
        String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s, %s) values (?,?,?,?,?)",
                TABLE_NAME, COLUMN_COUNTRIES_ID, COLUMN_STATE, COLUMN_STATE_SHORT, COLUMN_STATE_AREA ,COLUMN_CAPITAL);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setInt(1, Country_id);
        preparedStmt.setString(2, nameState);
        preparedStmt.setString(3, shortName);
        preparedStmt.setDouble(3, area);
        preparedStmt.setString(3, capital);
        preparedStmt.execute();
    }

    public ResultSet getStateById(int id) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    public ResultSet getStatesByCountryId(int countryId) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s like ?",TABLE_NAME,COLUMN_COUNTRIES_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,countryId);
        return preparedStmt.executeQuery();
    }

    public ResultSet getStateByName(String name) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s like ?",TABLE_NAME,COLUMN_STATE);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1,name);
        return preparedStmt.executeQuery();
    }

    public ResultSet getStateByNameShort(String nameShort) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s like ?",TABLE_NAME,COLUMN_STATE_SHORT);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1,nameShort);
        return preparedStmt.executeQuery();
    }

    public ResultSet getStatesByArea(double area) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_STATE_AREA);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setDouble(1,area);
        return preparedStmt.executeQuery();
    }

    public ResultSet getStateByCapital(String capital) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_CAPITAL);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1,capital);
        return preparedStmt.executeQuery();
    }

    public ResultSet getAllStates() throws SQLException{
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    public StateDataSource() throws SQLException, ClassNotFoundException {
    }
}
