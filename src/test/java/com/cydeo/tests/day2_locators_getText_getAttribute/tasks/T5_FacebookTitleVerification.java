package com.cydeo.tests.day2_locators_getText_getAttribute.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_FacebookTitleVerification {

    public static void main(String[] args) throws InterruptedException {

        //TC #1: Facebook title verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        WebElement allowCookies=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]"));
        allowCookies.click();

        //3. Verify title:
        //Expected: “Facebook - Log In or Sign Up”

        String expectedResult = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedResult)){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }

        Thread.sleep(2000);
        driver.close();

    }

}
