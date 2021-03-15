package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;


public class CartTest extends BaseTest {

    @Test(description = "Add product 'Blouse' to shopping cart", groups = "Smoke tests")
    public void addProductToShoppingCart() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage();
        getItemBlouse().setItemPrice(mainPage.getItemPrice("Blouse", 0));
        mainPage.clickOnItem("Blouse", 0);
        getItemBlouse().setItemQuantity(productPage.getQuantity());
        productPage.addToCart()
                .proceedToCheckoutClick()
                .waitForPageOpened();
        Assert.assertEquals(cartPage.getUnitPrice(), getItemBlouse().getItemPrice());
        Assert.assertEquals(cartPage.getUnitQuantity(), getItemBlouse().getItemQuantity());
    }

    @Test(description = "Increase quantity on product 'Printed Summer Dress' in shopping cart by click on button '+' and check total cost", groups = "Smoke tests")
    public void getTotalCost() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnItem("Printed Summer Dress", 1)
                .waitForPageOpened();
        getItemPrintedSummerDress().setItemPrice(productPage.getItemPriceOnProductPage());
        productPage.addToCart()
                .waitForPageOpened()
                .proceedToCheckoutClick()
                .waitForPageOpened()
                .addQuantityButtonClick();
        getItemPrintedSummerDress().setItemShippingCost(cartPage.getShippingPrice());
        Assert.assertEquals(cartPage.getTotalPrice(), cartPage.getExpectedItemPrice(getItemPrintedSummerDress().getItemPrice()) +
                cartPage.getExpectedShippingPrice(getItemPrintedSummerDress().getItemShippingCost()));
    }

    @Test(description = "Delete product 'Printed Summer Dress' from shopping cart", groups = "Smoke tests")
    public void deleteProductFromCart() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnItem("Printed Summer Dress", 0)
                .addToCart()
                .proceedToCheckoutClick()
                .getItemNameInCart()
                .deleteBtnClick();
        Assert.assertTrue(cartPage.isDisplayedEmptyCartMessage());
    }

    @Test(description = "Check discount in shopping cart after changing quantity of products in shopping cart", groups = "Smoke tests")
    public void getDiscount() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnItem("Printed Summer Dress", 0)
                .addToCart()
                .proceedToCheckoutClick()
                .waitForPageOpened();
        getItemPrintedSummerDress().setItemDiscount(cartPage.getDiscount());
        cartPage.addQuantityButtonClick()
                .waitDiscountLoaded();
        getItemPrintedSummerDress().setItemQuantity(cartPage.getUnitQuantity());
        Assert.assertEquals(cartPage.getUnitQuantity(), getItemPrintedSummerDress().getItemQuantity());
        Assert.assertEquals(cartPage.getDiscount(), getItemPrintedSummerDress().getItemDiscount());
    }
}
