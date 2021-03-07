package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {
    @Test(description = "Add product to wishlist")
    public void addProductToWishlist() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnPrintedSummerDress()
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

    @Test(description = "Check product history after buying product")
    public void checkOrderHistory() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnPrintedSummerDress()
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
                .clickOnIConfirmMyOrder()
                .waitForPageOpened();
        customerAccountPage.openPage()
                .waitForPageOpened()
                .clickOnOrderHistoryBtn()
                .waitForPageOpened()
                .clickOnOrderNumber();
        Assert.assertTrue(orderHistoryPage.checkProductName());
    }
}
