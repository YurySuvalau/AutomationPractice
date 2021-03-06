package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OrderSummaryPage extends BasePage implements Constants {
    private static final By I_CONFIRM_MY_ORDER_BTN = By.xpath("//*[@class='button btn btn-default button-medium']");
    private static final By TOTAL_PRICE = By.xpath("//*[@id='amount'][text()='$30.98']");
    private static final By ORDER_COMPLETE_MESSAGE = By.xpath("//*[@class='cheque-indent']");

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OrderSummaryPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(I_CONFIRM_MY_ORDER_BTN));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Main page it's not loaded! Locator: '%s' was not found!", I_CONFIRM_MY_ORDER_BTN));
        }
        return this;
    }
}
