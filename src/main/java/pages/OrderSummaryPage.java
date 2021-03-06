package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OrderSummaryPage extends BasePage implements Constants {
    private static final By PROCEED_TO_CHECKOUT_BTN = By.xpath("//*[@class='cart_navigation clearfix']//*[@title='Proceed to checkout']//span");
    private static final By TOTAL_PRICE = By.xpath("//*[@id='amount'][text()='$30.98']");
    private static final By ORDER_COMPLETE_MESSAGE = By.xpath("//*[@class='cheque-indent']");

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OrderSummaryPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_TO_CHECKOUT_BTN));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Order it's not loaded! Locator: '%s' was not found!", PROCEED_TO_CHECKOUT_BTN));
        }
        return this;
    }

    public ShippingCheckoutPage clickOnProceedToCheckoutBtn() {
        driver.findElement(PROCEED_TO_CHECKOUT_BTN).click();
        return new ShippingCheckoutPage(driver);
    }

}
