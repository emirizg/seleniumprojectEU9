package com.cydeo.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day8_T1 {


    @Test
    public void test1(){

        //TC #1: Web table practice
        // 1. Go to: https://practice.cydeo.com/web-tables
        Driver.getDriver().get("https://practice.cydeo.com/web-tables");

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        WebElement bobMartinName =
                Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));

        Assert.assertTrue("Bob Martin".equals(bobMartinName.getText()));

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        WebElement orderDate = Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));

        String expectedOrderDate = "12/31/2021";
        String actualOrderDate = orderDate.getText();

        Assert.assertEquals(actualOrderDate,expectedOrderDate);

    }


}
