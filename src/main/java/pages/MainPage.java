package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPage extends BasePage implements Constants {
    private static final By BLACK_BLOUSE_ITEM = By.xpath("//*[@id='homefeatured']//*[@class='product-container']//*[@class='product-name'][contains(text(),'Blouse')]");
    private static final By PRINTED_SUMMER_DRESS = By.xpath("//*[@id='homefeatured']//*[contains(@class,'first-item-of-mobile-line')]//*[normalize-space(text())='Printed Summer Dress']");
    private static final By DRESS_BTN = By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/*/*[@title='Dresses']");
    private static final By SEARCH_INPUT = By.name("search_query");

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

    public ProductPage clickToBlouseItem() {
        driver.findElement(BLACK_BLOUSE_ITEM).click();
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

    public SearchPage searchItem() {
        driver.findElement(SEARCH_INPUT).sendKeys("Summer Dress");
        return new SearchPage(driver);
    }
}
