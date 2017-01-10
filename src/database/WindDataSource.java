package database;

import com.intellij.psi.TypeAnnotationProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Daniel on 10/01/2017.
 */
public class WindDataSource {

    static final String TABLE_NAME = "Winds";
    static final String COLUMN_SPEED = "Speed";
    static final String COLUMN_DIRECTION = "Direction";
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

    public WindDataSource() throws SQLException, ClassNotFoundException {
    }
}
