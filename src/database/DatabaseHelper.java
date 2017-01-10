package database;

import classes.State;

import java.sql.*;


/**
 * Created by Daniel on 10/01/2017.
 */
public class DatabaseHelper implements DatabaseInfo{

        private Connection con;

        public DatabaseHelper() throws ClassNotFoundException, SQLException {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL,USER,PASS);
        }

        public Connection getCon() {
        return con;
    }


}
