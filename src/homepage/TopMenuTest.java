package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */
public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        //Click on menu name
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(), '" + menu + "')]"));

    }

    @Test
    public void verifyPageNavigation() {
        //pass any name
        String menuName = "Apparel";
        // call selectMenu method
        selectMenu(menuName);
        //Verify current page
        String expectedTitle = "nopCommerce demo store. " + menuName;
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Page title does not match!", expectedTitle, actualTitle);
        System.out.println("The current page is " + actualTitle);

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
