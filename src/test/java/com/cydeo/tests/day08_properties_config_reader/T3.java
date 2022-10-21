package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/tables");

    }

   @Test
   public void test1(){

        getTableGetEmail(driver,"1","Jason");
        getTableGetEmail(driver,"2","Tim");

   }


    public void getTableGetEmail(WebDriver driver, String tableNum, String firstName){

        WebElement getEmail = driver.findElement(By.xpath("//table[@id='table"+tableNum+"']//td[.='"+firstName+"']/following-sibling::td[1]"));
        System.out.println("getEmail.getText() = " + getEmail.getText());

    }

}

//TC #3: Create a custom method
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/tables
//3- Write custom method:
//
//• Method name: getTableGetEmail()
//• Return type: void
//• Arg1: WebDriver driver
//• Arg2: String tableNum
//• Arg3: String firstName