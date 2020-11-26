package day3;

import utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class UtilityPractice {

    public static void main(String[] args) throws SQLException {
        // test out all the methods you have created so far for practice
        DB_Utility.createConnection();

        ResultSet jobRs = DB_Utility.runQuery("SELECT * FROM JOBS");
        /**
         * Get the row count of the ResultSet
         * move the pointer to the last roe qnd get the row number
         */
        jobRs.last();
        int rowCount = DB_Utility.getRowCount(); //getRow is getting the current row number

        System.out.println("rowCount = " + rowCount);

       // DB_Utility.destroy();

        int colCount = DB_Utility.getColumnCount();
        System.out.println("colCount = " + colCount);

        System.out.println("ALL COLUMN NAMES "+DB_Utility.getColumnNames() );
        System.out.println("ROW DATA AT ROW 3 "+DB_Utility.getRowDataAsList(3));
        System.out.println("GET CELL VALUE ROW 2 COLUMN 4 "+DB_Utility.getColumnDataAtRow(2,4) );
        System.out.println("GET CELL VALUE AND COLUMN NAME "+DB_Utility.getColumnDataAtRow(2,"MIN_SALARY"));
        System.out.println("THIRD COLUMN VALUE "+DB_Utility.getColumnDataAsList(3));
        System.out.println("JOB_TITLE VALUE "+DB_Utility.getColumnDataAsList("JOB_TITLE"));
        System.out.println("---------------------\n");
        DB_Utility.displayAllData();


        Map<String, String> row1Map = new LinkedHashMap<>();
        row1Map.put("JOB_ID", "AC_ACCOUNT");
        row1Map.put("JOB_TITLE", "Public Accountant");
        row1Map.put("MIN_SALARY", "4200");
        row1Map.put("MAX_SALARY", "9000");
        // now do above programmatically
        // create row 1 map like above programmatically
       // System.out.println("row1Map = "+row1Map);

        Map<String, String> rowMap = new LinkedHashMap<>();
        jobRs.absolute(1);
        ResultSetMetaData rsmd = jobRs.getMetaData();
        for (int colNum = 1; colNum <= rsmd.getColumnCount(); colNum++){

            String columnName = rsmd.getColumnLabel(colNum);
            String cellValue = jobRs.getString(colNum);
            rowMap.put(columnName, cellValue);

        }

        System.out.println("first_row rowMap = " +rowMap);

        System.out.println("first row rowMap "+DB_Utility.getRowMap(1));
        //if one row can be represented as one map object

        //Get second row and fourth row and save it into list of map as practice

        Map<String, String> row2Map = DB_Utility.getRowMap(2);
        Map<String, String> row4Map = DB_Utility.getRowMap(4);

        List< Map<String, String> > rowMapList = new ArrayList<>();
        rowMapList.add(row2Map);
        rowMapList.add(row4Map);
        System.out.println(rowMapList);



        DB_Utility.destroy();
    }




}
