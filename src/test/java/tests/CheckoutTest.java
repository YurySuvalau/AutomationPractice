package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test(description = "Buying product 'Printed Summer Dress' by Bank Wire")
    public void buyProductByBankWire() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnPrintedSummerDress()
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
                .clickOnIConfirmMyOrder()
                .waitForPageOpened();
        Assert.assertEquals(orderConfirmationPage.getOrderSum(), "$30.98");
        Assert.assertTrue(orderConfirmationPage.getOrderConfirmationMessage());
    }
}
