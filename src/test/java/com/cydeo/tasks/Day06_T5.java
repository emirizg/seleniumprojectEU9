package com.cydeo.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day06_T5 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //TC #5: Window Handle practice
        //
        //1. Create a new class called: T5_WindowsPractice
        //2. Create new test and make set ups
        //3. Go to : https://practice.cydeo.com/windows

        driver.get("https://practice.cydeo.com/windows");

    }

    @Test
    public void test1(){

        //4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        Assert.assertEquals(actualTitle,expectedTitle);

        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereLink.click();

        //6. Switch to new Window.
        Set<String> allWindow = driver.getWindowHandles();

        for (String each : allWindow) {

            driver.switchTo().window(each);

        }

        //7. Assert: Title is “New Window”

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";

        Assert.assertEquals(actualTitle2,expectedTitle2);


        //8.click the home button
        WebElement homeButton = driver.findElement(By.xpath("//a[.='Home']"));
        homeButton.click();

        // verify title is "Practice"
        String expectedTitle3 = "Practice";
        String actualTitle3 = driver.getTitle();

        Assert.assertEquals(actualTitle3,expectedTitle3);



    }

}
