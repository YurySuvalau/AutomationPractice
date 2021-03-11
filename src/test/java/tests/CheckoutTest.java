package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class CheckoutTest extends BaseTest {
    @Test(description = "Buying product 'Printed Summer Dress' by Bank Wire")
    public void buyProductByBankWire() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnItem("Printed Summer Dress",0)
                .addToCart()
                .proceedToCheckoutClick()
                .clickProceedToCheckout()
                .waitForPageOpened()
                .clickProceedToCheckoutBtn()
                .waitForPageOpened()
                .clickShippingOptionCheckbox()
                .clickProceedToCheckoutBtn()
                .waitForPageOpened()
                .clickOnPayByBankWire()
                .waitForPageOpened()
                .clickOnIConfirmMyOrderBtn()
                .waitForPageOpened();
        Assert.assertEquals(orderConfirmationPage.getOrderSum(), getItemPrintedSummerDress().getItemTotalCost());
        Assert.assertTrue(orderConfirmationPage.getOrderConfirmationMessage());
    }
}
