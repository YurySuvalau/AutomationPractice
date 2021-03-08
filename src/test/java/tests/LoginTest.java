package tests;

import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class LoginTest extends BaseTest {

    @Test(description = "Fill email and password, and login")
    public void enterAllDataOnLoginPage() {
        loginPage.openPage()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        Assert.assertEquals(mainPage.getUrl(), Constants.URL+Constants.URL_MAIN_PAGE+Constants.URL_ACCOUNT_PAGE);
    }

    @Test(description = "Don't fill password field on login page")
    public void loginWithEmptyPassField() {
        loginPage.openPage()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password_is_null", PropertyReader.getProperty("password_is_null")));
        Assert.assertTrue(loginPage.requiredPasswordMessage());
    }
}
