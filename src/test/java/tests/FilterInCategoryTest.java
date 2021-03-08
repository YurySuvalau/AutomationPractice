package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class FilterInCategoryTest extends BaseTest {
    @Test(description = "Select 'white color' of product in category page")
    public void selectWhiteColorInFilter() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
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
                .enterLoginData(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .waitForPageOpened();
        mainPage.openPage()
                .clickOnDressBtn()
                .waitForPageOpened();
        Assert.assertEquals(categoryPage.getProductCount(), getItemProductCount().getProductCountFiveItem());
        categoryPage.clickCasualDressSubcategory();
        Assert.assertEquals(categoryPage.getProductCount(), getItemProductCount().getProductCountOneItem());
    }
}

