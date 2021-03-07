package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterInCategoryTest extends BaseTest {
    @Test(description = "Select 'white color' of product in category page")
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

    @Test(description = "Select subcategory 'Casual Dress' in category page")
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

