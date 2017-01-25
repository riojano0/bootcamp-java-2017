package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Builders.StateBuilder;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.Country;
import com.montivero.bootcamp2017.Domains.State;
import com.montivero.bootcamp2017.utils.DataSourceUtils;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    @Autowired
    private DatabaseHelper dbHelper;
    @Autowired
    private DataSourceUtils dataSourceUtil;
    @Autowired
    CountryDataSource cData;

    public void insertState(State state) throws SQLException {
        try {
            String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s, %s) values (?,?,?,?,?)",
                    TABLE_NAME, COLUMN_COUNTRIES_ID, COLUMN_STATE, COLUMN_STATE_SHORT, COLUMN_STATE_AREA, COLUMN_CAPITAL);
            PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlInsert);

//            CountryDataSource cData = new CountryDataSource();
            if (cData.getIdbyCountry(state.getCountry())!=0){
                preparedStmt.setInt(1,cData.getIdbyCountry(state.getCountry()));
            }else
            {
                 cData.insertCountry(state.getCountry());
                 preparedStmt.setInt(1,cData.getIdbyCountry(state.getCountry()));
            }
            preparedStmt.setString(2, state.getName());
            preparedStmt.setString(3, state.getShortName());
            preparedStmt.setDouble(4, state.getArea());
            preparedStmt.setString(5, state.getCapital());
            preparedStmt.execute();

        } catch (MySQLIntegrityConstraintViolationException E) {
            System.out.println("Already exists this Country in the Database");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertState(int Country_id, String nameState, String shortName, double area, String capital) throws SQLException {
        try {
            String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s, %s) values (?,?,?,?,?)",
                    TABLE_NAME, COLUMN_COUNTRIES_ID, COLUMN_STATE, COLUMN_STATE_SHORT, COLUMN_STATE_AREA, COLUMN_CAPITAL);
            PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlInsert);
            preparedStmt.setInt(1, Country_id);
            preparedStmt.setString(2, nameState);
            preparedStmt.setString(3, shortName);
            preparedStmt.setDouble(4, area);
            preparedStmt.setString(5, capital);
            preparedStmt.execute();

        } catch (MySQLIntegrityConstraintViolationException E) {
            System.out.println("Already exists this Country in the Database");
        }
    }

    public ResultSet getStateById(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dataSourceUtil.prepareStatementCreator(TABLE_NAME, COLUMN_ID);
        preparedStmt.setInt(1, id);
        return preparedStmt.executeQuery();
    }

    public int getIdbyState(State state) throws SQLException, ClassNotFoundException {
        ResultSet result = getStateByName(state.getName());
        int id;
        if(result.next()){
            id = result.getInt(1);
        }else{
            id=0;
        }
        return id;
    }

    public State getStateByIdObject(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dataSourceUtil.prepareStatementCreator(TABLE_NAME, COLUMN_ID);
        preparedStmt.setInt(1, id);
        ResultSet result = preparedStmt.executeQuery();
        return fillState(result);
    }

    public ResultSet getStatesByCountryId(int countryId) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dataSourceUtil.prepareStatementCreator(TABLE_NAME, COLUMN_COUNTRIES_ID);
        preparedStmt.setInt(1, countryId);
        return preparedStmt.executeQuery();
    }

    public ArrayList<State> getStatesByCountryIdObjects(int countryId) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dataSourceUtil.prepareStatementCreator(TABLE_NAME, COLUMN_COUNTRIES_ID);
        preparedStmt.setInt(1, countryId);
        ResultSet result = preparedStmt.executeQuery();
        return fillStates(result);

    }

    public ResultSet getStateByName(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dataSourceUtil.prepareStatementCreator(TABLE_NAME,COLUMN_STATE);
        preparedStmt.setString(1, name);
        return preparedStmt.executeQuery();
    }

    public State getStateByNameObject(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dataSourceUtil.prepareStatementCreator(TABLE_NAME,COLUMN_STATE);
        preparedStmt.setString(1, name);
        ResultSet result = preparedStmt.executeQuery();
        System.out.println(name);
        return fillState(result);
    }

    public ResultSet getStateByNameShort(String nameShort) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dataSourceUtil.prepareStatementCreator(TABLE_NAME,COLUMN_STATE_SHORT);
        preparedStmt.setString(1, nameShort);
        return preparedStmt.executeQuery();
    }

    public State getStateByNameShortObject(String nameShort) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME, COLUMN_STATE_SHORT);
        preparedStmt.setString(1, nameShort);
        ResultSet result = preparedStmt.executeQuery();
        return fillState(result);
    }

    public ResultSet getStatesByArea(double area) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME, COLUMN_STATE_AREA);
        preparedStmt.setDouble(1, area);
        return preparedStmt.executeQuery();
    }

    public ResultSet getStateByCapital(String capital) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME, COLUMN_CAPITAL);
        preparedStmt.setString(1, capital);
        return preparedStmt.executeQuery();
    }

    public State getStateByCapitalObject(String capital) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME, COLUMN_CAPITAL);
        preparedStmt.setString(1, capital);
        return fillState(preparedStmt.executeQuery());
    }

    public ResultSet getAllStates() throws SQLException {
        String sqlSelect = String.format("Select * from %s", TABLE_NAME);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    public ArrayList<State> getAllStatesObjects() throws SQLException, ClassNotFoundException {
        String sqlSelect = String.format("Select * from %s", TABLE_NAME);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        ResultSet result = preparedStmt.executeQuery();
        return fillStates(result);
    }

    private State fillState(ResultSet result) throws SQLException, ClassNotFoundException {
        State state;
        if (result.next()) {
            Country country;
//            CountryDataSource cData = new CountryDataSource();
            country = cData.getCountryByIdObject(result.getInt(COLUMN_COUNTRIES_ID));
            state = new StateBuilder()
                    .country(country)
                    .area(result.getDouble(COLUMN_STATE_AREA))
                    .capital(result.getString(COLUMN_CAPITAL))
                    .shortName(result.getString(COLUMN_STATE_SHORT))
                    .name(result.getString(COLUMN_STATE))
                    .build();
        } else {
            state = null;
        }
        return state;
    }

    private ArrayList<State> fillStates(ResultSet result) throws SQLException, ClassNotFoundException {
        ArrayList<State> aStates = new ArrayList<State>();
        Country country = null;
        while (result.next()) {
//            if (country == null) {
//                CountryDataSource cData = new CountryDataSource();
                country = cData.getCountryByIdObject(result.getInt(COLUMN_COUNTRIES_ID));
//            }
            State state = new StateBuilder()
                    .country(country)
                    .area(result.getDouble(COLUMN_STATE_AREA))
                    .capital(result.getString(COLUMN_CAPITAL))
                    .shortName(result.getString(COLUMN_STATE_SHORT))
                    .name(result.getString(COLUMN_STATE))
                    .build();

            aStates.add(state);
        }
            return aStates;

    }

    public StateDataSource() throws SQLException, ClassNotFoundException {
        }
    }

