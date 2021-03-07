package pages;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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
            Assert.fail(String.format("Cart page is not loaded! Locator: '%s' was not found!", PROCEED_TO_CHECKOUT_BTN));
        }
        return this;
    }

    @Step("Click to Proceed to Checkout")
    public ShippingCheckoutPage clickProceedToCheckoutBtn() {
        driver.findElement(PROCEED_TO_CHECKOUT_BTN).click();
        return new ShippingCheckoutPage(driver);
    }
}
