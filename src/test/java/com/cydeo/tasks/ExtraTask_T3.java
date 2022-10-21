package com.cydeo.tasks;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtraTask_T3 {

    @Test
    public void orderVerification(){

        //TC#3: Smartbear software order verification
        //1. Open browser and login to Smartbear software
        SmartBearUtils.loginToSmartBear();

        //2. Click on View all orders
        WebElement view_all_orders = Driver.getDriver().findElement(By.linkText("View all orders"));
        view_all_orders.click();

        //3. Verify Susan McLaren has order on date “01/05/2010”
        WebElement susanOrderDate = Driver.getDriver().findElement(By.xpath("//td[text()='Susan McLaren']//following-sibling::td[3]"));

        String expectedOrderDate = "01/05/2010";
        String actualOrderDate = susanOrderDate.getText();

        Assert.assertEquals(actualOrderDate, expectedOrderDate);

    }

}
