package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_2_cssSelector {

    public static void main(String[] args) throws InterruptedException {

        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        WebElement homeLink = driver.findElement(By.cssSelector("a.nav-link"));
        //b. “Forgot password” header
        WebElement forgotHeader = driver.findElement(By.cssSelector("div.example>h2"));
        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.cssSelector("div.large-6>label"));
        //d. E-mail input box
        WebElement inputBox = driver.findElement(By.cssSelector("input[name='email']"));
        //e. “Retrieve password” button
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button#form_submit"));
        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText = driver.findElement(By.cssSelector("div[class='large-4 large-centered columns']>div"));


        //4. Verify all web elements are displayed.

        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("forgotHeader.isDisplayed() = " + forgotHeader.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("inputBox.isDisplayed() = " + inputBox.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());

        Thread.sleep(2000);
        driver.close();

    }

}
/*
    tagName#idValue
    #idValue

    tagName.classValue
    .classValue
 */