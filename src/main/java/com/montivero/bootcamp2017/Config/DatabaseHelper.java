package com.montivero.bootcamp2017.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Daniel on 10/01/2017.
 */
public class DatabaseHelper implements DatabaseInfo{

        private Connection con;

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
