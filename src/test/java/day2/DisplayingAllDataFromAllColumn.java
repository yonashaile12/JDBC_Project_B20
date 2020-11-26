package day2;

import utility.DB_Utility;

import java.sql.*;

public class DisplayingAllDataFromAllColumn {


    public static void main(String[] args) throws SQLException {


        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM EMPLOYEES");

        //print out entire first roew
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        //print out coulmn name in the beginning row, then print first row

        for(int colNum = 1; colNum <= columnCount; colNum++){
            System.out.print(rsmd.getColumnLabel(colNum) +"\t");
        }
        rs.next();
        System.out.println();
        System.out.println("---------------------------------------------------");

        //this whole loop is getting one row of data
        for (int colNum = 1; colNum <= columnCount; colNum++) {
            System.out.printf(rs.getString(colNum) +"\t");
        }

        // now how do you get all the row if you know how to get one row ???
        //I want to go from the first row till the last rowand print all column
        rs.beforeFirst();
        while(rs.next()){
            for (int colNum = 1; colNum <= columnCount; colNum++) {
                System.out.printf(rs.getString(colNum) +"\t");
            }
            System.out.println();
        }


        DB_Utility.destroy();

    }
}
