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
            log.error(String.format("Login page in not loaded! Locator: '%s' was not found!", EMAIL_INPUT));
        }
        return this;
    }

    @Step("Open login page")
    public LoginPage openPage() {
        log.info("Url" + URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_LOGIN_PAGE + "is loaded");
        driver.get(URL_AUTOMATIONPRACTICE + URL_LOGIN_PAGE);
        return this;
    }

    @Step("Enter email and password on login page")
    public CustomerAccountPage enterLoginData(String email, String password) {
        log.info("Click on field 'Email' on login page and send email address" + email + ", locator is " + EMAIL_INPUT);
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        log.info("Click on field 'Password' on login page, locator is " + PASSWORD_INPUT);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Click on button 'Sign in' on login page, locator is " + SIGN_IN_BUTTON);
        driver.findElement(SIGN_IN_BUTTON).click();
        return new CustomerAccountPage(driver);
    }

    @Step("Check message 'Required password' on login page")
    public boolean requiredPasswordMessage() {
        log.info("Message 'Required password' is displayed on login page, locator is " + REQUIRED_PASSWORD_MESSAGE);
        return driver.findElement(REQUIRED_PASSWORD_MESSAGE).isDisplayed();
    }
}
