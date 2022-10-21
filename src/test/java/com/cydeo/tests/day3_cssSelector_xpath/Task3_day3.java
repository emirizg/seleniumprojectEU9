package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task3_day3 {

    public static void main(String[] args) throws InterruptedException {


        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        WebElement logInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));

        String expectedButtonText = "Log In";
        String actualButtonText = logInButton.getAttribute("value");

        if (actualButtonText.equals(expectedButtonText)){
            System.out.println("Log In button text verification PASSED!");
        } else {
            System.out.println("Log In button text verification FAILED!!!");
        }


        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from

        Thread.sleep(2000);
        driver.close();

    }

}
