package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Builders.WeatherBuilder;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.*;
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
public class WeatherDataSource {
    private static final String TABLE_NAME = "Weather";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_STATES_ID = "States_id";
    private static final String COLUMN_FORECAST_TODAY_ID = "forecast_today_id";
    private static final String COLUMN_FORECAST_EXTENDED_ID = "forecast_extended_id";
    private static final String COLUMN_WINDS_ID = "Winds_id";
    private static final String COLUMN_ATMOSPHERES_ID = "Atmospheres_id";
    private static final String COLUMN_DESCRIPTION = "Description";
    @Autowired
    private DatabaseHelper dbHelper;
    @Autowired
    private AtmosphereDataSource atmosphereData;
    @Autowired
    private StateDataSource stateData;
    @Autowired
    private ForecastTodayDataSource forecastTodayData;
    @Autowired
    private ForecastExtendedDataSource forecastExtendedData;
    @Autowired
    private WindDataSource windData;

    @Autowired
    private DataSourceUtils dataSourceUtil;


    public void insertWeather(int stateId,int forecastTodayId, int forecastExtendedId, int windId, int atmId,
                              String description) throws SQLException {

        String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s, %s, %s) values (?,?,?,?,?,?)",
                TABLE_NAME,COLUMN_STATES_ID,COLUMN_FORECAST_TODAY_ID,COLUMN_FORECAST_EXTENDED_ID,COLUMN_WINDS_ID,
                COLUMN_ATMOSPHERES_ID, COLUMN_DESCRIPTION);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlInsert);
        preparedStmt.setInt(1,stateId);
        preparedStmt.setInt(2,forecastTodayId);
        preparedStmt.setInt(3,forecastExtendedId);
        preparedStmt.setInt(4,windId);
        preparedStmt.setInt(5,atmId);
        preparedStmt.setString(6,description);

        preparedStmt.execute();

    }

    public void insertWeather(Weather weather) throws SQLException, ClassNotFoundException {
        StateDataSource stateData = new StateDataSource();
        ForecastTodayDataSource fTodayData = new ForecastTodayDataSource();
        ForecastExtendedDataSource fExtendedData = new ForecastExtendedDataSource();
        WindDataSource windData = new WindDataSource();
        AtmosphereDataSource atmosphereData = new AtmosphereDataSource();

        String sqlInsert = String.format("Insert into %s(%s,%s, %s, %s, %s, %s) values (?,?,?,?,?,?)",
                TABLE_NAME,COLUMN_STATES_ID,COLUMN_FORECAST_TODAY_ID,COLUMN_FORECAST_EXTENDED_ID,
                COLUMN_WINDS_ID, COLUMN_ATMOSPHERES_ID, COLUMN_DESCRIPTION);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlInsert);

        if (stateData.getIdbyState(weather.getState())!=0){
            preparedStmt.setInt(1,stateData.getIdbyState(weather.getState()));
        }else
        {
            stateData.insertState(weather.getState());
            preparedStmt.setInt(1,stateData.getIdbyState(weather.getState()));
        }


        if (fTodayData.getIdByForecastToday(weather.getToday())!=0){
            preparedStmt.setInt(2,fTodayData.getIdByForecastToday(weather.getToday()));
        }else
        {
            fTodayData.insertForecastToday(weather.getToday());
            preparedStmt.setInt(2,fTodayData.getIdByForecastToday(weather.getToday()));
        }


        if (windData.getIdByWind(weather.getWind())!=0){
            preparedStmt.setInt(4,windData.getIdByWind(weather.getWind()));
        }else
        {
            windData.insertWind(weather.getWind());
            preparedStmt.setInt(4,windData.getIdByWind(weather.getWind()));
        }

        if (atmosphereData.getIdByAtmosphere(weather.getAtmosphere())!=0){
            preparedStmt.setInt(5,atmosphereData.getIdByAtmosphere(weather.getAtmosphere()));
        }else
        {
            atmosphereData.insertAtmosphere(weather.getAtmosphere());
            preparedStmt.setInt(5,atmosphereData.getIdByAtmosphere(weather.getAtmosphere()));
        }

//        preparedStmt.setInt(1,stateData.getIdbyState(weather.getState()));
//        preparedStmt.setInt(2,fTodayData.getIdByForecastToday(weather.getToday()));
        preparedStmt.setInt(3,fExtendedData.getIdByForecastExtendedArray(weather.getWeek()));
//        preparedStmt.setInt(4,windData.getIdByWind(weather.getWind()));
//        preparedStmt.setInt(5,atmosphereData.getIdByAtmosphere(weather.getAtmosphere()));
        preparedStmt.setString(6,weather.getDescription());

        preparedStmt.execute();

    }

    public ResultSet getWeatherById(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dataSourceUtil.prepareStatementCreator(TABLE_NAME,COLUMN_ID);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    public Weather getWeatherByIdObject(int id) throws SQLException, ClassNotFoundException, ParseException {
        PreparedStatement preparedStmt = dataSourceUtil.prepareStatementCreator(TABLE_NAME,COLUMN_ID);
        preparedStmt.setInt(1,id);
        ResultSet result = preparedStmt.executeQuery();

        Weather weather;
        if(result.next()){
            State state = stateData.getStateByIdObject(result.getInt(COLUMN_STATES_ID));
            ForecastToday fToday = forecastTodayData.getForecastTodayByIdObject(result.getInt(COLUMN_FORECAST_TODAY_ID));
            ForecastExtended[] fExtended = forecastExtendedData.getForecastExtendedByIdObjects(result.getInt(COLUMN_FORECAST_EXTENDED_ID));
            Wind wind = windData.getWindByIdObject(result.getInt(COLUMN_WINDS_ID)) ;
            Atmosphere atmosphere = atmosphereData.getAtmosphereByIdObject(result.getInt(COLUMN_ATMOSPHERES_ID));

            weather = new WeatherBuilder()
                    .state(state)
                    .today(fToday)
                    .week(fExtended)
                    .wind(wind)
                    .atmosphere(atmosphere)
                    .description(result.getString(COLUMN_DESCRIPTION))
                    .build();
        }else{
            weather=null;
        }
        return weather;
    }

    public ArrayList<Weather> getAllWeathersObjects() throws SQLException, ClassNotFoundException, ParseException{
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        ResultSet result = preparedStmt.executeQuery();

        ArrayList<Weather> aWeathers= new ArrayList<Weather>();
        while(result.next()){
            State state = stateData.getStateByIdObject(result.getInt(COLUMN_STATES_ID));
            ForecastToday fToday = forecastTodayData.getForecastTodayByIdObject(result.getInt(COLUMN_FORECAST_TODAY_ID));
            ForecastExtended[] fExtended = forecastExtendedData.getForecastExtendedByIdObjects(result.getInt(COLUMN_FORECAST_EXTENDED_ID));
            Wind wind = windData.getWindByIdObject(result.getInt(COLUMN_WINDS_ID)) ;
            Atmosphere atmosphere = atmosphereData.getAtmosphereByIdObject(result.getInt(COLUMN_ATMOSPHERES_ID));

            Weather weather = new WeatherBuilder()
                    .state(state)
                    .today(fToday)
                    .week(fExtended)
                    .wind(wind)
                    .atmosphere(atmosphere)
                    .description(result.getString(COLUMN_DESCRIPTION))
                    .build();

            aWeathers.add(weather);

        }
        return aWeathers;
    }

    public ResultSet getWeatherByStateName(String stateName) throws SQLException {
        String tableForeign = "states";
        String valueForeign = "State";
        String sqlSelect = String.format("Select W.* from %s W join %s S on W.%s=S.id where S.%s like ?",
                TABLE_NAME,tableForeign,COLUMN_STATES_ID, valueForeign);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        preparedStmt.setString(1,stateName);
        return preparedStmt.executeQuery();
    }

    public Weather getWeatherByStateNameObject(String stateName) throws SQLException, ClassNotFoundException, ParseException {
        String tableForeign = "states";
        String valueForeign = "State";
        String sqlSelect = String.format("Select W.* from %s W join %s S on W.%s=S.id where S.%s like ?",
                TABLE_NAME,tableForeign,COLUMN_STATES_ID, valueForeign);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        preparedStmt.setString(1,stateName);
        System.out.println(stateName);
        System.out.println(preparedStmt);
        ResultSet result = preparedStmt.executeQuery();
        Weather weather=null;
        if(result.next()){
            State state = stateData.getStateByIdObject(result.getInt(COLUMN_STATES_ID));
            ForecastToday fToday = forecastTodayData.getForecastTodayByIdObject(result.getInt(COLUMN_FORECAST_TODAY_ID));
            ForecastExtended[] fExtended = forecastExtendedData.getForecastExtendedByIdObjects(result.getInt(COLUMN_FORECAST_EXTENDED_ID));
            Wind wind = windData.getWindByIdObject(result.getInt(COLUMN_WINDS_ID)) ;
            Atmosphere atmosphere = atmosphereData.getAtmosphereByIdObject(result.getInt(COLUMN_ATMOSPHERES_ID));

            weather = new WeatherBuilder()
                    .state(state)
                    .today(fToday)
                    .week(fExtended)
                    .wind(wind)
                    .atmosphere(atmosphere)
                    .description(result.getString(COLUMN_DESCRIPTION))
                    .build();
        }

        return weather;

    }

    public ResultSet getWeatherByStateId(int stateId) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_STATES_ID);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        preparedStmt.setInt(1,stateId);
        return preparedStmt.executeQuery();
    }

    public ResultSet getAllWeathers() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = dbHelper.getCon().prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    public WeatherDataSource() throws SQLException, ClassNotFoundException {
    }
}
