package pages;

import constants.Constants;
import org.aspectj.weaver.ast.Or;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OrderConfirmationPage extends BasePage implements Constants {
    private static final By CONFIRM_ORDER_MESSAGE = By.xpath("//*[@class='cheque-indent']/*[@class='dark']");
    private static final By ORDER_SUM = By.xpath("//*[@class='price']");
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OrderConfirmationPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRM_ORDER_MESSAGE));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Order it's not loaded! Locator: '%s' was not found!", CONFIRM_ORDER_MESSAGE));
        }
        return this;
    }

    public boolean getOrderConfirmationMessage() {
        return driver.findElement(CONFIRM_ORDER_MESSAGE).isDisplayed();
    }
    public String getOrderSum(){
        return  driver.findElement(ORDER_SUM).getText();
    }
}
