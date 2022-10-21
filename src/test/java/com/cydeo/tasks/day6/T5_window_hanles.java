package com.cydeo.tasks.day6;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T5_window_hanles {

    @Test
    public void window_handle_practice(){

        //TC #5: Window Handle practice
        //
        //1. Create a new class called: T5_WindowsPractice
        //2. Create new test and make set up
        //3. Go to : https://practice.cydeo.com/windows
        Driver.getDriver().navigate().to("https://practice.cydeo.com/windows");

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Error Message");

        //5. Click to: “Click Here” link
        WebElement clickHereLink = Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']"));
        clickHereLink.click();

        //6. Switch to new Window.
        for (String eachWindow : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(eachWindow);
            System.out.println(Driver.getDriver().getTitle());
        }

        //7. Assert: Title is “New Window”
        expectedTitle = "New Window";
        actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);


    }

}
