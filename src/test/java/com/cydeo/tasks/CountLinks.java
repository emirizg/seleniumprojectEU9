package com.cydeo.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CountLinks {

    @Test
    public void countLinks(){

        //TC #1: Checking the number of links on the page
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        Driver.getDriver().get("https://www.openxcell.com");
        //3. Count the number of the links on the page and verify
        //Expected: 332
        //
        List<WebElement> allLinks = Driver.getDriver().findElements(By.xpath("//a"));

        System.out.println(allLinks.size());

        Assert.assertEquals(allLinks.size(), 355);

        //TC #2: Printing out the texts of the links on the page
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        //3. Print out all of the texts of the links on the page

        for (WebElement each : allLinks) {

            System.out.println(each.getText());

        }


        //TC #3: Counting the number of links that does not have text
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com
        //3. Count the number of links that does not have text and verify
        //Expected: 109

        int counter = 0;
        for (WebElement each : allLinks) {
            if (each.getText().equals("")){
                counter++;
            }
        }

        System.out.println("counter = " + counter);




    }

}
