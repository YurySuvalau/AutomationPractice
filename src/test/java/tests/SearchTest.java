package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class SearchTest extends BaseTest {
    @Test(description = "Searching product 'Summer Dress'")
    public void searchTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened()
                .searchItem("Summer Dress")
                .waitForPageOpened();
        Assert.assertTrue(searchPage.getListAfterSearch());
    }
}
