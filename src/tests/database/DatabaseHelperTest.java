package database;

import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 11/01/2017.
 */
public class DatabaseHelperTest {


    @Test
    public void getCon() throws Exception {

        DatabaseHelper dbHelper = new DatabaseHelper();
        Connection con = dbHelper.getCon();
        assertEquals(true,con !=null);
    }

    @Test
    public void testSelect() throws SQLException, ClassNotFoundException {

        DatabaseHelper dbHelper = new DatabaseHelper();
        Connection con = dbHelper.getCon();
        Statement stmt = con.createStatement();
        String sqlQuery = "Select \"Test Database\" from Dual";
        ResultSet result = stmt.executeQuery(sqlQuery);
        String resultOut="";
        while(result.next()) {
            resultOut=result.getString(1);
        }
        assertEquals("Test Database",resultOut);
    }

    @Test
    public void testSelect2() throws SQLException, ClassNotFoundException {

        DatabaseHelper dbHelper = new DatabaseHelper();
        Connection con = dbHelper.getCon();
        String sqlSelect = String.format("Select * from %s where %s like ?","countries", "country");
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setString(1,"Checka");
        ResultSet result = preparedStmt.executeQuery();
        String resultOut="";
        while(result.next()) {
            resultOut=result.getString(1);
        }
        assertEquals("",resultOut);
    }



}