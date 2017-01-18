package com.montivero.bootcamp2017.app;

import com.montivero.bootcamp2017.Builders.CountryBuilder;
import com.montivero.bootcamp2017.Builders.ForecastExtendedBuilder;
import com.montivero.bootcamp2017.Builders.ForecastTodayBuilder;
import com.montivero.bootcamp2017.Builders.StateBuilder;
import com.montivero.bootcamp2017.DataSource.*;
import com.montivero.bootcamp2017.Domains.*;
import com.montivero.bootcamp2017.utils.Dummy;
import com.montivero.bootcamp2017.utils.MenuConsole;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Daniel on 10/01/2017.
 */
public class Run {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {

       MenuConsole.menu();

    }
}
