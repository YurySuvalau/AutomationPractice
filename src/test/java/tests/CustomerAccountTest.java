package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class CustomerAccountTest extends BaseTest {

    @Test(description = "Add product to wishlist", groups = "Extended tests")
    public void addProductToWishlist() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnItem("Printed Summer Dress", 0)
                .waitForPageOpened()
                .wishlistClick()
                .closeMessage();
        customerAccountPage.openPage()
                .waitForPageOpened()
                .myWishlistsClick()
                .waitForPageOpened()
                .myWishlistNameClick();
        Assert.assertTrue(myWishlistsPage.isDisplayedPrintedSummerDress());
    }

    @Test(description = "Check product history after buying product", groups = "Extended tests")
    public void checkOrderHistory() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnItem("Printed Summer Dress", 0)
                .waitForPageOpened()
                .addToCart()
                .waitForPageOpened()
                .proceedToCheckoutClick()
                .waitForPageOpened()
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
        customerAccountPage.openPage()
                .waitForPageOpened()
                .clickOnOrderHistoryBtn()
                .waitForPageOpened()
                .clickOnOrderNumber();
        Assert.assertTrue(orderHistoryPage.checkProductName("Printed Summer Dress"));
    }
}
