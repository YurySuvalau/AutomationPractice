package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {
    @Test
    public void addProductToWishlist() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD);
        mainPage.openPage()
                .waitForPageOpened()
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
}
