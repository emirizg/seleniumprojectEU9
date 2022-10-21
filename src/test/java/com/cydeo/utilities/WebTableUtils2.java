package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableUtils2 {

    //TC #2: Web table practice Task1 cont.
    // 1. Create a new class called WebTableUtils.
    //2. Create two methods to verify order

    public static String returnOrderDate(WebDriver driver, String customerName){

        WebElement customerNameLocator = Driver.getDriver().findElement(By.xpath("//table [@class='SampleTable']//td[.='"+customerName+"']"));

        WebElement customerDateLocator = Driver.getDriver().findElement(By.xpath("//table [@class='SampleTable']//td[.='"+customerName+"']/following-sibling::td[3]"));

        return customerDateLocator.getText();

    }

    //Method #1 info:
    //• Name: returnOrderDate ()
    //• Return type: String
    //• Arg1: WebDriver driver
    //• Arg2: String costumerName
    //This method should accept a costumerName and return the costumer order date
    //as a String.

}
