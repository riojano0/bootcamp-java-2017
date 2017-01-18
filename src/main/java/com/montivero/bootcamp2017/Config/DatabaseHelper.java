package com.montivero.bootcamp2017.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Daniel on 10/01/2017.
 */
public class DatabaseHelper implements DatabaseInfo{

        private static DatabaseHelper instance;
        private static Connection con;

        private DatabaseHelper() {}

        public static DatabaseHelper getInstance(){
            if (instance != null) {
                return instance;
            }
            else{
              instance = new DatabaseHelper();
              return instance;
            }
        }


        public Connection getCon(){
            try {
                if (con != null) {
                    return con;
                } else {
                    Class.forName(JDBC_DRIVER);
                    con = DriverManager.getConnection(DB_URL, USER, PASS);
                    return con;
                }
            }catch (ClassNotFoundException E){
                System.out.println(E.toString());
                return null;
            }catch (SQLException E){
                System.out.println(E.toString());
                return null;
            }
        }

}
