package com.montivero.bootcamp2017.utils;

import com.montivero.bootcamp2017.Config.DatabaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Daniel on 17/01/2017.
 */
public class DataSourceUtils {

    private DataSourceUtils() throws SQLException, ClassNotFoundException {}

    public static PreparedStatement prepareStatementCreator(String tableName, String columnObjective)
            throws SQLException, ClassNotFoundException {
        DatabaseHelper dbHelper= DatabaseHelper.getInstance();
        Connection con = dbHelper.getCon();
        String sqlScript =  String.format("Select * from %s where %s = ?",tableName,columnObjective);
        return con.prepareStatement(sqlScript);
    }

}
