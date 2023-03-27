package Tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase
{
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
//    public void testSwipeTillText()
//    {
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//                "Cannot find search Wikipedia input",
//                5
//        );
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text,'Search…')]"),
//                "Appium",
//                "Cannot find search input",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text,'Automation for Apps')]"),
//                "Cannot find search Wikipedia input",
//                5
//        );
//        MainPageObject.swipeUpToFindElement(
//                By.xpath("//*[@text='View page in browser']"),
//                "Could not find the end of the article",
//                20
//        );

    @Test
    public void testAmountOfNotEmptySearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
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
    public void testAssertNumberOfArticles()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Jimmy Carr";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results",
                amount_of_search_results > 1
        );
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.initSearchInput();
    }

}
