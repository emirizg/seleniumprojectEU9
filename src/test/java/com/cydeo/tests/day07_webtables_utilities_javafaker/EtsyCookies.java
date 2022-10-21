package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EtsyCookies {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //C #1: Window Handle practice
        // 1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){

        driver.get("https://www.etsy.com/");

        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']")).click();

    }

}
