package com.montivero.bootcamp2017.utils;

import com.montivero.bootcamp2017.Builders.*;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
//        Wind w = new Wind();
//        w.setSpeed(speed);
//        w.setDirection(direction);

        Wind w = new WindBuilder().speed(speed).direction(direction).build();

        System.out.println(String.format("Wind Speed: %s Direction: %s \n", w.getSpeed(), w.getDirection()));
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

        System.out.println(String.format("Atmosphere Humidity: %s Pressure: %s Rising: %s Visibility: %s \n", a.getHumidity(),a.getPressure(),a.getRising(),a.getVisibility()));
        menu();
    }

    private static void countryConsole() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("\nCountry");
        String name = InputAdapter.InputScanner("Insert the Name: ", "Name no valid", 3, 80);
        String nameShort2 = InputAdapter.InputScanner("Insert short name (2 char):", "Not valid input", 2, 2);
        String nameShort3 = InputAdapter.InputScanner("Insert short name (3 char):", "Not valid input", 3, 3);

        Country c = new CountryBuilder().name(name)
                .shortName2(nameShort2)
                .shortName3(nameShort3)
                .build();

        System.out.println(String.format("Country Name: %s Alpha2: %s Alpha3: %s \n", c.getName(), c.getShort_name_2(), c.getShort_name_3()));
        menu();
    }

    private static void stateConsole() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("\nState");
        System.out.println("\nNote: this Console insert have a Dummy-country and you dont need insert it");

        Country c = new CountryBuilder().name("Dummy-Country")
                .shortName2("dc")
                .shortName3("dmc")
                .build();

//        State s = new State();

        String name = InputAdapter.InputScanner("Insert the Name: ",
                "Name no valid", 3, 80);
        String nameShort2 = InputAdapter.InputScanner("Insert short name (2 char):",
                "Not valid input", 2, 2);
        double area = InputAdapter.InputScannerDouble("Insert the Area: ",
                "Area not valid");
        String capital = InputAdapter.InputScanner("Insert the capital: ",
                "Capital not valid", 3, 80);

        State s = new StateBuilder().country(c)
                .name(name)
                .shortName(nameShort2)
                .area(area)
                .capital(capital)
                .build();

        System.out.println(String.format("State Name: %s Country: %s ShortName: %s Area: %s KMS Capital: %s  \n",
                s.getName(),
                s.getCountry().getName(),
                s.getShort_name(),
                s.getArea(),
                s.getCapital()));

        menu();
    }

    private static void forecastTodayConsole() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("\nForecast Today");
        System.out.println("\nNote: Only insert temp, because the date is this moment");

        int temp = InputAdapter.InputScannerInteger("Insert the Temp: ","Temp not valid");

        Date today = new Date();
        ForecastToday fToday = new ForecastTodayBuilder().date(today).temp(temp).build();

        System.out.println(String.format("Forecast Today Date: %s Temp: %s °C",DateAdapter.dateDeformat(fToday.getDate()),fToday.getTemp()));

        menu();

    }

    private static void forecastExtendedConsole() throws ParseException, SQLException, ClassNotFoundException {

        System.out.println("\nForecast Extended");

        Date date = InputAdapter.InputScannerDate("Insert the Date (ex: dd/mm/yyyy): ", "Date not valid");
        int day = InputAdapter.InputScannerInteger("Insert day number (ex 1-7) :", "Day not valid", 1, 7);
        int tempMin = InputAdapter.InputScannerInteger("Insert MIN temp (Only positive values): ", "Not valid temp");
        int tempMax = InputAdapter.InputScannerInteger("Insert MAX temp (Only positive values): ", "Not valid temp");
        String description = InputAdapter.InputScanner("Insert description of the Forecast: ","Description not valid");

        ForecastExtended fExtended = new ForecastExtendedBuilder()
                .date(date)
                .day(day)
                .tempMin(tempMin)
                .tempMax(tempMax)
                .description(description)
                .build();

        System.out.println(String.format("Forecast Extended Date: %s Day: %s TempMin: %s °C TempMax: %s °C Description: %s",
                DateAdapter.dateDeformat(fExtended.getDate()),
                fExtended.dayToString(),
                fExtended.getTempMin(),
                fExtended.getTempMax(),
                fExtended.getDescription()));

        menu();
    }

    private static void weatherConsole() throws ParseException, SQLException, ClassNotFoundException {
        System.out.println("\nWeather");
        System.out.println("Note: Weather is a big composition Class, that is why have a loot of dummy(the same of tests), only insert the description \n");

        /* Country Dummy */
        Country dummyCountry = new CountryBuilder().name("Dummy-Country")
                .shortName2("dc")
                .shortName3("dmc")
                .build();

        /* State Dummy */
        State dummyState = new StateBuilder()
                .country(dummyCountry)
                .name("Dummy-State")
                .shortName("DumS")
                .area(100)
                .capital("Dummy-Capital")
                .build();

        /* Date for ForecastToday */
        Date dateToday = new Date();

        /* Case of ForecastToday */
        ForecastToday today = new ForecastTodayBuilder().date(dateToday).temp(45).build();

        /*  Cases of ForecastExtended */
        ForecastExtended fExtendedDay01 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
        ForecastExtended fExtendedDay02 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
        ForecastExtended fExtendedDay03 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
        ForecastExtended fExtendedDay04 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
        ForecastExtended fExtendedDay05 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
        ForecastExtended fExtendedDay06 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
        ForecastExtended fExtendedDay07 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
        ForecastExtended fExtendedDay08 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
        ForecastExtended fExtendedDay09 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
        ForecastExtended fExtendedDay10 = new ForecastExtendedBuilder()
                .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();

        /* Array of ForecastExtendes */
        ForecastExtended[] weekExtended = {fExtendedDay01,fExtendedDay02,fExtendedDay03,fExtendedDay04,
                fExtendedDay05,fExtendedDay06,fExtendedDay07,fExtendedDay08,fExtendedDay09,fExtendedDay10};

        /* Case of Wind */
//        Wind wind = new Wind(20,15);
        Wind wind = new WindBuilder().speed(20).direction(15).build();

        /* Case of Atmosphere */
        Atmosphere atmosphere = new AtmosphereBuilder()
                .humidity(10)
                .pressure(20.2)
                .visibility(200)
                .rising(15)
                .build();

        /* Create and Test Weather */
        Weather w = new Weather();
        String description = InputAdapter.InputScanner("Insert description: ","Error in description");
        w.setState(dummyState);
        w.setToday(today);
        w.setWeek(weekExtended);
        w.setAtmosphere(atmosphere);
        w.setWind(wind);
        w.setDescription(description);

        String forecastExtendedOut = "";
        for (int i = 0; w.getWeek().length > i; i++){
            forecastExtendedOut+=w.getWeek()[i].forecastExtendedToString()+"\n";
        }

        String out = String.format("Weather State:\n%s \n\nToday Forecast:\n%s \n\nAtmosphere :\n%s \n\nWind :\n%s"+
                        "\n\nDescription:\n%s \n\nForecast Extended:\n%s ",
                            w.getState().getName(),
                            w.getToday().forecastTodayToString(),
                            w.getAtmosphere().atmosphereToString(),
                            w.getWind().windToString(),
                            w.getDescription(),
                            forecastExtendedOut
                            );

        System.out.println(out);

        menu();
    }

    private static void databaseConsole() throws SQLException, ClassNotFoundException, ParseException {

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
    }

    public static void menu() throws ParseException, SQLException, ClassNotFoundException {
        int selection;

        System.out.println("Choose a Class and check");
        System.out.println("-------------------------\n");
        System.out.println("1 - Insert Country by Console");
        System.out.println("2 - Insert State by Console ");
        System.out.println("3 - Insert Wind by Console");
        System.out.println("4 - Insert Atmosphere by Console");
        System.out.println("5 - Insert Forecast Today by Console");
        System.out.println("6 - Insert Forecast Extended by Console");
        System.out.println("7 - Insert Weather by Console");
        System.out.println("8 - Check if Database Conection Work");
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
//            case 8:
//                databaseConsole();break;
        }
    }
}
