package com.cydeo.tests.day2_locators_getText_getAttribute.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_Back_Forward {

    public static void main(String[] args) throws InterruptedException {

        //TC #3: Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        WebElement consent = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
        consent.click();

        //3- Click to Gmail from top right.
        driver.findElement(By.className("gb_d")).click();

        //4- Verify title contains:
        //  Expected: Gmail
        String expectedTitle = "Gmail: email private e sicure | Google Workspace";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }


        //5- Go back to Google by using the .back();
        driver.navigate().back();


        Thread.sleep(2000);
        //6- Verify title equals:
        //  Expected: Google
        String expectedTitle2 = "Google";
        String actualTitle2 = driver.getTitle();

        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }


        Thread.sleep(2000);
        driver.close();

    }

}
