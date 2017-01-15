package com.montivero.bootcamp2017.Config;

/**
 * Created by Daniel on 10/01/2017.
 */
public interface DatabaseInfo {

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DATABASE = "Weather_db";
        String DB_URL = "jdbc:mysql://localhost/"+DATABASE+"?useSSL=false";
        String USER = "Bootcamp";
        String PASS = "123456";


}
