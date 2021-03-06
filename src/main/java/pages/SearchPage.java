package pages;

import constants.Constants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

@Log4j2
public class SearchPage extends BasePage implements Constants {
    private static final By SEARCH_LABEL = By.xpath("//*[@class='navigation_page']");
    private static final By LIST_ITEM = By.xpath("//*[@class='product_list grid row']//*[@class='product-name']");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_LABEL));
        } catch (TimeoutException exception) {
            log.error(String.format("Search page it's not loaded! Locator: '%s' was not found!", SEARCH_LABEL));
        }
        return this;
    }

    public boolean getListAfterSearch() {
        log.info("Get list item after search, locator is: " + LIST_ITEM);
        List<WebElement> searchResult = driver.findElements(LIST_ITEM);
        for (WebElement webElement : searchResult) {
            return webElement.getText().trim().contains("Summer" + "Dress");
        }
        return false;
    }
}
