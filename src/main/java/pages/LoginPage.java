package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage implements Constants {
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("passwd");
    private static final By SIGN_IN_BUTTON = By.id("SubmitLogin");
    private static final By REQUIRED_PASSWORD_MESSAGE = By.xpath("//*[normalize-space(text()) = 'Password is required.']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Login page in not loaded! Locator: '%s' was not found!", EMAIL_INPUT));
        }
        return this;
    }

    public LoginPage openPage() {
        driver.get(URL + URL_LOGIN_PAGE);
        return this;
    }

    public CustomerAccountPage enterLoginData(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new CustomerAccountPage(driver);
    }

    public void getUrl() {
        driver.getCurrentUrl();
    }

    public boolean requiredPswrdMessage() {
        return driver.findElement(REQUIRED_PASSWORD_MESSAGE).isDisplayed();
    }
}
