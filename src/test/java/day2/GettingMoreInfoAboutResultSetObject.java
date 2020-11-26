package day2;

import utility.DB_Utility;

import javax.xml.transform.Result;
import java.sql.*;

public class GettingMoreInfoAboutResultSetObject {

    public static void main(String[] args) throws SQLException {
        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM EMPLOYEES");
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
