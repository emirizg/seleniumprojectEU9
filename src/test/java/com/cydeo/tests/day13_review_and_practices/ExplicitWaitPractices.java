package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitPractices {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){

        //TC #2: Explicit wait practice
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls ");

       dynamicControlsPage = new DynamicControlsPage();
    }

    @Test
    public void remove_button_text(){

        //3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
        //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //waiting for loading bar to disappear
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //5- Verify:
        //a. Checkbox is not displayed
        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(!dynamicControlsPage.checkBox.isDisplayed());
            //assertFalse method will pass the test if the boolean value returned is: false
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's gone!"));


        Driver.getDriver().close();
    }

    @Test
    public void enable_button_test(){

        //TC #3: Explicit wait practice
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls

        //3- Click to “Enable” button
        dynamicControlsPage.enableButton.click();

        System.out.println("dynamicControlsPage.inputBox.isEnabled() = " +
                dynamicControlsPage.inputBox.isEnabled());

        //4- Wait until “loading bar disappears”
        //Calling our ExplicitWait utility method to wait loadingBar to disappear
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        System.out.println("dynamicControlsPage.inputBox.isEnabled() = " +
                dynamicControlsPage.inputBox.isEnabled());


        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());
        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());

        //Check the String value is matching as expected: "It's enabled!"
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));


    }

}









