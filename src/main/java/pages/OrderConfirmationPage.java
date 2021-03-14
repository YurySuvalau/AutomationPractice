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
public class OrderConfirmationPage extends BasePage implements Constants {
    private static final By CONFIRM_ORDER_MESSAGE = By.xpath("//*[@class='cheque-indent']/*[@class='dark']");

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OrderConfirmationPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRM_ORDER_MESSAGE));
        } catch (TimeoutException exception) {
            log.error(String.format("Order it's not loaded! Locator: '%s' was not found!", CONFIRM_ORDER_MESSAGE));
        }
        return this;
    }

    @Step("Check for order confirmation message is displayed on order confirmation page")
    public boolean getOrderConfirmationMessage() {
        log.info("Confirmation message is displayed, locator is: " + CONFIRM_ORDER_MESSAGE);
        return driver.findElement(CONFIRM_ORDER_MESSAGE).isDisplayed();
    }
}
