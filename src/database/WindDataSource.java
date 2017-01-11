package database;

import com.intellij.psi.TypeAnnotationProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Daniel on 10/01/2017.
 */
public class WindDataSource {

    private static final String TABLE_NAME = "Winds";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SPEED = "Speed";
    private static final String COLUMN_DIRECTION = "Direction";
    private DatabaseHelper dbHelper= new DatabaseHelper();
    private Connection con = dbHelper.getCon();


    public  void insertWind(int speed, int direction) throws SQLException {

            String sqlInsert = String.format("Insert into %s(%s,%s) values (?,?)",TABLE_NAME,COLUMN_SPEED,COLUMN_DIRECTION);
            PreparedStatement preparedStmt = con.prepareStatement(sqlInsert);
            preparedStmt.setInt(1,speed);
            preparedStmt.setInt(2,direction);
            preparedStmt.execute();
//            con.close();

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

    public WindDataSource() throws SQLException, ClassNotFoundException {
    }
}
