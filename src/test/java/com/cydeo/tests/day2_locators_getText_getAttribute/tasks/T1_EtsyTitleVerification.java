package com.cydeo.tests.day2_locators_getText_getAttribute.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_EtsyTitleVerification {

    public static void main(String[] args) throws InterruptedException {

        //TC #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div/div[2]/div[2]/button")).click();

        //3. Search for “wooden spoon”
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        //4. Verify title:
        //Expected: “Wooden spoon | Etsy”

        String expectedResult = "Wooden spoon - Etsy";
        String actualResult = driver.getTitle();

        if (actualResult.equals(expectedResult)){
            System.out.println("Etsy Title Verification PASSED!");
        } else {
            System.out.println("Etsy Title Verification FAILED!");
        }


        Thread.sleep(2000);
        driver.close();
    }

}
