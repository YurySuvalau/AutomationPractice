package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterInCategoryTest extends BaseTest {
    @Test
    public void selectWhiteColorInFilter() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD);
        mainPage.openPage()
                .waitForPageOpened()
                .clickOnDressBtn()
                .waitForPageOpened()
                .selectColorWhiteInFilter();
        Assert.assertFalse(categoryPage.isDisplayedLoadingLogo());
    }

    @Test
    public void selectSubcategoryCasualDress() {
        loginPage.openPage()
                .waitForPageOpened()
                .enterLoginData(EMAIL, PASSWORD);
        mainPage.openPage()
                .waitForPageOpened()
                .clickOnDressBtn()
                .waitForPageOpened()
                .selectColorWhiteInFilter();
    }

