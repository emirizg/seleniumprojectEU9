package com.cydeo.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5 {

    WebDriver driver;

    @BeforeMethod
    public void setupDriver(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void test(){

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois
        stateDropDown.selectByVisibleText("Illinois");
        System.out.println(stateDropDown.getFirstSelectedOption().getText());

        // 4. Select Virginia
        stateDropDown.selectByValue("VA");
        System.out.println(stateDropDown.getFirstSelectedOption().getText());

        // 5. Select California
        stateDropDown.selectByIndex(5);
        System.out.println(stateDropDown.getFirstSelectedOption().getText());

        // 6. Verify final selected option is California.
        String expectedResult = "California";
        String actualResult = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedResult,actualResult);


    }



}
//TC #5: Selecting state from State dropdown and verifying result
//1. Open Chrome browser
//2. Go to http://practice.cybertekschool.com/dropdown
//3. Select Illinois
//4. Select Virginia
//5. Select California
//6. Verify final selected option is California.
//Use all Select options. (visible text, value, index)