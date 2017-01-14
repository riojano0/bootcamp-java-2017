package com.montivero.bootcamp2017.app;

import com.montivero.bootcamp2017.Builders.WindBuilder;
import com.montivero.bootcamp2017.Domains.Wind;
import com.montivero.bootcamp2017.utils.MenuConsole;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Daniel on 10/01/2017.
 */
public class Run {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {

//        MenuConsole.menu();

//        Wind w = WindBuilder.speed(20).direction(30).build();
//        Wind w = new Wind.WindBuilder.speed(20).direction(30).build();


        Wind w = new WindBuilder().speed(20).direction(30).build();

        System.out.println(w.getSpeed()+" "+w.getDirection());

    }
}
