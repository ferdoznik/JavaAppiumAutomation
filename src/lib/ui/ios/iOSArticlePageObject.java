package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:View article in browser";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        POPOVER = "id:Tap to go back";
        LEAVE_ARTICLE_BUTTON = "id:Search";
        CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
        CLOSE_BUTTON = "id:Close";
        MY_SAVED_LIST = "id:Saved";
        CLEAR_TEXT_BUTTON = "id:Clear text";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
