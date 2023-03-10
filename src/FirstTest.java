import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {
    private AppiumDriver driver;
    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformName","13.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/antonragozin/Desktop/JavaAppiumAutomation/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
//    @Test
//    public void firstTest()
//    {
//        waitForElementByXpathAndClick(
//                "//*[contains(@text,'Search Wikipedia')]",
//                "Cannot find search Wikipedia input",
//                5
//        );
//        waitForElementByXpathAndSendKeys(
//                "//*[contains(@text,'Search…')]",
//                "Java",
//                "Cannot find search input",
//                5
//        );
//        waitForElementPresentByXpath(
//                "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']",
//                "Cannot find topic searching by 'Java'",
//                15
//        );
//    }
    @Test
    public void testCancelSearch()
    {
        waitForElementByIdAndClick(
                "org.wikipedia:id/search_container",
                "Cannot find 'Search Wiki' input",
                5
        );
//        waitForElementByIdAndClick(
//                "org.wikipedia:id/search_close_btn",
//                "Cannot find 'X' to cancel search",
//                5
//        );
        waitForElementNotPresent(
                "org.wikipedia:id/search_close_btn",
                "Cannot find 'X' to cancel search",
                5
        );
    }
    private WebElement waitForElementPresentByXpath(String xpath, String error_message, long timeOutSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.xpath(xpath);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    private WebElement waitForElementPresentByXpath(String xpath, String error_message)
    {
        return waitForElementPresentByXpath(xpath, error_message,5);
    }
    private WebElement waitForElementByXpathAndClick(String xpath, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresentByXpath(xpath, error_message, timeoutInSeconds);
        element.click();
        return element;
    }
    private WebElement waitForElementByXpathAndSendKeys(String xpath, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresentByXpath(xpath, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }
    private WebElement waitForElementPresentById(String Id, String error_message, long timeOutSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.id(Id);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    private WebElement waitForElementByIdAndClick(String Id, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresentById(Id, error_message, timeoutInSeconds);
        element.click();
        return element;}
    private boolean waitForElementNotPresent(String id, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        By by = By.id(id);
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
}