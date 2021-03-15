package pages;

import constants.Constants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class MainPage extends BasePage implements Constants {
    private static final String ITEM_PRICE = "//*[@id='homefeatured']//*[contains(text(),'%s')]/ancestor::*[@class='product-container']//*[@class='right-block']//*[contains(@class,'product-price')]";
    private static final By DRESS_BTN = By.xpath("//*[contains(@class,'sf-js-enabled')]/*/*[@title='Dresses']");
    private static final String ITEM_NAME_MAIN_PAGE = "//*[@id='homefeatured']//*[@class='product-container']//*[@class='product-name'][normalize-space(text())='%s']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DRESS_BTN));
        } catch (TimeoutException exception) {
            log.error(String.format("Main page it's not loaded! Locator: '%s' was not found!", DRESS_BTN));
        }
        return this;
    }

    @Step("Open main page")
    public MainPage openPage() {
        log.info("Url " + URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_MAIN_PAGE + " is loaded");
        driver.get(URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE);
        return this;
    }

    @Step("Get url address on main page")
    public String getUrl() {
        log.info("Get current url address, on main page");
        return driver.getCurrentUrl();
    }

    @Step("Click on 'Dress' button on main page")
    public CategoryPage clickOnDressBtn() {
        log.info("Click on button 'Dress' on main page, locator is " + DRESS_BTN);
        driver.findElement(DRESS_BTN).click();
        return new CategoryPage(driver);
    }

    @Step("Get {itemName} price on main page ")
    public String getItemPrice(String itemName, int index) {
        log.info("Get item price for " + itemName + " on main page, locator is: " + ITEM_PRICE);
        return driver.findElements(By.xpath(String.format(ITEM_PRICE, itemName))).get(index).getText().trim();
    }

    @Step("Click on product {itemName} on main page")
    public ProductPage clickOnItem(String itemName, int index) {
        log.info("Click on item " + itemName + " on main page, locator is: " + ITEM_NAME_MAIN_PAGE);
        driver.findElements(By.xpath(String.format(ITEM_NAME_MAIN_PAGE, itemName))).get(index).click();
        return new ProductPage(driver);
    }
}
