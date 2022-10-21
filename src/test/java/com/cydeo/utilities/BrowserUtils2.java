package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserUtils2 {

    public static void switchWindowAndVerify(WebDriver driver, String expectedInTitle, String expectedTitle){
        // TC #2: Create utility method
        // 1. Create a new class called BrowserUtils
        //2. Create a method to make Task1 logic re-usable
        //3. When method is called, it should switch window and verify title.
        //
        //
        //Method info:
        //• Name: switchWindowAndVerify
        //• Return type: void
        //• Arg1: WebDriver
        //• Arg2: String expectedInUrl
        //• Arg3: String expectedTitle

        for (String eachWindow : Driver.getDriver().getWindowHandles()) {

            Driver.getDriver().switchTo().window(eachWindow);
            if (Driver.getDriver().getTitle().contains(expectedInTitle)){
                break;
            }

        }

        //5. Assert: Title contains “Etsy”
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));

    }

}
