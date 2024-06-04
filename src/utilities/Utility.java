package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    // this method click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //This method for select dropdown
    public void selectByTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select class
        Select select = new Select(dropDown);
        // Select by visible Text
        select.selectByVisibleText(text);
    }

    // This method will get text from elements
    public String getTextFromTheElement(By by) {
        return driver.findElement(by).getText();
    }

    //send keys method
    public void sendTextElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // Verify the actual and expected text
    public void verifyElements(String displayMessage, String expectedText, By by) {
        String actualText = getTextFromTheElement(by);
        Assert.assertEquals(displayMessage, expectedText, actualText);
    }

    // Clear the text
    public void clearText(By by) {
        driver.findElement(by).clear();
    }

    //This method will mouse hover on element and click
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }


    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
        // actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by1)).click().build().perform();
    }

    /**
     * This method will verify the expected and actual result
     */

    public void selectByValueFromDropDown(By by, String value) {

        new Select(driver.findElement(by)).selectByValue(value);

    }


}
