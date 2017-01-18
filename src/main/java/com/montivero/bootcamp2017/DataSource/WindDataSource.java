package com.montivero.bootcamp2017.DataSource;

import com.montivero.bootcamp2017.Builders.WindBuilder;
import com.montivero.bootcamp2017.Config.DatabaseHelper;
import com.montivero.bootcamp2017.Domains.Wind;
import com.montivero.bootcamp2017.utils.DataSourceUtils;

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

    public  void insertWind(int speed, int direction) throws SQLException {
        String sqlInsert = String.format("Insert into %s(%s,%s) values (?,?)",TABLE_NAME,COLUMN_SPEED,COLUMN_DIRECTION);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setInt(1,speed);
        preparedStmt.setInt(2,direction);
        preparedStmt.execute();
    }

    public int getIdByWind(Wind wind) throws SQLException {
        ResultSet result = getWindByValues(wind.getSpeed(),wind.getDirection());
        int id;
        if(result.next()){
            id = result.getInt(1);
        }else{
            id=0;
        }
        return id;

    }

    private ResultSet getWindByValues(int speed, int direcion) throws SQLException {
        String sqlScript = String.format("Select * from %s where %s = ? and %s = ?",
                TABLE_NAME,COLUMN_SPEED,COLUMN_DIRECTION);
        PreparedStatement preparedStmt = con.prepareStatement(sqlScript);
        preparedStmt.setInt(1,speed);
        preparedStmt.setInt(2,direcion);
        return preparedStmt.executeQuery();

    }

    public void deleteWindById(int id) throws SQLException {
        String sqlInsert = String.format("delete from %s where  %s=?",TABLE_NAME, COLUMN_ID);
        PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
        preparedStmt.setInt(1,id);
        preparedStmt.execute();
        System.out.println(String.format("Delete Winds with the id: %s from the database",id));
    }

    public ArrayList<Wind> getAllWindsObjects() throws SQLException {
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

    public ResultSet getAllWinds() throws SQLException {
        String sqlSelect = String.format("Select * from %s",TABLE_NAME);
        PreparedStatement preparedStmt = con.prepareStatement(sqlSelect);
        return preparedStmt.executeQuery();
    }

    public Wind getWindByIdObject(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_ID);
        preparedStmt.setInt(1,id);
        ResultSet result = preparedStmt.executeQuery();
        return fillWind(result);
    }


    public ResultSet getWindById(int id) throws SQLException, ClassNotFoundException {
//        String sqlSelect = String.format("Select * from %s where %s = ?",TABLE_NAME,COLUMN_ID);
        PreparedStatement preparedStmt = DataSourceUtils.prepareStatementCreator(TABLE_NAME,COLUMN_ID);
        preparedStmt.setInt(1,id);
        return preparedStmt.executeQuery();
    }

    private Wind fillWind(ResultSet result) throws SQLException {
        Wind w;
        if(result.next()) {
            w = new WindBuilder()
                    .speed(result.getInt(COLUMN_SPEED))
                    .direction(result.getInt(COLUMN_DIRECTION))
                    .build();
        }else{
            w=null;
        }
        return w;
    }

    public WindDataSource() throws SQLException, ClassNotFoundException {
    }
}
