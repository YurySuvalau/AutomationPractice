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
public class CategoryPage extends BasePage implements Constants {
    private static final By WHITE_COLOR_IN_FILTER = By.name("layered_id_attribute_group_8");
    private static final By LOADING_LOGO = By.xpath("//*[@class='product_list grid row']//*[@src='http://automationpractice.com/img/loader.gif']");
    private static final By CASUAL_DRESS_SUBCATEGORY = By.xpath("//*[@id='subcategories']//*[@title='Casual Dresses']");
    private static final By PRODUCT_COUNT = By.xpath("//*[@class='top-pagination-content clearfix']//*[@class='product-count']");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CategoryPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(WHITE_COLOR_IN_FILTER));
        } catch (TimeoutException exception) {
            log.error(String.format("Category page it's not loaded! Locator: '%s' was not found!", WHITE_COLOR_IN_FILTER));
        }
        return this;
    }

    @Step("Open category page")
    public CategoryPage openPage() {
        log.info("Url" + URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_CATEGORY + "is loaded");
        driver.get(URL_AUTOMATIONPRACTICE + URL_MAIN_PAGE + URL_CATEGORY);
        return this;
    }

    @Step("Select 'white' color in category filter on category page")
    public CategoryPage selectColorWhiteInFilter() {
        log.info("Select color in filter, locator is " + WHITE_COLOR_IN_FILTER);
        driver.findElement(WHITE_COLOR_IN_FILTER).click();
        return this;
    }

    @Step("'Loading' logo displayed on category page")
    public boolean isDisplayedLoadingLogo() {
        log.info("Loading logo is displayed, locator is: " + LOADING_LOGO);
        return driver.findElement(LOADING_LOGO).isDisplayed();
    }

    @Step("Click on 'Casual Dress' category on category page")
    public CategoryPage clickCasualDressSubcategory() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CASUAL_DRESS_SUBCATEGORY));
        } catch (TimeoutException exception) {
            log.error(String.format("Category page is not loaded! Locator: '%s' was not found!", CASUAL_DRESS_SUBCATEGORY));
        }
        log.info("Select subcategory 'Casual dress' on category page, locator is " + CASUAL_DRESS_SUBCATEGORY);
        driver.findElement(CASUAL_DRESS_SUBCATEGORY).click();
        return this;
    }

    @Step("Get 'Product count' on category page")
    public String getProductCount() {
        log.info("Get product count on category page, locator is: " + PRODUCT_COUNT);
        return driver.findElement(PRODUCT_COUNT).getText().trim();
    }
}
