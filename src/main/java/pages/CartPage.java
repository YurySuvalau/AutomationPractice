package pages;

import constants.Constants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
            log.error(String.format("Cart page is not loaded! Locator: '%s' was not found!", PROCEED_TO_CHECKOUT_BTN));
        }
        return this;
    }

    @Step("Open shopping cart page")
    public CartPage openPage() {
        log.info("Url" + URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_CART_PAGE + "is loaded");
        driver.get(URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_CART_PAGE);
        return this;
    }

    @Step("Get product unit price on cart page")
    public String getUnitPrice() {
        log.info("Get field unit price on cart page, locator is " + UNIT_PRICE_IN_CART);
        return driver.findElement(UNIT_PRICE_IN_CART).getText();
    }

    @Step("Get product quantity on cart page")
    public String getUnitQuantity() {
        log.info("Get field unit quantity on cart page, locator is " + QUANTITY_INPUT);
        return driver.findElement(QUANTITY_INPUT).getAttribute("value");
    }

    @Step("Get product shipping price")
    public String getShippingPrice() {
        log.info("Get field shipping price on cart page, locator is " + SHIPPING_COST);
        return driver.findElement(SHIPPING_COST).getText();
    }

    @Step("Click to 'Add quantity button' on cart page")
    public CartPage addQuantityButtonClick() {
        log.info("Click button 'Add quantity' on cart page, locator is " + ADD_QUANTITY_BUTTON);
        driver.findElement(ADD_QUANTITY_BUTTON).click();
        return this;
    }

    @Step("Get discount on cart page")
    public String getDiscount() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DISCOUNT));
        } catch (TimeoutException exception) {
            log.error("Label discount is not displayed! Locator: '%s' was not found!", DISCOUNT);
        }
        log.info("Get field discount on cart page, locator is " + DISCOUNT);
        return driver.findElement(DISCOUNT).getText().trim();
    }

    public CartPage waitDiscountLoaded() {
        try {
            wait.until(ExpectedConditions.attributeToBe(HIDDEN_QUANTITY, "value", "2"));
        } catch (TimeoutException exception) {
            log.error("Discount is not displayed! Locator: '%s' was not found!", HIDDEN_QUANTITY);
        }
        return this;
    }

    @Step("Click on delete button on cart page")
    public CartPage deleteBtnClick() {
        log.info("Click button 'Delete' on cart page, locator is " + DELETE_BTN);
        driver.findElement(DELETE_BTN).click();
        return this;
    }

    @Step("Get item name on cart page")
    public CartPage getItemNameInCart() {
        log.info("Get field name on cart page, locator is " + ITEM_NAME_IN_CART);
        driver.findElement(ITEM_NAME_IN_CART).getText();
        return this;
    }

    @Step("Get cart empty message on cart page")
    public boolean isDisplayedEmptyCartMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(EMPTY_CART_MESSAGE));
        } catch (TimeoutException exception) {
            log.error("Message is not displayed! Locator: '%s' was not found!", EMPTY_CART_MESSAGE);
        }
        log.info("Get field name on cart page, locator is " + ITEM_NAME_IN_CART);
        return driver.findElement(EMPTY_CART_MESSAGE).isDisplayed();
    }

    @Step("Click Proceed to checkout button on cart page ")
    public AddressCheckoutPage clickProceedToCheckout() {
        log.info("Click button 'Proceed to checkout' on cart page, locator is " + PROCEED_TO_CHECKOUT_BTN);
        driver.findElement(PROCEED_TO_CHECKOUT_BTN).click();
        return new AddressCheckoutPage(driver);
    }

    @Step("Get total price on cart page")
    public double getTotalPrice() {
        log.info("Get field total price on cart page, locator is " + TOTAL_PRICE);
        return (Double.valueOf(driver.findElement(TOTAL_PRICE).getText().replace("$", "")));
    }

    @Step("Get expected item price on cart page")
    public double getExpectedItemPrice(String itemPrice) {
        log.info("Get expected price for" + itemPrice + "on cart page");
        return Double.valueOf(itemPrice.replace("$", ""));
    }

    @Step("Get expected shipping price on cart page")
    public double getExpectedShippingPrice(String itemPrice) {
        log.info("Get expected shipping price for" + itemPrice + "on cart page");
        return (Double.valueOf(itemPrice.replace("$", "")));
    }
}
