package pages;

import constants.Constants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
            log.error(String.format("Shipping page it's not loaded! Locator: '%s' was not found!", PROCEED_TO_CHECKOUT_BTN));
        }
        return this;
    }

    @Step("Click on 'Shipping option' checkbox on shipping page")
    public ShippingCheckoutPage clickShippingOptionCheckbox() {
        log.info("Click on checkbox 'Shipping option' on on shipping page, locator is " + SHIPPING_OPTION_CHECKBOX);
        driver.findElement(SHIPPING_OPTION_CHECKBOX).click();
        return this;
    }

    @Step("Click 'Proceed to checkout' button on shipping page")
    public PaymentCheckoutPage clickProceedToCheckoutBtn() {
        log.info("Click on button proceed to checkout on shipping page, locator: " + PROCEED_TO_CHECKOUT_BTN);
        driver.findElement(PROCEED_TO_CHECKOUT_BTN).click();
        return new PaymentCheckoutPage(driver);
    }
}
