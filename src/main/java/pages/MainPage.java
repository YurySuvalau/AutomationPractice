package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPage extends BasePage implements Constants {
    private static final By BLACK_BLOUSE_ITEM = By.xpath("//*[@id='homefeatured']//*[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line']//*[@class='replace-2x img-responsive']");
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

    public MainPage openPage() {
        driver.get(URL + URL_MAIN_PAGE);
        return this;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public ProductPage enterToBlouseItem() {
        new Actions(driver).moveToElement(driver.findElement(BLACK_BLOUSE_ITEM), 50, 50).click().build().perform();
        return new ProductPage(driver);
    }

    public ProductPage clickOnPrintedSummerDress() {
        driver.findElement(PRINTED_SUMMER_DRESS).click();
        return new ProductPage(driver);
    }

    public CategoryPage clickOnDressBtn() {
        driver.findElement(DRESS_BTN).click();
        return new CategoryPage(driver);
    }
}
