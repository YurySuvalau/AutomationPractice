package pages;

import constants.Constants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class CartPage extends BasePage implements Constants {

    private static final By PROCEED_TO_CHECKOUT_BTN = By.xpath("//*[contains(@class,'cart_navigation')]//*[contains(text(),'Proceed')]");
    private static final By QUANTITY_INPUT = By.xpath("//*[contains(@class, 'cart_quantity_input')]");
    private static final By UNIT_PRICE_IN_CART = By.xpath("//*[@class='cart_unit']//*[contains(@id,'product_price')]");
    private static final By TOTAL_PRICE = By.id("total_price");
    private static final By DISCOUNT = By.xpath("//*[contains(@class,'price-percent-reduction')]");
    private static final By ADD_QUANTITY_BUTTON = By.xpath("//*[contains(@class,'cart_quantity_up')]");
    private static final By DELETE_BTN = By.xpath("//*[@title='Delete']");
    private static final By ITEM_NAME_IN_CART = By.xpath("//*[@class='cart_description']//*[@class='product-name']");
    private static final By EMPTY_CART_MESSAGE = By.xpath("//*[@class='alert alert-warning']");
    private static final By SHIPPING_CART_CONTAINS_2_LABEL = By.xpath("//*[@id='summary_products_quantity'][text()='2 Products']");
    private static final By SHIPPING_COST = By.id("total_shipping");
    private static final By HIDDEN_QUANTITY = By.xpath("//input[contains(@name,'quantity')][@type='hidden']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_TO_CHECKOUT_BTN));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Cart page is not loaded! Locator: '%s' was not found!", PROCEED_TO_CHECKOUT_BTN));
        }
        return this;
    }

    @Step("Open shopping cart page")
    public CartPage openPage() {
        driver.get(URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_CART_PAGE);
        return this;
    }

    @Step("Get product name on cart page")
    public String getItemName() {
        return driver.findElement(ITEM_NAME_IN_CART).getText();
    }

    @Step("Get product unit price on cart page")
    public String getUnitPrice() {
        return driver.findElement(UNIT_PRICE_IN_CART).getText();
    }

    @Step("Get product quantity on cart page")
    public String getUnitQuantity() {
        return driver.findElement(QUANTITY_INPUT).getAttribute("value");
    }

    @Step("Get product shipping price")
    public String getShippingPrice() {
        return driver.findElement(SHIPPING_COST).getText();
    }

    @Step("Click to 'Add quantity button' on cart page")
    public CartPage addQuantityButtonClick() {
        driver.findElement(ADD_QUANTITY_BUTTON).click();
        return this;
    }

    @Step("Get discount on cart page")
    public String getDiscount() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DISCOUNT));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Label discount is not displayed! Locator: '%s' was not found!", DISCOUNT));
        }
        return driver.findElement(DISCOUNT).getText().trim();
    }

    public CartPage waitDiscountLoaded() {
        try {
            wait.until(ExpectedConditions.attributeToBe(HIDDEN_QUANTITY, "value", "2"));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Label discount is not displayed! Locator: '%s' was not found!", HIDDEN_QUANTITY));
        }
        return this;
    }

    @Step("Click on delete button on cart page")
    public CartPage deleteBtnClick() {
        driver.findElement(DELETE_BTN).click();
        return this;
    }

    @Step("Get item name on cart page")
    public CartPage getItemNameInCart() {
        driver.findElement(ITEM_NAME_IN_CART).getText();
        return this;
    }

    @Step("Get cart empty message on cart page")
    public boolean isDisplayedEmptyCartMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(EMPTY_CART_MESSAGE));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Message is not displayed! Locator: '%s' was not found!", EMPTY_CART_MESSAGE));
        }
        log.info("Empty cart message is displayed!");
        return driver.findElement(EMPTY_CART_MESSAGE).isDisplayed();
    }

    @Step("Click Proceed to checkout button on cart page ")
    public AddressCheckoutPage clickProceedToCheckout() {
        driver.findElement(PROCEED_TO_CHECKOUT_BTN).click();
        return new AddressCheckoutPage(driver);
    }

    @Step("Get total price on cart page")
    public String getTotalPrice() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SHIPPING_CART_CONTAINS_2_LABEL));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Label contains 2 products is not displayed! Locator: '%s' was not found!", SHIPPING_CART_CONTAINS_2_LABEL));
        }
        return driver.findElement(TOTAL_PRICE).getText();
    }
}
