package pages;

import constants.Constants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class ProductPage extends BasePage implements Constants {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static final By ADD_TO_CART_BUTTON = By.name("Submit");
    private static final By WISHLIST_BTN = By.xpath("//*[@id='wishlist_button']");
    private static final By CLOSE_MESSAGE_ADDED_TO_WISHLIST = By.xpath("//*[@title='Close']");
    private static final By MESSAGE_ADDED_TO_WISHLIST = By.xpath("//*[@class='fancybox-skin']");
    private static final By QUANTITY_IN_PRODUCT_CART = By.xpath("//input[@id='quantity_wanted']");
    private static final By ITEM_PRICE_ON_PRODUCT_PAGE = By.xpath("//*[@id='our_price_display']");

    @Override
    public ProductPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BUTTON));
        } catch (TimeoutException exception) {
            log.error(String.format("ProductPage it's not loaded! Locator: '%s' was not found!", ADD_TO_CART_BUTTON));
        }
        return this;
    }

    @Step("Open product page")
    public ProductPage openPage() {
        log.info("Url" + URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_PRODUCTS_PAGE + "is loaded");
        driver.get(URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_PRODUCTS_PAGE);
        return this;
    }

    @Step("Click 'Add to cart' button on product page")
    public AddedProductModalPage addToCart() {
        log.info("Click button 'Add to cart' on product page, locator is " + ADD_TO_CART_BUTTON);
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new AddedProductModalPage(driver);
    }

    @Step("Click on 'Wishlist' button on product page")
    public ProductPage wishlistClick() {
        log.info("Click button 'Wishlist' on product page, locator is " + WISHLIST_BTN);
        driver.findElement(WISHLIST_BTN).click();
        return this;
    }

    @Step("Close pop-up message on product page")
    public ProductPage closeMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ADDED_TO_WISHLIST));
        } catch (TimeoutException exception) {
            log.error(String.format("Message is not displayed! Locator: '%s' was not found!", MESSAGE_ADDED_TO_WISHLIST));
        }
        log.info("Click button 'Close' on pop-up message page, locator is " + CLOSE_MESSAGE_ADDED_TO_WISHLIST);
        driver.findElement(CLOSE_MESSAGE_ADDED_TO_WISHLIST).click();
        return this;
    }

    @Step("Get quantity on product page")
    public String getQuantity() {
        log.info("Get item quantity on product page, locator is: " + QUANTITY_IN_PRODUCT_CART);
        return driver.findElement(QUANTITY_IN_PRODUCT_CART).getAttribute("value");
    }

    @Step("Get item price on product page")
    public String getItemPriceOnProductPage() {
        log.info("Get item price on product page, locator is: " + ITEM_PRICE_ON_PRODUCT_PAGE);
        return driver.findElement(ITEM_PRICE_ON_PRODUCT_PAGE).getText();
    }
}

