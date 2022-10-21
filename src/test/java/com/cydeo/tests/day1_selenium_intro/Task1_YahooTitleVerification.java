package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {


    public static void main(String[] args) throws InterruptedException {

        //TC #1: Yahoo Title Verification
        // do setup for browser driver
        WebDriverManager.chromedriver().setup();

        //1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.yahoo.com
        driver.get("https://www.yahoo.com");

        //3. Verify title:
        //Expected: Yahoo fa parte della famiglia di brand Yahoo.
        String expectedTitle = "Yahoo fa parte della famiglia di brand Yahoo.";

        // actual title comes from the browser
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is as expected. Verification PASSED!");
        }else {
            System.out.println("Title is NOT as expected. Verification FAILED!");
        }


        Thread.sleep(2000);

        driver.close();



    }


}

/*
TC #1: Yahoo Title Verification
1. Open Chrome browser
2. Go to https://www.yahoo.com
3. Verify title:
Expected: Yahoo
 */


