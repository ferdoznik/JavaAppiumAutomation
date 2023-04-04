package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject
{
    private static final String
    STEP_LEARN_MORE_LINK = "//XCUIElementTypeStaticText[@name='Learn more about Wikipedia']",
    STEP_NEW_WAYS_TO_EXPLORE = "//XCUIElementTypeStaticText[@name='New ways to explore']",
    STEP_SEARCH_300_LANG = "Search in nearly 300 languages",
    NEXT_BUTTON = "//XCUIElementTypeButton[@name='Next']",
    GET_STARTED = "//XCUIElementTypeButton[@name='Get started']";
    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }
    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(By.xpath(STEP_LEARN_MORE_LINK),"Dont see the welcome link",5);
    }
    public void clickNextButton()
    {
        this.waitForElementAndClick(By.xpath(NEXT_BUTTON),"Cannot find and click Next button",5);
    }
    public void waitForNewWaysToExplore()
    {
        this.waitForElementPresent(By.xpath(STEP_NEW_WAYS_TO_EXPLORE),"Dont see New ways to explore",5);
    }
    public void clickNextButtonSecondTime()
    {
        this.waitForElementAndClick(By.xpath(NEXT_BUTTON),"Cannot find and click Next button",5);
    }
    public void waitForSearchInNearly300Languages()
    {
        this.waitForElementPresent(By.id(STEP_SEARCH_300_LANG),"Dont see Search in nearly 300 languages link",5);
    }
    public void clickNextButtonThirdTime()
    {
        this.waitForElementAndClick(By.xpath(NEXT_BUTTON),"Cannot find and click Next button",5);
    }
    public void clickGetStarted()
    {
        this.waitForElementAndClick(By.xpath(GET_STARTED),"Cannot find and click Get started button",5);
    }
}
