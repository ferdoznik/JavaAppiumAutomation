import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Double extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }
    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }
    //    @Test
//    public void testAssertElementHasText()
//    {
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find search Wikipedia input",
//                5
//        );
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search…')]"),
//                "Stephen Fry",
//                "Cannot find search input",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'British comedian, actor, writer, presenter, and activist')]"),
//                        "Cannot find search Wikipedia input",
//                        5
//        );
//        WebElement title_element = waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_subtitle_text"),
//                "Cannot find article title",
//                15
//        );
//        String article_title = title_element.getAttribute("text");
//        Assert.assertEquals(
//                "We see unexpected title",
//                "English actor and comedian (born 1957)",
//                article_title
//        );
//    }
    @Test
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );
    }
    @Test
    public void testSwipeArticle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Appium");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();
    }
    @Test
    public void testSwipeTillText()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search Wikipedia input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Appium",
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Automation for Apps')]"),
                "Cannot find search Wikipedia input",
                5
        );
        MainPageObject.swipeUpToFindElement(
                By.xpath("//*[@text='View page in browser']"),
                "Could not find the end of the article",
                20
        );
    }
    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(article_title);
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
//                "Cannot find Back button",
//                10
//        );
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/nav_tab_reading_lists"),
//                "Cannot find SAVED button",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.id("org.wikipedia:id/item_description"),
//                "Cannot find folder SAVED",
//                5
//        );
//        MainPageObject.aitForElementAndClear(
//                By.id("org.wikipedia:id/text_input"),
//                "Cannot find input to set name of article folder",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Saved']"),
//                "Cannot close article, cannot find X link",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
//                "Cannot find navigation button to my list",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@text='" + name_of_folder + "']"),
//                "Cannot find created folder",
//                5
//        );
    }
    //    @Test
//    public void testCompareArticleTitle()
//    {
//       MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find search Wikipedia input",
//                5
//        );
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search…')]"),
//                "Java",
//                "Cannot find search input",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "Cannot find search Wikipedia input",
//                5
//        );
//        WebElement title_element = waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find article title",
//                15
//        );
//        String article_title = title_element.getAttribute("text");
//        Assert.assertEquals(
//                "We see unexpected title",
//                "Java (programming language)",
//                article_title
//        );
    @Test
    public void testAmountOfNotEmptySearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );
    }
    @Test
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        String search_line = "asdkjhqweq";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultsOfSearch();
    }
    @Test
    public void testCheckArticleInBackground()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search Wikipedia input",
                5
        );
        String search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                search_line,
                "Cannot find search input",
                5
        );
        String search_result_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']";
        MainPageObject.waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find anything by the request" + search_line,
                10
        );

        driver.runAppInBackground(Duration.ofSeconds(3));

        MainPageObject.waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find anything by the request" + search_line,
                10
        );
    }
    @Test
    public void testChangeScreenOrientation()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search Wikipedia input",
                5
        );
        String search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                search_line,
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find search Wikipedia input",
                10
        );
        String title_Before_Rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title article",
                10
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_After_Rotation = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title article",
                10
        );
        Assert.assertEquals(
                "Article title has been changed after rotation",
                title_Before_Rotation,
                title_After_Rotation
        );
    }
}