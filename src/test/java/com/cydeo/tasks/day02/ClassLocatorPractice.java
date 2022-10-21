package com.cydeo.tasks.day02;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassLocatorPractice {

    @Test
    public void class_locator(){

        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/inputs
        Driver.getDriver().get("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link
        WebElement home = Driver.getDriver().findElement(By.className("nav-link"));
        home.click();

        //4- Verify title is as expected:
        //Expected: Practice
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Practice"));

        //PS: Locate “Home” link using “className” locator

    }

}
