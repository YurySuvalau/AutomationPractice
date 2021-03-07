package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Fill email and password, and login")
    public void enterAllDataOnLoginPage() {
        loginPage.openPage()
                .enterLoginData(EMAIL, PASSWORD);
        Assert.assertEquals(mainPage.getUrl(), "http://automationpractice.com/index.php?controller=my-account");
    }

    @Test(description = "Don't fill password field on the login page")
    public void loginWithEmptyPassField() {
        loginPage.openPage()
                .enterLoginData(EMAIL, "");
        Assert.assertTrue(loginPage.requiredPswrdMessage());
    }

}
