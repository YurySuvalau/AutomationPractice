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
public class BankWirePaymentPage extends BasePage implements Constants {
    private static final By ORDER_SUM = By.xpath("//*[@class='box cheque-box']//span[@class='price']");
    private static final By I_CONFIRM_MY_ORDER_BTN = By.xpath("//*[contains(@class, 'button-medium')][@type='submit']");

    public BankWirePaymentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BankWirePaymentPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_SUM));
        } catch (TimeoutException exception) {
            log.error(String.format("Bank wire payment page is not loaded! Locator: '%s' was not found!", ORDER_SUM));
        }
        return this;
    }

    @Step("Click to Confirm my order on order confirmation page")
    public OrderConfirmationPage clickOnIConfirmMyOrderBtn() {
        log.info("Not found button 'I Confirm My Order' on bank wire payment page, locator is " + I_CONFIRM_MY_ORDER_BTN + " ");
        driver.findElement(I_CONFIRM_MY_ORDER_BTN).click();
        return new OrderConfirmationPage(driver);
    }
}
