package Day1;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        // REPLACE THIS IP ADDRESS WITH YOUR OWN THAT WORKING IN SQL DEVELOPER
        String connectionStr = "jdbc:oracle:thin:@34.207.119.202:1521:XE";
        //  connection String (oracle)vendor (thin)driverType (34.207.119.202)Ip address (1521)Port (xe)

        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;

        Statement stmnt = conn.createStatement();

        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;
        //this will move the cursor from beforeFirst location to first row
        rs.next(); // currently we are at the very first row

        //rs.getString(column index) can be used to read the data of that column in current row
        System.out.println("first column value using index: --> " +  rs.getString(1)   );
        System.out.println("second column value using index: --> " +  rs.getString(2)   );

        //rs.getString(column names)
        System.out.println("Region_ID at this roe is: "+ rs.getString("REGION_ID"));
        System.out.println("Region_NAME at this roe is: "+ rs.getString("REGION_NAME"));

        rs.next(); // this will move us to next row so we can read next row
        System.out.println("Region_ID at this roe is: "+ rs.getString("REGION_ID"));
        System.out.println("Region_NAME at this roe is: "+ rs.getString("REGION_NAME"));
        //what if we want to keep moving?

        rs.next(); // this will move us to next row so we can read next row

        System.out.println("Region_ID at this roe is: "+ rs.getString("REGION_ID"));
        System.out.println("Region_NAME at this roe is: "+ rs.getString("REGION_NAME"));

        rs.next(); // this will move us to next row so we can read next row

        System.out.println("Region_ID at this roe is: "+ rs.getString("REGION_ID"));
        System.out.println("Region_NAME at this roe is: "+ rs.getString("REGION_NAME"));

        rs.next(); // this will move us to next row so we can read next row

        System.out.println("Region_ID at this roe is: "+ rs.getString("REGION_ID"));
        System.out.println("Region_NAME at this roe is: "+ rs.getString("REGION_NAME"));

    }
}
