package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Builders.WindBuilder;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.Wind;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel on 14/01/2017.
 */
public class WindDataSourceTest {

    @Test
    public void testRoute() throws Exception {
        cleanTable();

        Wind w = new WindBuilder().speed(10).direction(50).build();
        WindDataSource wData = new WindDataSource();
        wData.insertWind(w);

        assertNotNull(wData.getWindById(1));
        assertTrue(!wData.getAllWinds().isEmpty());

        wData.deleteWindById(1);
        assertTrue(wData.getAllWinds().isEmpty());

        cleanTable();
    }

    public void cleanTable() throws SQLException, ClassNotFoundException {
        DatabaseHelper dbHelper = DatabaseHelper.getInstance();
        Connection con = dbHelper.getCon();
        Statement stmt = con.createStatement();
        String sqlQuery = "Truncate Winds";
        stmt.executeQuery(sqlQuery);
    }

}