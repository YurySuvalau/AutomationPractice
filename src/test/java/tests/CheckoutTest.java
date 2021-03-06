package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
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
                .


}
