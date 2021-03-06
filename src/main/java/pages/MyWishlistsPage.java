package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MyWishlistsPage extends BasePage implements Constants {
    private static final By WISHLIST_NAME = By.xpath("//*[normalize-space(text())='My wishlist']");
    private static final By PRINTED_SUMMER_DRESS = By.xpath("//*[@id='block-order-detail']//*[normalize-space(text())='Printed Summer Dress']");

    public MyWishlistsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MyWishlistsPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(WISHLIST_NAME));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Wishlist page it's not loaded! Locator: '%s' was not found!", WISHLIST_NAME));
        }
        return this;
    }

    public MyWishlistsPage myWishlistNameClick() {
        driver.findElement(WISHLIST_NAME).click();
        return this;
    }

    public boolean isDisplayedPrintedSummerDress() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRINTED_SUMMER_DRESS));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Wishlist it's not loaded! Locator: '%s' was not found!", PRINTED_SUMMER_DRESS));
        }
        return driver.findElement(PRINTED_SUMMER_DRESS).isDisplayed();
    }
    public MyWishlistsPage openPage() {
        driver.get(URL + URL_MAIN_PAGE+URL_MY_WISHLISTS);
        return this;
    }


}
