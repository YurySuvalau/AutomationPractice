package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.TestItem;
import utils.PropertyReader;

public class CheckoutTest extends BaseTest {

    @Test(description = "Buying product 'Printed Summer Dress' by Bank Wire", groups = "Smoke tests")
    public void buyProductByBankWire() {
        TestItem item = new TestItem();
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage();
        item.getItemPrintedSummerDress().setItemPrice(mainPage.getItemPrice("Printed Summer Dress", 0));
        mainPage.clickOnItem("Printed Summer Dress", 0);
        productPage.addToCart()
                .waitForPageOpened()
                .proceedToCheckoutClick()
                .waitForPageOpened();
        item.getItemPrintedSummerDress().setItemQuantity(cartPage.getUnitQuantity());
        item.getItemPrintedSummerDress().setItemShippingCost(cartPage.getShippingPrice());
        cartPage.clickProceedToCheckout()
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
        Assert.assertTrue(orderConfirmationPage.getOrderConfirmationMessage());
    }
}
