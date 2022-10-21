package com.cydeo.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void multipleSelection() throws InterruptedException {
        Select selectAllDropdowns = new Select(driver.findElement(By.name("Languages")));
        List<WebElement> allLanguageOptions = selectAllDropdowns.getOptions();

        for (WebElement each : allLanguageOptions) {
            Thread.sleep(2000);
            each.click();
            System.out.println("Language Options = " + each.getText());
        }
        selectAllDropdowns.deselectAll();
    }

    @Test
    public void test2(){

        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        System.out.println(dropDown.getFirstSelectedOption().getText());

        List<WebElement> allOptions = dropDown.getOptions();

        for (WebElement each : allOptions) {

            System.out.print(each.getText() + ", ");

        }


    }

}
//TC #8: Selecting value from multiple select dropdown
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
