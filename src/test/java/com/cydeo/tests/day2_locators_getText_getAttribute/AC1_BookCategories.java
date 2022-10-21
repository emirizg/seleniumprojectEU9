package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AC1_BookCategories {

    public static void main(String[] args) throws InterruptedException {

        //Setup Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. students are on the home page
        //email: student11@library	-- password: 3MCeLsY9
        //Expected Result
        //Users should log in successfully and see the book categories drop-down menu
        driver.get("https://library1.cydeo.com/login.html");

        WebElement emailInput = driver.findElement(By.className("form-control"));
        emailInput.sendKeys("student11@library");

        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys("3MCeLsY9");

        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();

        //2- Students click the categories drop-down menu
        //Expected Result
        //Verify students are able to see 21 book categories
        Thread.sleep(2000);

        WebElement dropDownMenu = driver.findElement(By.tagName("select"));
        dropDownMenu.click();

        Thread.sleep(3000);
        driver.close();

    }

}
