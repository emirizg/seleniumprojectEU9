package com.cydeo.tasks.day10;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_uploadFile {

    @Test
    public void uploadFile() {

        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        // /Users/emirizgubarlar/Desktop/Mentor 06/Java/Arrays.pdf

        //3. Upload the file.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        chooseFileButton.sendKeys("/Users/emirizgubarlar/Desktop/Mentor 06/Java/Arrays.pdf");

        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadedText = Driver.getDriver().findElement(By.tagName("h3"));
        String actualText = fileUploadedText.getText();
        String expectedTitle = "File Uploaded!";

        Assert.assertEquals(actualText, expectedTitle);
        Assert.assertTrue(actualText.equals(expectedTitle));
        Assert.assertTrue(fileUploadedText.isDisplayed());

    }

}
