package day2;

import utility.DB_Utility;

import java.sql.*;

public class GettingMoreInfoAboutResultSetObject {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@34.207.119.202:1521:XE";
        //  connection String (oracle)vendor (thin)driverType (34.207.119.202)Ip address (1521)Port (xe)

        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM EMPLOYEES");

        // MetaData -- a data about the data
        // ResultSetMetaData -- data about the resultData object that contain out resulting rows and cloumns
        // forexample column names, coulmn counts .. and more
        // this is how we get the ResultSetMetaData object


        //ResultSetMetadata itself does not contains any row data
        //it only has information about the columns
        ResultSetMetaData rsmd = rs.getMetaData();
        // we only need two methods from this to get column count and column name | label


        int colCount= rsmd.getColumnCount();
        System.out.println("colCount = " + colCount);
        // this is how we get column label | name using index
        // get first column name
        System.out.println( "First column Name is "+ rsmd.getColumnLabel(1)  ); //JOB_ID
        System.out.println( "Second column Name is "+ rsmd.getColumnLabel(2) ); //JOB_TITLE

        // now print out all column name
        System.out.println("--------------------------------");
        for(int colNum = 1; colNum <= colCount; colNum++){
            System.out.println("Column name "+rsmd.getColumnLabel(colNum));
        }


        DB_Utility.destroy();




    }
}
