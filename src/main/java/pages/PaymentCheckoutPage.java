package pages;

import constants.Constants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Locale;

@Log4j2
public class PaymentCheckoutPage extends BasePage implements Constants {
    private static final By PAYMENT_BY_BANK_WIRE_BTN = By.xpath("//*[@class='bankwire']");

    public PaymentCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PaymentCheckoutPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PAYMENT_BY_BANK_WIRE_BTN));
        } catch (TimeoutException exception) {
            log.error(String.format("Payment checkout page it's not loaded! Locator: '%s' was not found!", PAYMENT_BY_BANK_WIRE_BTN));
        }
        return this;
    }

    @Step("Click on 'Pay by Bank wire' on payment checkout page")
    public BankWirePaymentPage clickOnPayByBankWire() {
        log.info("Click on button 'Pay for Bank wire' button on payment checkout page, locator is: " + PAYMENT_BY_BANK_WIRE_BTN);
        driver.findElement(PAYMENT_BY_BANK_WIRE_BTN).click();
        return new BankWirePaymentPage(driver);
    }
}


