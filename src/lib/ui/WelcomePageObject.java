package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject
{
    private static final String
    STEP_LEARN_MORE_LINK = "//XCUIElementTypeStaticText[@name='Learn more about Wikipedia']",
    STEP_NEW_WAYS_TO_EXPLORE = "New ways to explore",
    STEP_SEARCH_300_LANG = "Search in nearly 300 languages",
    NEXT_BUTTON = "19000000-0000-0000-7682-000000000000",
    GET_STARTED = "80000000-0000-0000-7682-000000000000";
    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }
    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(By.xpath(STEP_LEARN_MORE_LINK),"Dont see the welcome link",10);
    }
    public void clickNextButton()
    {
        this.waitForElementAndClick(By.id(NEXT_BUTTON),"Cannot find and click Next button",10);
    }
    public void waitForNewWaysToExplore()
    {
        this.waitForElementPresent(By.id(STEP_NEW_WAYS_TO_EXPLORE),"Dont see New ways to explore",10);
    }
    public void clickNextButtonSecondTime()
    {
        this.waitForElementAndClick(By.id(NEXT_BUTTON),"Cannot find and click Next button",10);
    }
    public void waitForSearchInNearly300Languages()
    {
        this.waitForElementPresent(By.id(STEP_SEARCH_300_LANG),"Dont see Search in nearly 300 languages link",10);
    }
    public void clickGetStarted()
    {
        this.waitForElementAndClick(By.id(GET_STARTED),"Cannot find and click Get started button",10);
    }
}
