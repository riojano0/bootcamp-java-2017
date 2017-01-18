package com.montivero.bootcamp2017.utils;

import com.montivero.bootcamp2017.Builders.*;
import com.montivero.bootcamp2017.Domains.*;

import java.text.ParseException;

/**
 * Created by Daniel on 17/01/2017.
 */
public class Dummy {

    private Dummy() throws ParseException {}

    static final Country DUMMY_COUNTRY = new CountryBuilder()
            .name("Dummy country")
            .shortName2("dc")
            .shortName3("dmc")
            .build();

    static final State DUMMY_STATE = new StateBuilder()
            .country(Dummy.DUMMY_COUNTRY)
            .name("Dummy State")
            .shortName("DumS")
            .area(100)
            .capital("Dummy Capital")
            .build();

    static final Wind DUMMY_WIND = new WindBuilder()
            .speed(20)
            .direction(15)
            .build();

    static final Atmosphere DUMMY_ATMOSPHERE = new AtmosphereBuilder()
                .humidity(10)
                .pressure(20.2)
                .visibility(200)
                .rising(15)
                .build();


    static final ForecastToday DUMMY_FORECAST_TODAY = new ForecastTodayBuilder()
                .date("17/06/2017")
                .temp(45).
                build();

    private static final ForecastExtended DUMMY_FORECAST_EXTENDED_DAY_01 = new ForecastExtendedBuilder()
        .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
    private static final  ForecastExtended DUMMY_FORECAST_EXTENDED_DAY_02 = new ForecastExtendedBuilder()
            .date("22/06/2016").day(2).tempMin(21).tempMax(30).description("More Cloudy").build();
    private static final ForecastExtended DUMMY_FORECAST_EXTENDED_DAY_03 = new ForecastExtendedBuilder()
            .date("23/06/2016").day(3).tempMin(22).tempMax(30).description("The master of the Cloudy").build();
    private static final ForecastExtended DUMMY_FORECAST_EXTENDED_DAY_04 = new ForecastExtendedBuilder()
            .date("24/06/2016").day(4).tempMin(23).tempMax(30).description("Cloudy more or less").build();
    private static final ForecastExtended DUMMY_FORECAST_EXTENDED_DAY_05 = new ForecastExtendedBuilder()
            .date("25/06/2016").day(5).tempMin(24).tempMax(30).description("Rain").build();
    private static final ForecastExtended DUMMY_FORECAST_EXTENDED_DAY_06 = new ForecastExtendedBuilder()
            .date("26/06/2016").day(6).tempMin(25).tempMax(30).description("The Rain non stop").build();
    private static final ForecastExtended DUMMY_FORECAST_EXTENDED_DAY_07 = new ForecastExtendedBuilder()
            .date("27/06/2016").day(7).tempMin(26).tempMax(30).description("Cloudy").build();
    private static final ForecastExtended DUMMY_FORECAST_EXTENDED_DAY_08 = new ForecastExtendedBuilder()
            .date("28/06/2016").day(1).tempMin(27).tempMax(30).description("Cloudy").build();
    private static final ForecastExtended DUMMY_FORECAST_EXTENDED_DAY_09 = new ForecastExtendedBuilder()
            .date("29/06/2016").day(2).tempMin(28).tempMax(30).description("The hell").build();
    private static final ForecastExtended DUMMY_FORECAST_EXTENDED_DAY_10 = new ForecastExtendedBuilder()
            .date("30/06/2016").day(3).tempMin(29).tempMax(30).description("Cloudy").build();

    static final ForecastExtended[] DUMMY_FORECAST_EXTENDED_ARRAY = {
            DUMMY_FORECAST_EXTENDED_DAY_01, DUMMY_FORECAST_EXTENDED_DAY_02, DUMMY_FORECAST_EXTENDED_DAY_03,
            DUMMY_FORECAST_EXTENDED_DAY_04, DUMMY_FORECAST_EXTENDED_DAY_05, DUMMY_FORECAST_EXTENDED_DAY_06,
            DUMMY_FORECAST_EXTENDED_DAY_07, DUMMY_FORECAST_EXTENDED_DAY_08, DUMMY_FORECAST_EXTENDED_DAY_09,
            DUMMY_FORECAST_EXTENDED_DAY_10};



}
