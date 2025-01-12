package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
 * 1.1 Mouse Hover on “Electronics” Tab
 * 1.2 Mouse Hover on “Cell phones” and click
 * 1.3 Verify the text “Cell phones”
 * 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
 * 2.1 Mouse Hover on “Electronics” Tab
 * 2.2 Mouse Hover on “Cell phones” and click
 * 2.3 Verify the text “Cell phones”
 * 2.4 Click on List View Tab
 * 2.5 Click on product name “Nokia Lumia 1020” link
 * 2.6 Verify the text “Nokia Lumia 1020”
 * 2.7 Verify the price “$349.00”
 * 2.8 Change quantity to 2
 * 2.9 Click on “ADD TO CART” tab
 * 2.10 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.12 Verify the message "Shopping cart"
 * 2.13 Verify the quantity is 2
 * 2.14 Verify the Total $698.00
 * 2.15 click on checkbox “I agree with the terms of service”
 * 2.16 Click on “CHECKOUT”
 * 2.17 Verify the Text “Welcome, Please Sign In!”
 * 2.18 Click on “REGISTER” tab
 * 2.19 Verify the text “Register”
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “REGISTER” Button
 * 2.22 Verify the message “Your registration completed”
 * 2.23 Click on “CONTINUE” tab
 * 2.24 Verify the text “Shopping card”
 * 2.25 click on checkbox “I agree with the terms of service”
 * 2.26 Click on “CHECKOUT”
 * 2.27 Fill the Mandatory fields
 * 2.28 Click on “CONTINUE”
 * 2.29 Click on Radio Button “2nd Day Air ($0.00)”
 * 2.30 Click on “CONTINUE”
 * 2.31 Select Radio Button “Credit Card”
 * 2.32 Select “Visa” From Select credit card dropdown
 * 2.33 Fill all the details
 * 2.34 Click on “CONTINUE”
 * 2.35 Verify “Payment Method” is “Credit Card”
 * 2.36 Verify “Shipping Method” is “2nd Day Air”
 * 2.37 Verify Total is “$698.00”
 * 2.38 Click on “CONFIRM”
 * 2.39 Verify the Text “Thank You”
 * 2.40 Verify the message “Your order has been successfully processed!”
 * 2.41 Click on “CONTINUE”
 * 2.42 Verify the text “Welcome to our store”
 * 2.43 Click on “Logout” link
 * 2.44 Verify the URL is “https://demo.nopcommerce.com/"
 */
public class ElectronicTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.linkText("Electronics"));
        //mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //1.2 Mouse Hover on “Cell phones” and "Click"
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromTheElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        Assert.assertEquals("Incorrect Top Menu", expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));

        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //2.3 Verify the text “Cell phones”
        verifyElements("Not a cell phones", "Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(2000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        verifyElements("Not a Nokia Lumia 1020", "Nokia Lumia 1020", By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"));

        //2.7 Verify the price “$349.00”
        verifyElements("Price not match", "$349.00", By.xpath("//span[@id='price-value-20']"));

        //2.8 Change quantity to 2
        clearText(By.id("product_enteredQuantity_20"));
        Thread.sleep(2000);
        sendTextElement(By.id("product_enteredQuantity_20"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Topngreen Bar
        verifyElements("error", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));

        //2.12 Verify the message "Shopping cart"
        Thread.sleep(2000);
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));

        //2.13 Verify the quantity is 2
        Thread.sleep(2000);
        Assert.assertEquals("2", driver.findElement(By.xpath("//div[@class='product-quantity']//input")).getAttribute("value"));

        //2.14 Verify the Total $698.00
        verifyElements("Total not match", "$698.00", By.xpath("//span[@class='product-subtotal']"));

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyElements("Not the same page", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));

        //2.19 Verify the text “Register”
        verifyElements("Not Register page", "Register", By.xpath("//h1[normalize-space()='Register']"));

        //2.20 Fill the mandatory fields
        sendTextElement(By.id("FirstName"), "Priyanka");
        sendTextElement(By.id("LastName"), "Korat");
        sendTextElement(By.id("Email"), "sanganipriyanka81@gmail.com");
        sendTextElement(By.id("Password"), "Admin@123");
        sendTextElement(By.id("ConfirmPassword"), "Admin@123");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        verifyElements("Registration not completed", "Your registration completed", By.xpath("//div[@class='result']"));

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //2.24 Verify the text “Shopping cart”
        verifyElements("Not the shopping cart", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(5000);

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
        //2.27  Fill the Mandatory fields
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "133");
        sendTextElement(By.id("BillingNewAddress_City"), "Amazpn");
        sendTextElement(By.id("BillingNewAddress_Address1"), "Haunted ");
        sendTextElement(By.id("BillingNewAddress_ZipPostalCode"), "KT20");
        sendTextElement(By.id("BillingNewAddress_PhoneNumber"), "1234567890");
        //2.28  Click on “CONTINUE”
        clickOnElement(By.name("save"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.cssSelector(".button-1.shipping-method-next-step-button"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(2000);
        clickOnElement(By.cssSelector("button[class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown
        clickOnElement(By.xpath("//select[@id='CreditCardType']"));
        selectByTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");

        //2.33 Fill all the details
        //Enter cardholder name
        Thread.sleep(2000);
        sendTextElement(By.id("CardholderName"), "Priyanka Korat");
        //card number
        sendTextElement(By.id("CardNumber"), "4242424242424242");
        // Expire date
        selectByTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "03");
        // Expire Year
        selectByTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        // Card code
        sendTextElement(By.xpath("//input[@id='CardCode']"), "123");

        // 2.34 Click on “CONTINUE”
        clickOnElement(By.cssSelector(".button-1.payment-info-next-step-button"));

        //2.35 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("Credit Card", getTextFromTheElement(By.xpath("//span[contains(text(),'Credit Card')]")));

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals("2nd Day Air", getTextFromTheElement(By.xpath("//li[@class='shipping-method']//span[contains(text(),'2nd Day Air')]")));

        //2.37 Verify Total is “$698.00”
        Assert.assertEquals("$698.00", getTextFromTheElement(By.xpath("//span[@class='product-subtotal']")));

        // 2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.39 Verify the Text “Thank You”
        Assert.assertEquals("Thank you", getTextFromTheElement(By.xpath("//h1[text()='Thank you']")));

        //2.40 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Your order has been successfully processed!", getTextFromTheElement(By.xpath("//strong[text()='Your order has been successfully processed!']")));

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.42 Verify the text “Welcome to our store”
        Assert.assertEquals("Welcome to our store", getTextFromTheElement(By.xpath("//h2[text()='Welcome to our store']")));

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[text()='Log out']"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        Assert.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


