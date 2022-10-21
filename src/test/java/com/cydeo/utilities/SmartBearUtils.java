package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {

    public static void loginToSmartBear(){

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordBox.sendKeys("test");

        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();


    }


}
//TC #1: Smartbear software link verification
//1. Open browser
//2. Go to website:
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3. Enter username: “Tester”
//4. Enter password: “test”
//5. Click to Login button

//6. Print out count of all the links on landing page
//7. Print out each link text on this page

// Mini-Task: CREATE A CLASS à SmartBearUtils
//• Create a method called loginToSmartBear
//• This method simply logs in to SmartBear when you call it.
//• Accepts WebDriver type as parameter