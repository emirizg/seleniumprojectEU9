package com.cydeo.tasks.day5;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class StaleElementReference {


    public void test(){
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        Driver.getDriver().get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[.='Add Element']"));
        button.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());

        //5. Click to “Delete” button.
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        try{
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

    }

}
