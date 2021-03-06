package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CartTest extends BaseTest {
    @Test
    public void addProductInShoppingCart() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened();
        mainPage.openPage()
                .enterToBlouseItem()
                .selectWhiteColorOfItem()
                .addToCart()
                .proceedToCheckoutClick()
                .waitForPageOpened();
        Assert.assertEquals(cartPage.getItemName(), "Blouse");
        Assert.assertEquals(cartPage.getUnitPrice(), "$27.00");
        Assert.assertEquals(cartPage.getUnitQuantity(), "1");
    }

    @Test
    public void getDiscountInCart() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnPrintedSummerDress()
                .addToCart()
                .proceedToCheckoutClick()
                .addQuantityButtonClick();
        Assert.assertEquals(cartPage.getDiscount(), "-5%");
    }

    @Test
    public void deleteProductFromCart() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnPrintedSummerDress()
                .addToCart()
                .proceedToCheckoutClick()
                .getItemNameInCart()
                .deleteBtnClick();
        Assert.assertTrue(cartPage.isDisplayedEmptyCartMessage());
    }
}
