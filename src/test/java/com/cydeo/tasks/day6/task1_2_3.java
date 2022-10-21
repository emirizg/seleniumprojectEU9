package com.cydeo.tasks.day6;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class task1_2_3 {

    @BeforeMethod
    public void start(){
        Driver.getDriver().get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDown(){
        //Driver.getDriver().close();
    }

    @Test
    public void test(){
        //TC #1: Information alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts

        //3. Click to “Click for JS Alert” button
        WebElement jsAlertButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary'][1]"));
        jsAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement actualText = Driver.getDriver().findElement(By.cssSelector("p#result"));

        Assert.assertEquals(actualText.getText(),"You successfully clicked an alert");

    }


    @Test
    public void test2(){
        //TC #2: Confirmation alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts

        //3. Click to “Click for JS Confirm” button
        WebElement jsConfirm = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirm.click();

        //4. Click to OK button from the alert
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement actualOk = Driver.getDriver().findElement(By.cssSelector("p#result"));

        Assert.assertEquals(actualOk.getText(), "You clicked: Ok");

    }

    @Test
    public void test3(){

        //TC #3: Information alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Prompt” button
        WebElement promptAlert = Driver.getDriver().findElement(By.xpath("//*[.='Click for JS Prompt']"));
        promptAlert.click();

        //4. Send “hello” text to alert
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered:  hello” text is displayed.
        String actual = Driver.getDriver().findElement(By.cssSelector("p#result")).getText();
        String expected = "You entered: hello";

        Assert.assertTrue(actual.equals(expected));


    }


}
