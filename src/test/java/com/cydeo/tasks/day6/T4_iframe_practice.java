package com.cydeo.tasks.day6;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_iframe_practice {

    @Test
    public void iframe_practice(){

        //TC #4: Iframe practice
        //
        //1. Create a new class called: T4_Iframes
        //2. Create new test and make set up
        //3. Go to: https://practice.cydeo.com/iframe
        Driver.getDriver().navigate().to("https://practice.cydeo.com/iframe");

        //4. Assert: “Your content goes here.” Text is displayed.

        Driver.getDriver().switchTo().frame("mce_0_ifr");

        WebElement yourContentGoesHereText = Driver.getDriver().findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());

        Driver.getDriver().switchTo().parentFrame();

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

        WebElement header = Driver.getDriver().findElement(By.xpath("//h3"));
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualHeader = header.getText();

        Assert.assertTrue(expectedHeader.equals(actualHeader));


    }

}
