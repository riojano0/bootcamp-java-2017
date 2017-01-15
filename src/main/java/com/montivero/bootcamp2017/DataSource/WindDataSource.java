package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Builders.WindBuilder;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.Wind;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Daniel on 10/01/2017.
 */
public class WindDataSource {

    private static final String TABLE_NAME = "Winds";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SPEED = "Speed";
    private static final String COLUMN_DIRECTION = "Direction";
    private DatabaseHelper dbHelper= DatabaseHelper.getInstance();
    private Connection con = dbHelper.getCon();

    public void insertWind(Wind w) throws SQLException {

        String sqlInsert = String.format("Insert into %s(%s,%s) values (?,?)",TABLE_NAME,COLUMN_SPEED,COLUMN_DIRECTION);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setInt(1,w.getSpeed());
        preparedStmt.setInt(2,w.getDirection());
        preparedStmt.execute();
        System.out.println(String.format("Insert Wind with Speed: %s Direction: %s to database",w.getSpeed(),w.getDirection()));
    }

    public void deleteWindById(int id) throws SQLException {
        String sqlInsert = String.format("delete from %s where  %s=?",TABLE_NAME, COLUMN_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setInt(1,id);
        preparedStmt.execute();
        System.out.println(String.format("Delete Winds with the id: %s from the database",id));
    }

    public ArrayList<Wind> getAllWinds() throws SQLException {
        ArrayList<Wind> aWind = new ArrayList<Wind>();
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        ResultSet result = preparedStmt.executeQuery();
        while(result.next()){
            Wind w = new WindBuilder()
                    .speed(result.getInt(COLUMN_SPEED))
                    .direction(result.getInt(COLUMN_DIRECTION))
                    .build();

            aWind.add(w);
        }
        return aWind;
    }

    public Wind getWindById(int id) throws SQLException {
        Wind w;
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);
        ResultSet result = preparedStmt.executeQuery();
        if(result.next()) {
            w = new WindBuilder()
                    .speed(result.getInt(COLUMN_SPEED))
                    .direction(result.getInt(COLUMN_DIRECTION))
                    .build();
        }
        else{
            w=null;
        }
        return w;
    }

    /*  -- OTHER APPROACH --

    public  void insertWind(int speed, int direction) throws SQLException {

            String sqlInsert = String.format("Insert into %s(%s,%s) values (?,?)",TABLE_NAME,COLUMN_SPEED,COLUMN_DIRECTION);
            PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
            preparedStmt.setInt(1,speed);
            preparedStmt.setInt(2,direction);
            preparedStmt.execute();
        }

    public void deleteWinds(Wind w) throws SQLException {
        String sqlInsert = String.format("delete from %s where  %s=? and %s=?",TABLE_NAME,COLUMN_SPEED,COLUMN_DIRECTION);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setInt(1,w.getSpeed());
        preparedStmt.setInt(2,w.getDirection());
        preparedStmt.execute();
        System.out.println(String.format("Delete Winds with the same values (s: %s d: %s) from the database",w.getSpeed(),w.getDirection()));
    }

    public ResultSet getAllWinds() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        ResultSet result = preparedStmt.executeQuery();
        return result;
    }

    public ResultSet getWindById(int id) throws SQLException {
        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    */

    public WindDataSource() throws SQLException, ClassNotFoundException {
    }
}
