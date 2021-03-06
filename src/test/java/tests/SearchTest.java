package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test
    public void searchTest() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened()
                .searchItem()
                .waitForPageOpened();
        Assert.assertTrue(searchPage.getListAfterSearch());
    }
}
