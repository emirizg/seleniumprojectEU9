package com.cydeo.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class challangeAccepted {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void flipkard() throws InterruptedException {

        driver.get("https://www.flipkart.com/");

        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[.='✕']")).click();



        //Locate Wire Headphones
        WebElement electronics = driver.findElement(By.xpath("(//div[.='Electronics'])[4]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).build().perform();

        Thread.sleep(3000);
        WebElement wiredHeadphones = driver.findElement(By.xpath("//a[.='Wired Headphones']"));
        System.out.println("wiredHeadphones.isDisplayed() = " + wiredHeadphones.isDisplayed());
        wiredHeadphones.click();


    }

}
