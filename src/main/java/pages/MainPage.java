package pages;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPage extends BasePage implements Constants {
    private static final By BLACK_BLOUSE_ITEM = By.xpath("//*[@id='homefeatured']//*[@class='product-container']//*[@class='product-name'][contains(text(),'Blouse')]");
    private static final By PRINTED_SUMMER_DRESS = By.xpath("//*[@id='homefeatured']//*[contains(@class,'first-item-of-mobile-line')]//*[normalize-space(text())='Printed Summer Dress']");
    private static final By DRESS_BTN = By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/*/*[@title='Dresses']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BLACK_BLOUSE_ITEM));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Main page it's not loaded! Locator: '%s' was not found!", BLACK_BLOUSE_ITEM));
        }
        return this;
    }

    @Step("Open main page")
    public MainPage openPage() {
        driver.get(URL + URL_MAIN_PAGE);
        return this;
    }

    @Step("Get url address on main page")
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Click on product 'Blouse' on main page")
    public ProductPage clickToBlouseItem() {
        driver.findElement(BLACK_BLOUSE_ITEM).click();
        return new ProductPage(driver);
    }

    @Step("Click on product 'Printed Summer Dress' on main page")
    public ProductPage clickOnPrintedSummerDress() {
        driver.findElement(PRINTED_SUMMER_DRESS).click();
        return new ProductPage(driver);
    }

    @Step("Click on 'Dress' button on main page")
    public CategoryPage clickOnDressBtn() {
        driver.findElement(DRESS_BTN).click();
        return new CategoryPage(driver);
    }
}
