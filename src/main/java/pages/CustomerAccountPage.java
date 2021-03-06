package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class CustomerAccountPage extends BasePage implements Constants {
    private static final By ORDER_HISTORY_BTN = By.xpath("//*[@title='Orders']");
    private static final By WISHLISTS_BTN = By.xpath("//*[@title='My wishlists']");

    public CustomerAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CustomerAccountPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_HISTORY_BTN));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Customer account page is not loaded! Locator: '%s' was not found!", ORDER_HISTORY_BTN));
        }
        return this;
    }

    public CustomerAccountPage openPage() {
        driver.get(URL + URL_MAIN_PAGE + URL_ACCOUNT_PAGE);
        return this;
    }

    public MyWishlistsPage myWishlistsClick() {
        driver.findElement(WISHLISTS_BTN).click();
        return new MyWishlistsPage(driver);
    }
}
