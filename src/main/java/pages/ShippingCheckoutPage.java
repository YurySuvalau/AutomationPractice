package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ShippingCheckoutPage extends BasePage implements Constants {
    private static final By SHIPPING_OPTION_CHECKBOX = By.xpath("//*[@name='cgv']");
    private static final By PROCEED_TO_CHECKOUT_BTN = By.xpath("//*[@name='processCarrier']");

    public ShippingCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ShippingCheckoutPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_TO_CHECKOUT_BTN));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Main page it's not loaded! Locator: '%s' was not found!", PROCEED_TO_CHECKOUT_BTN));
        }
        return this;
    }
}
