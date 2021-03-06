package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterInCategoryTest extends BaseTest {
    @Test
    public void selectWhiteColorInFilter() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnDressBtn()
                .waitForPageOpened()
                .selectColorWhiteInFilter();
        Assert.assertFalse(categoryPage.isDisplayedLoadingLogo());
    }

    @Test
    public void selectSubcategoryCasualDress() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD)
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnDressBtn()
                .waitForPageOpened();
        Assert.assertEquals(categoryPage.getProductCount(), "Showing 1 - 5 of 5 items");
        categoryPage.clickCasualDressSubcategory();
        Assert.assertEquals(categoryPage.getProductCount(), "Showing 1 - 1 of 1 item");
    }
}

