package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class iOSNavigationUI extends NavigationUI
{
    static {
        MY_LISTS_LINK = "xpath://XCUIElementTypeButton[@name='Saved']";
        SAVE_FOR_LATER = "id:Save for later";
        CLOSE_BUTTON = "id:Close";
    }
    public iOSNavigationUI(AppiumDriver driver)
    {
        super(driver);
    }
}
