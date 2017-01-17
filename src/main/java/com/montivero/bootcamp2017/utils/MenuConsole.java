package com.montivero.bootcamp2017.utils;

import com.montivero.bootcamp2017.Builders.*;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.DataSource.CountryDataSource;
import com.montivero.bootcamp2017.Domains.*;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Daniel on 10/01/2017.
 */
public class MenuConsole {

    private MenuConsole() {
    }

    private static void windConsole() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("\nWind");

        int speed = InputAdapter.InputScannerInteger("Insert the Speed: ", "Speed not valid");
        int direction = InputAdapter.InputScannerInteger("Insert the Direction: ", "Direction not valid");
        Wind w = new WindBuilder().speed(speed).direction(direction).build();

        System.out.println("");
        System.out.println(w.windToString());
        System.out.println("");
        menu();
    }

    private static void atmosphereConsole() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("\nAtmosphere");
        int humidity = InputAdapter.InputScannerInteger("Insert the Humidity: ","Humidity not valid");
        double pressure = InputAdapter.InputScannerDouble("Insert the Pressure: ", "Pressure not valid");
        int rising = InputAdapter.InputScannerInteger("Insert the Rising: ", "Rising not valid");
        double visibility = InputAdapter.InputScannerDouble("Insert the Visibility: ","Visibility not valid");
        Atmosphere a = new AtmosphereBuilder()
                .humidity(humidity)
                .pressure(pressure)
                .visibility(visibility)
                .rising(rising)
                .build();

        System.out.println("");
        System.out.println(a.atmosphereToString());
        System.out.println("");
        menu();
    }

    private static void countryConsole() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("\nCountry");
        String name = InputAdapter.InputScanner("Insert the Name: ", "Name no valid", 3, 80);
        String nameShort2 = InputAdapter.InputScanner("Insert short name (2 char):", "Not valid input", 2, 2);
        String nameShort3 = InputAdapter.InputScanner("Insert short name (3 char):", "Not valid input", 3, 3);

        Country c = new CountryBuilder()
                .name(name)
                .shortName2(nameShort2)
                .shortName3(nameShort3)
                .build();

        System.out.println("");
        System.out.println(c.countryToString());
        System.out.println("");
        menu();
    }

    private static void stateConsole() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("\nState");
        System.out.println("\nNote: this Console insert have a Dummy country and you dont need insert it");

        String name = InputAdapter.InputScanner("Insert the Name: ",
                "Name no valid", 3, 80);
        String nameShort2 = InputAdapter.InputScanner("Insert short name (2 char):",
                "Not valid input", 2, 2);
        double area = InputAdapter.InputScannerDouble("Insert the Area: ",
                "Area not valid");
        String capital = InputAdapter.InputScanner("Insert the capital: ",
                "Capital not valid", 3, 80);

        State s = new StateBuilder()
                .country(Dummy.dummyCountry)
                .name(name)
                .shortName(nameShort2)
                .area(area)
                .capital(capital)
                .build();

        System.out.println("");
        System.out.println(s.stateToString());
        System.out.println("");

        menu();
    }

    private static void forecastTodayConsole() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("\nForecast Today");
        System.out.println("\nNote: Only insert temp, because the date is this moment");

        int temp = InputAdapter.InputScannerInteger("Insert the Temp: ","Temp not valid");

        Date today = new Date();
        ForecastToday fToday = new ForecastTodayBuilder().date(today).temp(temp).build();

        System.out.println("");
        System.out.println(fToday.forecastTodayToString());
        System.out.println("");

        menu();

    }

    private static void forecastExtendedConsole() throws ParseException, SQLException, ClassNotFoundException {

        System.out.println("\nForecast Extended");

        Date date = InputAdapter.InputScannerDate("Insert the Date (ex: dd/mm/yyyy): ", "Date not valid");
        int day = InputAdapter.InputScannerInteger("Insert day number (ex 1 is Sunday - 7 is Saturday) :", "Day not valid", 1, 7);
        int tempMin = InputAdapter.InputScannerInteger("Insert MIN temp : ", "Not valid temp");
        int tempMax = InputAdapter.InputScannerInteger("Insert MAX temp : ", "Not valid temp");
        String description = InputAdapter.InputScanner("Insert description of the Forecast: ","Description not valid");

        ForecastExtended fExtended = new ForecastExtendedBuilder()
                .date(date)
                .day(day)
                .tempMin(tempMin)
                .tempMax(tempMax)
                .description(description)
                .build();

        System.out.println("");
        System.out.println(fExtended.forecastExtendedToString());
        System.out.println("");

        menu();
    }

    private static void weatherConsole() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("\nWeather");
        System.out.println("Note: Weather is a big composition Class, that is why have a loot of dummy(the same of tests), only insert the description \n");

        /* Create and Test Weather */
        String description = InputAdapter.InputScanner("Insert description: ","Error in description");
        Weather w = new WeatherBuilder()
                .state(Dummy.dummyState)
                .today(Dummy.dummyForecastToday)
                .week(Dummy.dummyForecastExtendedArray)
                .wind(Dummy.dummyWind)
                .atmosphere(Dummy.dummyAtmosphere)
                .description(description)
                .build();

        System.out.println("");
        System.out.println(w.weatherToString());
        System.out.println("");

        menu();
    }

    private static void databaseConsole() throws SQLException, ClassNotFoundException, ParseException {
        try{
        System.out.println("\nDatabase Connection");
        System.out.println("Note: This only check if work and try to do a -Select 'Works!' from Dual- \n");

        DatabaseHelper dbHelper = DatabaseHelper.getInstance();
        Connection con = dbHelper.getCon();
        Statement stmt = con.createStatement();
        String sqlQuery = "Select \"Works!\" from Dual";
        ResultSet result = stmt.executeQuery(sqlQuery);
        while(result.next()) {
            System.out.println(result.getString(1)+"\n");
        }

        menu();
        }catch (CommunicationsException E){
            System.out.println("Database is OFFLINE\n");
            menu();
        }
    }

    private static void insertCountryByConsole() throws SQLException, ClassNotFoundException, ParseException {
        try{
            System.out.println("\nPlease fill the fields of the Country ");

            String name = InputAdapter.InputScanner("Insert the Name: ", "Name no valid", 3, 80);
            String nameShort2 = InputAdapter.InputScanner("Insert short name (2 char):", "Not valid input", 2, 2);
            String nameShort3 = InputAdapter.InputScanner("Insert short name (3 char):", "Not valid input", 3, 3);

            Country c = new CountryBuilder().name(name)
                    .shortName2(nameShort2)
                    .shortName3(nameShort3)
                    .build();

            CountryDataSource cData = new CountryDataSource();
            cData.insertCountry(c);

            menu();
        }catch (CommunicationsException E){
            System.out.println("Database is OFFLINE\n");
            menu();
        }
    }

    private static void getAllCountriesByConsole() throws SQLException, ClassNotFoundException, ParseException {
        try{
            System.out.println("\nAll Countries in Database:");

            CountryDataSource cData = new CountryDataSource();
            ArrayList<Country> aCountries= cData.getAllCountriesObjects();
            for (Country aCountry : aCountries) {
                System.out.println(aCountry.countryToString());
            }
            System.out.println("");
            menu();
        }catch (CommunicationsException E){
            System.out.println("Database is OFFLINE\n");
            menu();
        }
    }

    public static void menu() throws ParseException, SQLException, ClassNotFoundException {
        int selection;

        System.out.println("Choose a Class and check");
        System.out.println("-------------------------\n");
        System.out.println("1 - Country by Console");
        System.out.println("2 - State by Console ");
        System.out.println("3 - Wind by Console");
        System.out.println("4 - Atmosphere by Console");
        System.out.println("5 - Forecast Today by Console");
        System.out.println("6 - Forecast Extended by Console");
        System.out.println("7 - Weather by Console");
        System.out.println("8 - Check if Database Connection Work");
        System.out.println("9 - Insert to Database a Country");
        System.out.println("10 - Show all Countries in Database");
        System.out.println("0 - Quit\n");

        selection = InputAdapter.InputScannerInteger("Choice: ", "Choice not valid");

        switch (selection) {
            case 0:
                break;
            case 1:
                countryConsole();break;
            case 2:
                stateConsole();break;
            case 3:
                windConsole();break;
            case 4:
                atmosphereConsole();break;
            case 5:
                forecastTodayConsole();break;
            case 6:
                forecastExtendedConsole();break;
            case 7:
                weatherConsole();break;
            case 8:
                databaseConsole();break;
            case 9:
                insertCountryByConsole();break;
            case 10:
                getAllCountriesByConsole();break;
        }
    }
}
