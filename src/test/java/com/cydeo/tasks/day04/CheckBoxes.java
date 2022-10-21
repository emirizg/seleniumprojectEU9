package com.cydeo.tasks.day04;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxes {

    @Test
    public void check_Boxes(){

        //Practice: Checkboxes
        //1. Go to http://practice.cydeo.com/checkboxes
        Driver.getDriver().get("http://practice.cydeo.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        WebElement checkbox1 = Driver.getDriver().findElement(By.cssSelector("input#box1"));
        Assert.assertFalse(checkbox1.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkbox2 = Driver.getDriver().findElement(By.cssSelector("input#box2"));
        Assert.assertTrue(checkbox2.isSelected());

        //4. Click checkbox #1 to select it.
        checkbox1.click();

        //5. Click checkbox #2 to deselect it.
        checkbox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        Assert.assertTrue(checkbox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected.
        Assert.assertFalse(checkbox2.isSelected());

        Driver.closeDriver();

    }

}
