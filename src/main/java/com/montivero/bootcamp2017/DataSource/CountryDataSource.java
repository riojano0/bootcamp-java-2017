package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Builders.CountryBuilder;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.Country;
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
public class CountryDataSource {

    private static final String TABLE_NAME = "Countries";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_COUNTRY = "Country";
    private static final String COLUMN_COUNTRY_CODE_2 = "Country_code_2";
    private static final String COLUMN_COUNTRY_CODE_3 = "Country_code_3";
    @Autowired
    private DatabaseHelper dbHelper;

    public void insertCountry(Country country) throws SQLException {
        try {
            String sqlInsert = String.format("Insert into %s(%s,%s, %s) values (?,?,?)",
                    TABLE_NAME, COLUMN_COUNTRY, COLUMN_COUNTRY_CODE_2, COLUMN_COUNTRY_CODE_3);
            PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlInsert);
            preparedStmt.setString(1, country.getName());
            preparedStmt.setString(2, country.getShortName2());
            preparedStmt.setString(3, country.getShortName3());
            preparedStmt.execute();
            System.out.println(String.format("Insert Country with Name: %s Alpha2: %s Alpha3: %s to database",
                    country.getName(), country.getShortName2(), country.getShortName3()));
        }
        catch (MySQLIntegrityConstraintViolationException E){
            System.out.println("Already exists this Country in the Database");
        }
    }

    public  void insertCountry(String Country, String short_name2, String short_name3) throws SQLException {
        String sqlInsert = String.format("Insert into %s(%s,%s, %s) values (?,?,?)", TABLE_NAME, COLUMN_COUNTRY, COLUMN_COUNTRY_CODE_2, COLUMN_COUNTRY_CODE_3);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlInsert);
        preparedStmt.setString(1, Country);
        preparedStmt.setString(2, short_name2);
        preparedStmt.setString(3, short_name3);
        preparedStmt.execute();
    }

    public ArrayList<Country> getAllCountriesObjects() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        ResultSet result = preparedStmt.executeQuery();
        return fillCountries(result);
    }

    public int getIdbyCountry(Country country) throws SQLException, ClassNotFoundException {
        ResultSet result = getCountryByName(country.getName());
        int id;
        if(result.next()){
            id = result.getInt(1);
        }else{
            id=0;
        }
        return id;
    }

    public ResultSet getAllCountries() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    public ResultSet getCountryByName(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_COUNTRY);
        preparedStmt.setString(1,name);
        return preparedStmt.executeQuery();
    }

    public Country getCountryByNameObject(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_COUNTRY);
        preparedStmt.setString(1,name);
        ResultSet result = preparedStmt.executeQuery();
        return fillCountry(result);
    }

    public ResultSet getCountryByShortName2(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_COUNTRY_CODE_2);
        preparedStmt.setString(1, name);
        return preparedStmt.executeQuery();
    }

    public Country getCountryByShortName2Object(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_COUNTRY_CODE_2);
        preparedStmt.setString(1, name);
        return fillCountry(preparedStmt.executeQuery());
    }

    public ResultSet getCountryByShortName3(String name) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_COUNTRY_CODE_3);
        preparedStmt.setString(1, name);
        return preparedStmt.executeQuery();
    }

    public ResultSet getCountryById(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_ID);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    public Country getCountryByIdObject(int id) throws SQLException, ClassNotFoundException {
        Country c;
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_ID);
        preparedStmt.setInt(1,id);
        ResultSet result = preparedStmt.executeQuery();
        c = fillCountry(result);
        return c;
    }

    private Country fillCountry(ResultSet result) throws SQLException {
        Country c;
        if(result.next()){
            c = new CountryBuilder()
                    .name(result.getString(COLUMN_COUNTRY))
                    .shortName2(result.getString(COLUMN_COUNTRY_CODE_2))
                    .shortName3(result.getString(COLUMN_COUNTRY_CODE_3))
                    .build();
        }else{
            c=null;
        }
        return c;
    }

    private ArrayList<Country> fillCountries(ResultSet result) throws SQLException{
        ArrayList<Country> aCountries = new ArrayList<Country>();
        while(result.next()){
            Country w = new CountryBuilder()
                    .name(result.getString(COLUMN_COUNTRY))
                    .shortName2(result.getString(COLUMN_COUNTRY_CODE_2))
                    .shortName3(result.getString(COLUMN_COUNTRY_CODE_3))
                    .build();
            aCountries.add(w);
        }
        return aCountries;
    }

    public CountryDataSource() throws SQLException, ClassNotFoundException {
    }
}
