package com.cydeo.tasks.day02;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BackAndForthNavigation {




    @Test
    public void back_and_forth(){

        //TC #3: Back and forth navigation
        //1- Open a Chrome browser
        //2- Go to: https://google.com
        Driver.getDriver().get("https://google.com");

        //accept cookies
        WebElement acceptAllButton = Driver.getDriver().findElement(By.xpath("//button[@id='L2AGLb']"));
        acceptAllButton.click();

        //3- Click to Gmail from top right.
        WebElement gmailButton = Driver.getDriver().findElement(By.xpath("//a[.='Gmail']"));
        gmailButton.click();

        //4- Verify title contains:
        //  Expected: Gmail
        String expectedGmailTitle = "Gmail: email private e sicure | Google Workspace";
        String actualGmailTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualGmailTitle.equals(expectedGmailTitle) , "Error Message 1");

        //Assert.assertEquals(actualGmailTitle , expectedGmailTitle, "Error Message 2");

        //5- Go back to Google by using the .back();
        Driver.getDriver().navigate().back();

        //6- Verify title equals:
        //  Expected: Google
        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualGoogleTitle, expectedGoogleTitle);

        Driver.closeDriver();


    }




}
