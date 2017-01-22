package com.montivero.bootcamp2017.utils;

import com.montivero.bootcamp2017.Config.DatabaseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Daniel on 17/01/2017.
 */
public class DataSourceUtils {
//
////    private DataSourceUtils() throws SQLException, ClassNotFoundException {}
//    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//
//    @Autowired
////    private static DatabaseHelper dbHelper = context.getBean("databaseHelper");
//    private static DatabaseHelper dbHelper=context.getBean("databaseHelper");


    private static DatabaseHelper dbHelper;
    @Autowired
    private DatabaseHelper databaseHelper;

    @PostConstruct
    public void init() {
        DataSourceUtils.dbHelper = databaseHelper;
    }

    public static PreparedStatement prepareStatementCreator( String tableName, String columnObjective)
            throws SQLException, ClassNotFoundException {
            String sqlScript =  String.format("Select * from %s where %s = ?",tableName,columnObjective);
            return dbHelper.getCon().prepareStatement(sqlScript);
    }

}
