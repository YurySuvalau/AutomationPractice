package tests;

import Utils.CapabilitiesGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import pages.AddressCheckoutPage;
import pages.PaymentCheckoutPage;
import pages.ShippingCheckoutPage;
import test_data.TestConstants;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest implements TestConstants {
    WebDriver driver;
    AddressCheckoutPage addressCheckoutPage;
    PaymentCheckoutPage paymentCheckoutPage;
    ShippingCheckoutPage shippingCheckoutPage;
    AddedProductModalPage addedProductModalPage;
    CartPage cartPage;
    CustomerAccountPage customerAccountPage;
    LoginPage loginPage;
    MainPage mainPage;
    OrderSummaryPage orderSummaryPage;
    ProductPage productPage;
    MyWishlistsPage myWishlistsPage;
    CategoryPage categoryPage;

    @BeforeMethod
    public void createDriver(ITestContext context) {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (SessionNotCreatedException ex) {
            Assert.fail("Browser is not open. Make sure the driver version is up to date.");
        }

        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
        pageInit();
    }

    public void pageInit() {
        addressCheckoutPage = new AddressCheckoutPage(driver);
        paymentCheckoutPage = new PaymentCheckoutPage(driver);
        shippingCheckoutPage = new ShippingCheckoutPage(driver);
        addedProductModalPage = new AddedProductModalPage(driver);
        cartPage = new CartPage(driver);
        customerAccountPage = new CustomerAccountPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        productPage = new ProductPage(driver);
        myWishlistsPage = new MyWishlistsPage(driver);
        categoryPage = new CategoryPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

