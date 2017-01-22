package com.montivero.bootcamp2017.Config;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import javafx.scene.chart.PieChart;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daniel on 13/01/2017.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/spring-config.xml" })
//@ContextConfiguration(locations = { "/spring-config.xml" })
//@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(JUnit4.class)
public class DatabaseHelperTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//    @Autowired
//    private DatabaseHelper databaseHelper;

    private DatabaseHelper databaseHelper = (DatabaseHelper)context.getBean("databaseHelper");

    @Test
    public void getCon() throws Exception {


        Connection con = databaseHelper.getCon();

        assertEquals(true,con != null);
    }

//    @Test
//    public void otherTest() throws Exception {
//
////        System.out.println(databaseHelper.getCon());
//        System.out.println(databaseHelper);
////        Connection con = databaseHelper.getCon();
//
////        assertEquals(true,con != null);
//    }
//
//    @Test
//    public void testSameInstance() throws Exception{
//        DatabaseHelper dbHelper = DatabaseHelper.getInstance();
//        Connection con = dbHelper.getCon();
//
//        DatabaseHelper dbHelper2 = DatabaseHelper.getInstance();
//        Connection con2 = dbHelper2.getCon();
//
//        DatabaseHelper dbHelper3 = DatabaseHelper.getInstance();
//        Connection con3 = dbHelper3.getCon();
//
//        assertEquals(dbHelper,dbHelper2);
//        assertEquals(dbHelper,dbHelper3);
//        assertEquals(dbHelper2,dbHelper3);
//
//        assertEquals(con,con2);
//        assertEquals(con,con3);
//        assertEquals(con2,con3);
//    }
//
//    @Test
//    public void testSelect() throws SQLException, ClassNotFoundException {
//
//        DatabaseHelper dbHelper = DatabaseHelper.getInstance();
//        Connection con = dbHelper.getCon();
//        Statement stmt = con.createStatement();
//        String sqlQuery = "Select \"Test Database\" from Dual";
//        ResultSet result = stmt.executeQuery(sqlQuery);
//        String resultOut="";
//        while(result.next()) {
//            resultOut=result.getString(1);
//        }
//        assertEquals("Test Database",resultOut);
//    }

    /* Test with Mockito
    @Mock
    DatabaseHelper dbHelper;

    @Before
    public void setUp(){
        dbHelper = Mockito.mock(DatabaseHelper.class);
        Connection con = Mockito.mock(Connection.class);

        Mockito.when(dbHelper.getCon()).thenReturn(con);
    }

    @Test
    public void getCon() throws Exception {
        Connection con = dbHelper.getCon();
        assertEquals(true,con != null);
    }

    */

}