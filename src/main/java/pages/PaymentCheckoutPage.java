package pages;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Locale;

public class PaymentCheckoutPage extends BasePage implements Constants {
    private static final By PAYMENT_BY_BANK_WARE_BTN = By.xpath("//*[@class='bankwire']");
    private static final By QUANTITY = By.xpath("//*[@class='cart_quantity text-center']//span");
    private static final By SHIPPING_PRICE = By.id("total_shipping");

    public PaymentCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PaymentCheckoutPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PAYMENT_BY_BANK_WARE_BTN));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Payment checkout page it's not loaded! Locator: '%s' was not found!", PAYMENT_BY_BANK_WARE_BTN));
        }
        return this;
    }

    @Step("Click on 'Pay by Bank wire' on payment checkout page")
    public BankWirePaymentPage clickOnPayByBankWire() {
        driver.findElement(PAYMENT_BY_BANK_WARE_BTN).click();
        return new BankWirePaymentPage(driver);
    }

    @Step("Get quantity on payment page")
    public String getQuantity() {
        return driver.findElement(QUANTITY).getText().trim();
    }

    @Step("Get total shipping price on payment page")
    public String getShippingPrice() {
        return driver.findElement(SHIPPING_PRICE).getText();
    }
}


