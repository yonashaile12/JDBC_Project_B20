package day2;

import utility.DB_Utility;

import java.sql.*;

public class Review {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@34.207.119.202:1521:XE";
        //  connection String (oracle)vendor (thin)driverType (34.207.119.202)Ip address (1521)Port (xe)

        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM JOBS");

        // I want to read the first row
        rs.next();
        System.out.println("First column value in Jobs "+rs.getString(1));
        System.out.println("Second column value in Jobs "+rs.getString(2));

        //move to row number 7 and get above 2 columns values
        rs.absolute(7);
        System.out.println("Frist column value in Jobs in row 7 "+rs.getString(1));
        System.out.println("Second column value in Jobs in row 7 "+rs.getString(2));

        rs.last();
        System.out.println("First column value in Jobs in last row "+rs.getString(1));
        System.out.println("Scond column value in Jobs in last row"+rs.getString(2));

        rs.previous();
        System.out.println("First column value in Jobs 2nd row from last "+rs.getString(1));
        System.out.println("Second column value in Jobs 2nd from last "+rs.getString(2));


        System.out.println("\n---------Loop from first row till last row print JOB_ID------------");
        rs.beforeFirst();

        while(rs.next()){
            System.out.println("Loop First column "+rs.getString("JOB_ID"));
        }

        System.out.println("\n---------Loop from first row get MIN_SALARY COLUMN AS Number------------");
        // We are currently at after last location
        //if you really want to make sure and explicitly say so

        rs.afterLast();
        while(rs.previous()){
            // NOTHING WRONG WITH GETTING IT AS STRING. JUST FOR THE SAKE OF DEMO, WE ARE GETTING AS DOUBLE
            System.out.println(" MIN SALARY COLUMN AS NUMBER $"+rs.getDouble("MIN_SALARY"));
        }

        // clean up the connection, statement and resultSet object afer usage
        DB_Utility.destroy();

    }
}
