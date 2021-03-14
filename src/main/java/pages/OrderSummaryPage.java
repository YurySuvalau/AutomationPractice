package pages;

import constants.Constants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class OrderSummaryPage extends BasePage implements Constants {
    private static final By PROCEED_TO_CHECKOUT_BTN = By.xpath("//*[@class='cart_navigation clearfix']//*[@title='Proceed to checkout']//span");

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OrderSummaryPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_TO_CHECKOUT_BTN));
        } catch (TimeoutException exception) {
            log.error(String.format("Order summary it's not loaded! Locator: '%s' was not found!", PROCEED_TO_CHECKOUT_BTN));
        }
        return this;
    }
}
