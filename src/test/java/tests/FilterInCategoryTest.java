package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test_data.TestItem;
import utils.PropertyReader;

public class FilterInCategoryTest extends BaseTest {

    @Test(description = "Select 'white color' of product in category page", groups = "Smoke tests")
    public void selectWhiteColorInFilter() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .waitForPageOpened()
                .clickOnDressBtn()
                .waitForPageOpened()
                .selectColorWhiteInFilter();
        Assert.assertFalse(categoryPage.isDisplayedLoadingLogo());
    }

    @Test(description = "Select subcategory 'Casual Dress' in category page", groups = "Smoke tests")
    public void selectSubcategoryCasualDress() {
        TestItem item = new TestItem();
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        categoryPage.openPage()
                .waitForPageOpened();
        item.getItemProductCount().setProductCountOnCategoryPage(categoryPage.getProductCount());
                categoryPage.clickCasualDressSubcategory();
        Assert.assertNotEquals(categoryPage.getProductCount(), item.getItemProductCount().getProductCountOnCategoryPage());
    }
}

