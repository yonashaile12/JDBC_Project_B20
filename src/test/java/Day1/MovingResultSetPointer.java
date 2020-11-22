package Day1;

import java.sql.*;

public class MovingResultSetPointer {


    public static void main(String[] args) throws SQLException {
        //we want to create a statement object that generate
        //ResultSet that can move FORWARD AND BACKWARD ANYTIME
        String connectionStr = "jdbc:oracle:thin:@34.207.119.202:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        //this way of creating
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet rs   =   stmt.executeQuery("SELECT * FROM REGIONS") ;

        while(rs.next()){
            System.out.println("REGION_NAME "+ rs.getString("REGION_NAME"));
        }

       // rs.previous();
       // System.out.println("REGION_NAME "+rs.getString("REGION_NAME"));

        while(rs.previous()){
            System.out.println("BACKWARD - REGION_NAME "+rs.getString("REGION_NAME"));
        }

        /**
         * other ResultSet methods for moving your pointer to specific locations
         */

        rs.beforeFirst(); //before first location
        rs.first(); //first row
        rs.last(); // last row
        rs.afterLast(); //after last location
        rs.absolute(3); // move to specific row

        //how to find out which row the pointer is at right now
        rs.last();
        int currentRowNum = rs.getRow();
        System.out.println("Row count = "+currentRowNum);
    }
}
