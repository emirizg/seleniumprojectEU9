package com.cydeo.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMillage {

    @Test
    public void gas_Mileage_Calculator() {

        //1. Add a new class GasMileageCalculatorTest
        //2. Go to https://www.calculator.net
        Driver.getDriver().get("https://www.calculator.net");

        //3. Search for “gas mileage” using search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@id='calcSearchTerm']"));
        searchBox.sendKeys("gas mileage");

        //4. Click on the “Gas Mileage Calculator” link
        WebElement gasMileageCalculatorLink = Driver.getDriver().findElement(By.xpath("//a[text()='Gas Mileage Calculator']"));
        gasMileageCalculatorLink.click();

        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”
        String expectedGasMileageCalculator_Title = "Gas Mileage Calculator";
        String actualGasMileageCalculator_Title = Driver.getDriver().getTitle();
        Assert.assertEquals(actualGasMileageCalculator_Title, expectedGasMileageCalculator_Title);
        //b. “Gas Mileage Calculator” label is displayed
        WebElement gasMileageCalculator_Label = Driver.getDriver().findElement(By.tagName("h1"));
        Assert.assertTrue(gasMileageCalculator_Label.isDisplayed());

        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdometer = Driver.getDriver().findElement(By.xpath("//input[@id='mucodreading']"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometer = Driver.getDriver().findElement(By.xpath("//input[@id='mupodreading']"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded = Driver.getDriver().findElement(By.xpath("//input[@id='mugasputin']"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = Driver.getDriver().findElement(By.xpath("//input[@id='mugasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        //10. Click on Calculate button
        WebElement calculateButton = Driver.getDriver().findElement(By.xpath("(//input[@value='Calculate'])[2]"));
        calculateButton.click();

        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”
        //
        WebElement mpgValue = Driver.getDriver().findElement(By.xpath("//span[@class='bigtext']"));
        String actualmpgValueText = mpgValue.getText();
        String expectedmpgValueText = "(55.13 mpg)";

        Assert.assertEquals(actualmpgValueText, expectedmpgValueText);


    }

}
