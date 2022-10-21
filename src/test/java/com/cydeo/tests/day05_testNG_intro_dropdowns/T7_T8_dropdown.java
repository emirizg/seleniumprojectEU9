package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T7_T8_dropdown {

    //class level driver
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/dropdown");

    }


    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }


    @Test
    public void task7(){

        //TC #7: Selecting value from non-select dropdown

        //3. Click to non-select dropdown

        WebElement non_SelectDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        non_SelectDropdown.click();

        //4. Select Facebook from dropdown
        WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebook.click();

        //5. Verify title is “Facebook - Log In or Sign Up”

        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);


    }

    @Test
    public void task8() throws InterruptedException {

        //3. Select all the options from multiple select dropdown.

        List<WebElement> list = new ArrayList<>(driver.findElements(By.xpath("//select[@name='Languages']")));

        for (WebElement each : list) {
            Thread.sleep(2000);
            each.click();


        }

        //4. Print out all selected values.
        //5. Deselect all values.


    }

}
