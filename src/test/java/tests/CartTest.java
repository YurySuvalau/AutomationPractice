package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class CartTest extends BaseTest {
    @Test(description = "Add product 'Blouse' to shopping cart")
    public void addProductToShoppingCart() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .clickToBlouseItem()
                .selectWhiteColorOfItem()
                .addToCart()
                .proceedToCheckoutClick()
                .waitForPageOpened();
        Assert.assertEquals(cartPage.getItemName(), getItemBlouse().getItemName());
        Assert.assertEquals(cartPage.getUnitQuantity(), getItemBlouse().getItemQuantity());
        Assert.assertEquals(cartPage.getUnitPrice(), getItemBlouse().getItemUnitPrice());
    }

    @Test(description = "Check discount in shopping cart after changing quantity of products in shopping cart")
    public void getDiscountInCart() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnPrintedSummerDress()
                .addToCart()
                .proceedToCheckoutClick()
                .addQuantityButtonClick();
        Assert.assertEquals(cartPage.getDiscount(), getItemPrintedSummerDress().getItemDiscount());
    }

    @Test(description = "Delete product 'Printed Summer Dress' from shopping cart")
    public void deleteProductFromCart() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
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
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnPrintedSummerDress()
                .addToCart()
                .proceedToCheckoutClick()
                .addQuantityButtonClick();
        Assert.assertEquals(cartPage.getTotalPrice(), getItemPrintedSummerDress().getItemTwoQuantity());
    }
}
