package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {

    public static void main(String[] args) throws InterruptedException {

        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");


        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password
        //WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password']"));
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class='login-btn']"));

        String expectedButtonText = "Reset password";
        String actualButtonText = resetPasswordButton.getText();

        System.out.println("actualButtonText = " + actualButtonText);

        if (actualButtonText.equals(expectedButtonText)){
            System.out.println("Reset Password button text verification PASSED!");
        } else {
            System.out.println("Reset Password button text verification FAILED!!!");
        }

        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from

        Thread.sleep(2000);
        driver.close();

    }

}
