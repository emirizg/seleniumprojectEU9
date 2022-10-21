package com.cydeo.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day06_Task123_alert {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //TC #1: Information alert practice
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");


    }


    @Test
    public void test1(){

        //3. Click to “Click for JS Alert” button
        WebElement jsAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertButton.click();

        Alert alert = driver.switchTo().alert();
        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.

        WebElement successMessage = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(successMessage.isDisplayed());

    }

    @Test
    public void test2(){

        //3. Click to “Click for JS Confirm” button
        WebElement jsConfirmButton = driver.findElement(By.xpath("//*[.='Click for JS Confirm']"));
        jsConfirmButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();

        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement youClickedOkMessage = driver.findElement(By.xpath("//p[2]"));

        System.out.println(youClickedOkMessage.getText());

        Assert.assertTrue(youClickedOkMessage.isDisplayed());

    }

    @Test
    public void test3(){

        //3. Click to “Click for JS Prompt” button
        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();

        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");


        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered:  hello” text is displayed.
        WebElement message = driver.findElement(By.xpath("//p[2]"));

        Assert.assertEquals(message.getText(),"You entered: hello");

    }

}
