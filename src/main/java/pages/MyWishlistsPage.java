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
            log.error(String.format("Wishlist page it's not loaded! Locator: '%s' was not found!", WISHLIST_NAME));
        }
        return this;
    }

    @Step("Click on wishlist name on wishlist page")
    public MyWishlistsPage myWishlistNameClick() {
        log.info("Click on wishlist link name, locator is: " + WISHLIST_NAME);
        driver.findElement(WISHLIST_NAME).click();
        return this;
    }

    @Step("Check for 'Printed Summer Dress' is displayed")
    public boolean isDisplayedPrintedSummerDress() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRINTED_SUMMER_DRESS));
        } catch (TimeoutException exception) {
            log.error(String.format("Wishlist it's not loaded! Locator: '%s' was not found!", PRINTED_SUMMER_DRESS));
        }
        log.info("Item is displayed, locator: " + PRINTED_SUMMER_DRESS);
        return driver.findElement(PRINTED_SUMMER_DRESS).isDisplayed();
    }

    @Step("Open my wishlist page")
    public MyWishlistsPage openPage() {
        log.info("Url " + URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_MY_WISHLISTS + " is loaded");
        driver.get(URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_MY_WISHLISTS);
        return this;
    }
}
