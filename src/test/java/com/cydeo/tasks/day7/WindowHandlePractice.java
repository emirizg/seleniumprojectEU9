package com.cydeo.tasks.day7;

import com.cydeo.utilities.BrowserUtils2;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class WindowHandlePractice {


    @Test
    public void test(){

        //TC #1: Window Handle practice
        // 1. Create new test and make set ups
        //2. Go to : https://www.amazon.com
        Driver.getDriver().get("https://www.amazon.com");

        //3. Copy-paste the lines from below into your class
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        BrowserUtils2.switchWindowAndVerify(Driver.getDriver(),"Etsy","Etsy");


        //Lines to be pasted:
        //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        //
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well

    }

}
