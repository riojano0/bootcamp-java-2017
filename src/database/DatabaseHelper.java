package database;

import classes.State;

import java.sql.*;


/**
 * Created by Daniel on 10/01/2017.
 */
public class DatabaseHelper implements DatabaseInfo{

        private Connection con;

        public DatabaseHelper() throws ClassNotFoundException, SQLException {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL,USER,PASS);
        }

    public Connection getCon() {
        return con;
    }

    //        public void insertDay(String day) throws SQLException {
//
//            String sqlInsert = "Insert into Days(day) values (?)";
//            PreparedStatement preparedStmt = connect().prepareStatement(sqlInsert);
//            preparedStmt.setString(1,day);
//            preparedStmt.execute();
//            con.close();
//
//        }

//        public static void main(String[] Args){
//
//            try{
//            DatabaseHelper db = new DatabaseHelper();
//            db.insertDay("Wednesday");
//
//
//            }
//            catch (ClassNotFoundException e){
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
//        }

}
