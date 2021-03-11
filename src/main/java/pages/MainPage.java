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
    private static final String ITEM_PRICE = "//*[@id='homefeatured']//*[contains(text(),'%s')]/ancestor::*[@class='product-container']//*[@class='right-block']//*[contains(@class, 'product-price']";
    private static final By DRESS_BTN = By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/*/*[@title='Dresses']");
    private static final String ITEM_NAME_IN_CART = "//*[contains(@class,'cart_item')]//*[contains(text(),'%s')]";
    private static final String ITEM_NAME_MAIN_PAGE = "//*[@id='homefeatured']//*[@class='product-container']//*[@class='product-name'][normalize-space(text())='%s']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DRESS_BTN));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Main page it's not loaded! Locator: '%s' was not found!", DRESS_BTN));
        }
        return this;
    }

    @Step("Open main page")
    public MainPage openPage() {
        driver.get(URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE);
        return this;
    }

    @Step("Get url address on main page")
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Click on 'Dress' button on main page")
    public CategoryPage clickOnDressBtn() {
        driver.findElement(DRESS_BTN).click();
        return new CategoryPage(driver);
    }

    @Step("Get item price on main page ")
    public String getItemPrice(String itemName, int index) {
        return driver.findElements(By.xpath(String.format(ITEM_PRICE, itemName))).get(index).getText().trim();
    }

    @Step("Click on product {itemName} on main page")
    public ProductPage clickOnItem(String itemName, int index) {
        driver.findElements(By.xpath(String.format(ITEM_NAME_MAIN_PAGE, itemName))).get(index).click();
        return new ProductPage(driver);
    }

}
