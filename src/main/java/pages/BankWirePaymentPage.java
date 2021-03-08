package pages;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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
            Assert.fail(String.format("Bank wire payment page is not loaded! Locator: '%s' was not found!", ORDER_SUM));
        }
        return this;
    }

    @Step("Click to Confirm my order on order confirmation page")
    public OrderConfirmationPage clickOnIConfirmMyOrderBtn() {
        driver.findElement(I_CONFIRM_MY_ORDER_BTN).click();
        return new OrderConfirmationPage(driver);
    }
}
