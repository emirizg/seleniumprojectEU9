package com.cydeo.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day06_T4_Iframes {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC #4: Iframe practice
        //
        //1. Create a new class called: T4_Iframes
        //2. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

    }


    @Test
    public void test1(){


        //1st way
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);

            //1.2 way
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));


        //2nd way
        driver.switchTo().frame(0);

        //3td way
        driver.switchTo().frame("mce_0_ifr");

        //4. Assert: “Your content goes here.” Text is displayed.

        WebElement yourConctenGoesHereText = driver.findElement(By.xpath("//body[@id='tinymce']/p"));

        System.out.println(yourConctenGoesHereText.getText());

        Assert.assertTrue(yourConctenGoesHereText.isDisplayed());

        driver.switchTo().parentFrame();
        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

        WebElement parentFrameText = driver.findElement(By.cssSelector("div[class='example']>h3"));

        System.out.println(parentFrameText.getText());

        Assert.assertTrue(parentFrameText.isDisplayed());

    }

}
