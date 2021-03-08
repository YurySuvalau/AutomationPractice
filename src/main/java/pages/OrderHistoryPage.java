package pages;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OrderHistoryPage extends BasePage implements Constants {
    private static final By ORDER_NUMBER = By.xpath("//*[@class='color-myaccount']");
    public static final By PRODUCT_INFO = By.xpath("//*[@class='bold']");

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OrderHistoryPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_NUMBER));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Order history page it's not loaded! Locator: '%s' was not found!", ORDER_NUMBER));
        }
        return this;
    }

    @Step("Click on order number on order history page")
    public OrderHistoryPage clickOnOrderNumber() {
        driver.findElement(ORDER_NUMBER).click();
        return this;
    }

    @Step("Check product name on order history page")
    public boolean checkProductName() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_INFO));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Product info is not displayed! Locator: '%s' was not found!", PRODUCT_INFO));
        }
        return driver.findElement(PRODUCT_INFO).getText().contains("Printed Summer Dress");
    }
}
