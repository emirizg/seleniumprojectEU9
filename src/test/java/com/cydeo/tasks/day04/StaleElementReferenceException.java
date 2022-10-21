package com.cydeo.tasks.day04;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StaleElementReferenceException {

    @Test
    public void stale_element_reference_exception(){

        //TC #6: StaleElementReferenceException Task
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/abtest
        Driver.getDriver().get("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = Driver.getDriver().findElement(By.xpath("//*[.='CYDEO']"));

        Assert.assertTrue(cydeoLink.isDisplayed());

        //4- Refresh the page.
        Driver.getDriver().navigate().refresh();

        cydeoLink = Driver.getDriver().findElement(By.xpath("//*[.='CYDEO']"));

        //5- Verify it is displayed, again.

        Assert.assertTrue(cydeoLink.isDisplayed());

    }

}
