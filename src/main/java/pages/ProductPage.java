package pages;

import constants.Constants;
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

    @Override
    public ProductPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BUTTON));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("ProductPage it's not loaded! Locator: '%s' was not found!", ADD_TO_CART_BUTTON));
        }
        return this;
    }

    public ProductPage openPage() {
        driver.get(URL + URL_MAIN_PAGE + URL_PRODUCTS_PAGE);
        return this;
    }

    public ProductPage selectWhiteColorOfItem() {
        driver.findElement(SELECT_COLOR_WHITE).click();
        return this;
    }

    public AddedProductModalPage addToCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return new AddedProductModalPage(driver);
    }

    public ProductPage wishlistClick() {
        driver.findElement(WISHLIST_BTN).click();
        return this;
    }

    public ProductPage closeMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ADDED_TO_WISHLIST));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Message is not displayed! Locator: '%s' was not found!", MESSAGE_ADDED_TO_WISHLIST));
        }
        driver.findElement(CLOSE_MESSAGE_ADDED_TO_WISHLIST).click();
        return this;
    }
}
