package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @Test (priority = 1)
    public void test1(){
        System.out.println("Test 1 is running...");
        String actual = "apple";
        String expected = "apple";

        //ASSERT EQUALS: compare 2 of the same things
        Assert.assertEquals(actual,expected);

    }

    @Test (priority = 2)
    public void test2(){
        System.out.println("Test 2 is running...");

        //Assert True
        String actual = "apple";
        String expected = "apple2";

        Assert.assertTrue(actual.equals(expected));

    }


    @BeforeClass
    public void setupMethod(){
        System.out.println("---> Before class is running!");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---> After class is running!");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("---> BeforeMethod is running!");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> AfterMethod is running!");
    }



}
