package pages;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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
            Assert.fail(String.format("Wishlist page it's not loaded! Locator: '%s' was not found!", WHITE_COLOR_IN_FILTER));
        }
        return this;
    }

    @Step("Open category page")
    public CategoryPage openPage() {
        driver.get(URL + URL_MAIN_PAGE + URL_CATEGORY);
        return this;
    }

    @Step("Select 'white' color in category filter")
    public CategoryPage selectColorWhiteInFilter() {
        driver.findElement(WHITE_COLOR_IN_FILTER).click();
        return this;
    }

    @Step("Loading logo displayed")
    public boolean isDisplayedLoadingLogo() {
        return driver.findElement(LOADING_LOGO).isDisplayed();
    }

    @Step("Click on 'Casual Dress' category")
    public CategoryPage clickCasualDressSubcategory() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CASUAL_DRESS_SUBCATEGORY));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Category page is not loaded! Locator: '%s' was not found!", CASUAL_DRESS_SUBCATEGORY));
        }
        driver.findElement(CASUAL_DRESS_SUBCATEGORY).click();
        return this;
    }

    @Step("Get product count")
    public String getProductCount() {
        return driver.findElement(PRODUCT_COUNT).getText().trim();
    }
}
