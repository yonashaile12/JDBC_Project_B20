package day4;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;



public class DB_Test {

    // what can we use if we want to run certain code before all test only once
    //@BeforeAll
    @BeforeAll
    public static void setUp(){
        System.out.println("@BeforeAll IS RUNNING");
    }
    // what can we use if we want to run certain code before test
    //@BeforeEach

    @BeforeAll
    public void beforeEachMethod(){
        System.out.println("@BeforeEach IS RUNNING");
    }
    //what can we use if we want to run certain code after all test only once
   // @AfterAll
    @AfterAll
    public static void tearDown(){
        System.out.println("@AfterAll IS RUNNING");
    }
    //what can we use if we want to run certain code after each test
    //@AfterEach
    @AfterEach
    public void AfterEachMethod(){
        System.out.println("@AfterEach IS RUNNING");
    }

    @Test
    public void test1(){
        System.out.println("Test is running....");
        Assertions.assertEquals(9,3+6);

    }
}
