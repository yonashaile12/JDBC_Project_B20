package day4;

import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import utility.DB_Utility;

public class DB_Test {

    //create connection once and destroy it once

    @BeforeAll
    public static void init(){
        DB_Utility.createConnection();
    }


    @Test
    public void testEmployeeCount(){
        //run a query SELECT * FROM EMPLOYEES
        //assert that the employee count is 107
        DB_Utility.runQuery("SELECT *  FROM EMPLOYEES");
        DB_Utility.displayAllData();
        Assertions.assertEquals(107, DB_Utility.getRowCount());
    }






    @AfterAll
    public static void tearDown(){
        DB_Utility.destroy();
    }


}
