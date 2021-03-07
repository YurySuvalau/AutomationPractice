package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test(description = "Add product 'Blouse' to shopping cart")
    public void addProductToShoppingCart() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened();
        mainPage.openPage()
                .clickToBlouseItem()
                .selectWhiteColorOfItem()
                .addToCart()
                .proceedToCheckoutClick()
                .waitForPageOpened();
        Assert.assertEquals(cartPage.getItemName(), "Blouse");
        Assert.assertEquals(cartPage.getUnitPrice(), "$27.00");
        Assert.assertEquals(cartPage.getUnitQuantity(), "1");
    }

    @Test(description = "Check discount in shopping cart after changing quantity of products in shopping cart")
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

    @Test(description = "Delete product 'Printed Summer Dress' from shopping cart")
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

    @Test(description = "Increase quantity on product 'Printed Summer Dress' in shopping cart by click on button '+'")
    public void increaseQuantity() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnPrintedSummerDress()
                .addToCart()
                .proceedToCheckoutClick()
                .addQuantityButtonClick();
        Assert.assertEquals(cartPage.getTotalPrice(), "$59.96");
    }
}
