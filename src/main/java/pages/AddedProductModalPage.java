package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AddedProductModalPage extends BasePage implements Constants {
    private static final By PROCEED_TO_CHECKOUT_BTN = By.xpath("//*[@title='Proceed to checkout']");
    private static final By CONTINUE_SHOPPING_BTN = By.xpath("//*[@title='Continue shopping']");

    public AddedProductModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AddedProductModalPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_TO_CHECKOUT_BTN));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Modal page is not loaded! Locator: '%s' was not found!", PROCEED_TO_CHECKOUT_BTN));
        }
        return this;
    }

    public CartPage proceedToCheckoutClick(){
        driver.findElement(PROCEED_TO_CHECKOUT_BTN).click();
        return new CartPage(driver);
    }

}
