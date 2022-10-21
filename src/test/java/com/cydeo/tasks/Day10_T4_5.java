package com.cydeo.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day10_T4_5 {


    @Test
    public void test(){

        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //3- Scroll down to “Powered by CYDEO”
        js.executeScript("window.scrollBy( 0,2300)");

        //4- Scroll using Actions class “moveTo(element)” method
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[.='Dropdown']"))).perform();



    }



    //TC #5: Scroll practice 2
    //1- Continue from where the Task 4 is left in the same test.
    //2- Scroll back up to “Home” link using PageUP button


}
