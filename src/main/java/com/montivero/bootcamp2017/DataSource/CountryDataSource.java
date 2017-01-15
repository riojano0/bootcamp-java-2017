package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Builders.CountryBuilder;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.Country;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
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
    private DatabaseHelper dbHelper= DatabaseHelper.getInstance();
    private Connection con = dbHelper.getCon();

    public void insertCountry(Country country) throws SQLException {

        try {
            String sqlInsert = String.format("Insert into %s(%s,%s, %s) values (?,?,?)",
                    TABLE_NAME, COLUMN_COUNTRY, COLUMN_COUNTRY_CODE_2, COLUMN_COUNTRY_CODE_3);
            PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
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

    public ArrayList<Country> getAllCountries() throws SQLException {

        ArrayList<Country> aCountries = new ArrayList<Country>();
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        ResultSet result = preparedStmt.executeQuery();

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



//
//    public  void insertCountry(String Country, String short_name2, String short_name3) throws SQLException {
//        String sqlInsert = String.format("Insert into %s(%s,%s, %s) values (?,?,?)", TABLE_NAME, COLUMN_COUNTRY, COLUMN_COUNTRY_CODE_2, COLUMN_COUNTRY_CODE_3);
//        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
//        preparedStmt.setString(1, Country);
//        preparedStmt.setString(2, short_name2);
//        preparedStmt.setString(3, short_name3);
//        preparedStmt.execute();
//    }

    public ResultSet getCountryByName(String name) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s is like ?",TABLE_NAME,COLUMN_COUNTRY);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1,name);
        return preparedStmt.executeQuery();
    }

    public ResultSet getCountryByShort_name2(String name) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s is like ?",TABLE_NAME,COLUMN_COUNTRY_CODE_2);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1, name);
        return preparedStmt.executeQuery();
    }

    public ResultSet getCountryByShort_name3(String name) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s is like ?",TABLE_NAME,COLUMN_COUNTRY_CODE_3);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1, name);
        return preparedStmt.executeQuery();
    }

    public ResultSet getCountryById(int id) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

//    public ResultSet getAllCountries() throws SQLException {
//        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
//        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
//        ResultSet result = preparedStmt.executeQuery();
//        return result;
//    }

    public CountryDataSource() throws SQLException, ClassNotFoundException {
    }
}
