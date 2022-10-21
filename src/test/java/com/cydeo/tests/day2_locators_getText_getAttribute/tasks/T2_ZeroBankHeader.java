package com.cydeo.tests.day2_locators_getText_getAttribute.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBankHeader {

    public static void main(String[] args) throws InterruptedException {

        //TC #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Verify header text
        //Expected: “Log in to ZeroBank”
        WebElement header = driver.findElement(By.tagName("h3"));

        String actualHeader = header.getText();
        String expectedHeader = header.getText();

        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Header Verification PASSED!");
        } else {
            System.out.println("Header Verification FAILED!");
        }

        Thread.sleep(2000);
        driver.close();


    }

}
