package com.cydeo.tasks.day8;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebTableUtils2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 {

    @Test
    public void test1(){

        //1. Go to: https://practice.cydeo.com/web-tables
        Driver.getDriver().get("https://practice.cydeo.com/web-tables");
        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”


        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        String bobsDate =  WebTableUtils2.returnOrderDate(Driver.getDriver(),"Bob Martin");
        String expectedDate ="12/31/2021";

        Assert.assertEquals(bobsDate,expectedDate);

    }
}
