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
public class AddressCheckoutPage extends BasePage implements Constants {
    private static final By PROCEED_TO_CHECKOUT_BTN = By.name("processAddress");

    public AddressCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AddressCheckoutPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_TO_CHECKOUT_BTN));
        } catch (TimeoutException exception) {
            log.error(String.format("Shipping page is not loaded! Locator: '%s' was not found!", PROCEED_TO_CHECKOUT_BTN));
        }
        return this;
    }

    @Step("Click to Proceed to Checkout on shipping checkout page")
    public ShippingCheckoutPage clickProceedToCheckoutBtn() {
        log.info("Click on button proceed to checkout on Address checkout page, locator: " + PROCEED_TO_CHECKOUT_BTN);
        driver.findElement(PROCEED_TO_CHECKOUT_BTN).click();
        return new ShippingCheckoutPage(driver);
    }
}
