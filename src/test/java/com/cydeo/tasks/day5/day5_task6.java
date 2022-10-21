package com.cydeo.tasks.day5;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day5_task6 {

    @Test
    public void date_on_dropdown_and_verifying(){

        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

        //3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropDown = new Select(Driver.getDriver().findElement(By.id("year")));
        yearDropDown.selectByVisibleText("1923");

        Select monthDropDown = new Select(Driver.getDriver().findElement(By.id("month")));
        monthDropDown.selectByValue("11");

        Select dayDropDown = new Select(Driver.getDriver().findElement(By.id("day")));
        dayDropDown.selectByIndex(0);

        Assert.assertTrue(yearDropDown.getFirstSelectedOption().getText().equals("1923"));
       // Assert.assertTrue(yearDropDown.getFirstSelectedOption().isSelected());

        Assert.assertTrue(monthDropDown.getFirstSelectedOption().getText().equals("December"));

        Assert.assertTrue(dayDropDown.getFirstSelectedOption().getText().equals("1"));


        //Select year using  : visible text
        //Select month using   : value attribute
        //Select day using : index number

        Driver.getDriver().close();

    }

}
