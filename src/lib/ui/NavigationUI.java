package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject{

    protected static String
            MY_LISTS_LINK,
            CLOSE_BUTTON,
            SAVE_FOR_LATER;


    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot find My lists",
                5);
    }
    public void clickSavedAndClose()
    {
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot click Save for later",
                5
        );
        this.waitForElementAndClick(
                CLOSE_BUTTON,
                "Cannot find and press X button",
                2);
    }

}
