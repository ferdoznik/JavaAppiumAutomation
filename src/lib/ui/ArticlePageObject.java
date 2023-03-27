package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class ArticlePageObject extends MainPageObject
{
    private static final String
    TITLE = "org.wikipedia:id/view_page_title_text",
    FOOTER_ELEMENT = "//*[@text='View page in browser']",
    OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
    ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
    MY_LIST_MAIN_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_OK_BUTTON = "android:id/button1",
    CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";
    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page", 10);
    }
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }
    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of the article",
                10
        );
    }
    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find button to open article options",
                5
                );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find options add article to reading list",
                5
                );
        this.waitForElementAndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Cannot find 'GOT IT' button",
                5
        );
        this.waitForElementAndClear(
                By.id(MY_LIST_MAIN_INPUT),
                "Cannot find search Wikipedia input",
                5
        );
        this.waitForElementAndSendKeys(
                By.id(MY_LIST_MAIN_INPUT),
                name_of_folder,
                "Cannot find search input",
                5
                );
        this.waitForElementAndClick(
                By.id(MY_LIST_OK_BUTTON),
                "Cannot press OK button",
                5
                );
    }
    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot close article",
                5
        );
    }
    public void addAnotherArticleToMyList()
    {
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find button to open article options",
                5
        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Cannot find options add article to reading list",
                5
        );
    }
}
