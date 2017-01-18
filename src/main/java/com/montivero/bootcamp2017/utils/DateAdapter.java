package com.montivero.bootcamp2017.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Daniel on 09/01/2017.
 */
public class DateAdapter {
    /* class create only for no use Calendar */
    private DateAdapter(){}

    public static Date dateFormat(String dateString){
        try{
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

            return fmt.parse(dateString);
        }catch (ParseException E){
            System.out.println(E.toString());

            return null;
        }
    }

    public static Date dateFormat(java.sql.Date dateSql)  {
        try{
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            return fmt.parse(dateSql.toString());
        }catch (ParseException E){
            System.out.println(E.toString());
            return null;
        }
    }

    public static String dateDeformat(Date date){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        return fmt.format(date);
    }

    public static java.sql.Date dateSql(Date dateIn){
        java.sql.Date dateOut = new java.sql.Date(dateIn.getTime());
        return dateOut;
    }

    public static java.sql.Date dateSql(String dateIn) throws ParseException {
        Date dateInOut = dateFormat(dateIn);
        java.sql.Date dateOut = new java.sql.Date(dateInOut.getTime());
        return dateOut;
    }
}
