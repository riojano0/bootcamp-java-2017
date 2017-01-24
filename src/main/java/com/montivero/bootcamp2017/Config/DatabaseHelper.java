package com.montivero.bootcamp2017.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Daniel on 10/01/2017.
 */

public class DatabaseHelper implements DatabaseInfo {

        private Connection con;

        public Connection getCon(){
            try {
                Class.forName(JDBC_DRIVER);
                con = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return con;
        }

}
