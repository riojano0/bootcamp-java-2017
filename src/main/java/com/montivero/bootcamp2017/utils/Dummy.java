package com.montivero.bootcamp2017.utils;

import com.montivero.bootcamp2017.Builders.*;
import com.montivero.bootcamp2017.Domains.*;

import java.text.ParseException;

/**
 * Created by Daniel on 17/01/2017.
 */
class Dummy {

    private Dummy() throws ParseException {}

    static final Country dummyCountry = new CountryBuilder()
            .name("Dummy country")
            .shortName2("dc")
            .shortName3("dmc")
            .build();

    static final State dummyState = new StateBuilder()
            .country(Dummy.dummyCountry)
            .name("Dummy State")
            .shortName("DumS")
            .area(100)
            .capital("Dummy Capital")
            .build();

    static final Wind dummyWind = new WindBuilder()
            .speed(20)
            .direction(15)
            .build();

    static final Atmosphere dummyAtmosphere = new AtmosphereBuilder()
                .humidity(10)
                .pressure(20.2)
                .visibility(200)
                .rising(15)
                .build();


    static final ForecastToday dummyForecastToday = new ForecastTodayBuilder()
                .date("17/06/2017")
                .temp(45).
                build();

    private static final ForecastExtended dummyForecastExtendedDay01 = new ForecastExtendedBuilder()
        .date("21/06/2016").day(1).tempMin(20).tempMax(30).description("Cloudy").build();
    private static final  ForecastExtended dummyForecastExtendedDay02 = new ForecastExtendedBuilder()
            .date("22/06/2016").day(2).tempMin(21).tempMax(30).description("Cloudy").build();
    private static final ForecastExtended dummyForecastExtendedDay03 = new ForecastExtendedBuilder()
            .date("23/06/2016").day(3).tempMin(22).tempMax(30).description("Cloudy").build();
    private static final ForecastExtended dummyForecastExtendedDay04 = new ForecastExtendedBuilder()
            .date("24/06/2016").day(4).tempMin(23).tempMax(30).description("Cloudy").build();
    private static final ForecastExtended dummyForecastExtendedDay05 = new ForecastExtendedBuilder()
            .date("25/06/2016").day(5).tempMin(24).tempMax(30).description("Cloudy").build();
    private static final ForecastExtended dummyForecastExtendedDay06 = new ForecastExtendedBuilder()
            .date("26/06/2016").day(6).tempMin(25).tempMax(30).description("Cloudy").build();
    private static final ForecastExtended dummyForecastExtendedDay07 = new ForecastExtendedBuilder()
            .date("27/06/2016").day(7).tempMin(26).tempMax(30).description("Cloudy").build();
    private static final ForecastExtended dummyForecastExtendedDay08 = new ForecastExtendedBuilder()
            .date("28/06/2016").day(1).tempMin(27).tempMax(30).description("Cloudy").build();
    private static final ForecastExtended dummyForecastExtendedDay09 = new ForecastExtendedBuilder()
            .date("29/06/2016").day(2).tempMin(28).tempMax(30).description("Cloudy").build();
    private static final ForecastExtended dummyForecastExtendedDay10 = new ForecastExtendedBuilder()
            .date("30/06/2016").day(3).tempMin(29).tempMax(30).description("Cloudy").build();

    static final ForecastExtended[] dummyForecastExtendedArray = {
            dummyForecastExtendedDay01, dummyForecastExtendedDay02, dummyForecastExtendedDay03, dummyForecastExtendedDay04,
            dummyForecastExtendedDay05, dummyForecastExtendedDay06, dummyForecastExtendedDay07, dummyForecastExtendedDay08, dummyForecastExtendedDay09, dummyForecastExtendedDay10};


}
