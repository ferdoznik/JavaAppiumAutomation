package lib.ui;

import io.appium.java_client.AppiumDriver;

public class RIESLoginPageObject extends MainPageObject
{
    private static final String
    LOGIN_FILED = "xpath://android.widget.TextView[@content-desc='Login']",
    PASSWORD_FILED = "xpath://android.widget.TextView[@content-desc='Password']",
    LOGIN_BUTTON = "id:com.riesapp:id/authButton";

    public RIESLoginPageObject(AppiumDriver driver)
    {
        super(driver);
    }
    public void waitForLoginButton()
    {
        this.waitForElementPresent(LOGIN_BUTTON,"Cannot see Login button",15);
    }
    public void enterRIESLogin()
    {
        this.waitForElementAndSendKeys(LOGIN_FILED,"18858","Cannot see and send login", 10);
    }
    public void enterRIESPassword()
    {
        this.waitForElementAndSendKeys(PASSWORD_FILED,"20231","Cannot see and send password", 10);
    }
    public void clickLOGINButton()
    {
        this.waitForElementAndClick(LOGIN_BUTTON,"Cannot find and click LOGIN button",10);
    }
}
