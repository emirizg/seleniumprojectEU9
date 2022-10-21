package com.cydeo.tasks;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.SmartBearUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestBear {

    @BeforeMethod
    public void setup() {
        SmartBearUtils.loginToSmartBear();
    }


    @Test
    public void testBearLink() {

        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click to Login button


        //6. Print out count of all the links on landing page
        List<WebElement> links = Driver.getDriver().findElements(By.xpath("//a"));
        System.out.println("links.size() = " + links.size());

        //7. Print out each link text on this page
        //

        for (WebElement eachLink : links) {

            System.out.println(eachLink.getText());

        }


    }

    @Test
    public void test2() {

        //TC#2: Smartbear software order placing
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button


        //6. Click on Order
        WebElement orderButton = Driver.getDriver().findElement(By.xpath("//a[text()='Order']"));
        orderButton.click();

        //7. Select familyAlbum from product, set quantity to 2
        WebElement dropDownMenu = Driver.getDriver().findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));

        Select product = new Select(dropDownMenu);
        product.selectByVisibleText("FamilyAlbum");

        WebElement quantity = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("2");

        //8. Click to “Calculate” button
        WebElement calculateButton = Driver.getDriver().findElement(By.xpath("(//input[@class='btn_dark'])[1]"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker = new Faker();

        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"))
                .sendKeys(faker.name().firstName());

        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"))
                .sendKeys(faker.address().streetName());

        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"))
                .sendKeys(faker.address().city());
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"))
                .sendKeys(faker.address().state());
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"))
                .sendKeys(faker.address().zipCode().replace("-", ""));

        //10. Click on “visa” radio button
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();

        //11. Generate card number using JavaFaker
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"))
                .sendKeys(faker.finance().creditCard().replaceAll("-", ""));

        //12. Click on “Process”
        Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys("11/27");

        Driver.getDriver().findElement(By.xpath("//a[.='Process']")).click();

        //13. Verify success message “New order has been successfully added.”

        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//strong"));

        String expectedMessage = "New order has been successfully added.";
        String actualMessage = successMessage.getText();

        Assert.assertEquals(actualMessage, expectedMessage);


    }

}
