package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void enterAllDataOnLoginPage() {
        loginPage.openPage()
                .enterLoginData(EMAIL, PASSWORD);
        Assert.assertEquals(mainPage.getUrl(), "http://automationpractice.com/index.php?controller=my-account");
    }

    @Test
    public void loginWithEmptyPassField() {
        loginPage.openPage()
                .enterLoginData(EMAIL, "");
        Assert.assertTrue(loginPage.requiredPswrdMessage());
    }

}
