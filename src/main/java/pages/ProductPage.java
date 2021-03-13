package pages;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductPage extends BasePage implements Constants {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static final By ADD_TO_CART_BUTTON = By.name("Submit");
    private static final By SELECT_COLOR_WHITE = By.name("White");
    private static final By WISHLIST_BTN = By.xpath("//*[@id='wishlist_button']");
    private static final By CLOSE_MESSAGE_ADDED_TO_WISHLIST = By.xpath("//*[@title='Close']");
    private static final By MESSAGE_ADDED_TO_WISHLIST = By.xpath("//*[@class='fancybox-skin']");
    private static final By QUANTITY_IN_PRODUCT_CART = By.xpath("//input[@id='quantity_wanted']");
    private static final By DISCOUNT = By.xpath("//span[@id='reduction_percent_display']");

    @Override
    public ProductPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BUTTON));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("ProductPage it's not loaded! Locator: '%s' was not found!", ADD_TO_CART_BUTTON));
        }
        return this;
    }

    @Step("Open product page")
    public ProductPage openPage() {
        driver.get(URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_PRODUCTS_PAGE);
        return this;
    }

    @Step("Select 'white' color of product on product page")
    public ProductPage selectWhiteColorOfItem() {
        driver.findElement(SELECT_COLOR_WHITE).click();
        return this;
    }

    @Step("Click 'Add to cart' button on product page")
    public AddedProductModalPage addToCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new AddedProductModalPage(driver);
    }

    @Step("Click on 'Wishlist' button on product page")
    public ProductPage wishlistClick() {
        driver.findElement(WISHLIST_BTN).click();
        return this;
    }

    @Step("Close pop-up message on product page")
    public ProductPage closeMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ADDED_TO_WISHLIST));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Message is not displayed! Locator: '%s' was not found!", MESSAGE_ADDED_TO_WISHLIST));
        }
        driver.findElement(CLOSE_MESSAGE_ADDED_TO_WISHLIST).click();
        return this;
    }

    @Step("Get quantity on product page")
    public String getQuantity() {
        return driver.findElement(QUANTITY_IN_PRODUCT_CART).getAttribute("value");
    }

    @Step("Get discount on product page")
    public String getDiscount() {
        return driver.findElement(DISCOUNT).getText();
    }
}
