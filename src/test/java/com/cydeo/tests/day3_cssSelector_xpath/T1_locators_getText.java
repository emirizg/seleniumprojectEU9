package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {

    public static void main(String[] args) throws InterruptedException {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser
       // WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        //your code must be reusable
        //driver.findElement(By.className("login-inp")).sendKeys("incorrect");
        WebElement username = driver.findElement(By.className("login-inp"));
        username.sendKeys("incorrectLogin");

        //4- Enter incorrect password: “incorrect”
        // option + ENTER --> to auto generate local variable
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrectPassword");

        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errorMessage = driver.findElement(By.className("errortext"));

        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Error message verification PASSED!");
        } else {
            System.out.println("Error message verification FAILED!!!");
        }

        Thread.sleep(2000);
        driver.close();

    }

}
