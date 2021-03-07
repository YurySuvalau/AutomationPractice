package pages;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class PaymentCheckoutPage extends BasePage implements Constants {
    private static final By PAYMENT_BY_BANK_WARE_BTN = By.xpath("//*[@class='bankwire']");

    public PaymentCheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PaymentCheckoutPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PAYMENT_BY_BANK_WARE_BTN));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Main page it's not loaded! Locator: '%s' was not found!", PAYMENT_BY_BANK_WARE_BTN));
        }
        return this;
    }

    @Step("Click on 'Pay by Bank wire'")
    public BankWirePaymentPage clickOnPayByBankWire() {
        driver.findElement(PAYMENT_BY_BANK_WARE_BTN).click();
        return new BankWirePaymentPage(driver);
    }
}


