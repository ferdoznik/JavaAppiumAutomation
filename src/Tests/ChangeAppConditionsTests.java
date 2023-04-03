package Tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ChangeAppConditionsTests extends CoreTestCase
{
    @Test
    public void testCheckArticleInBackground()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        this.BackgroundApp(2);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }
    @Test
    public void testChangeScreenOrientation() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String title_before_Rotation = ArticlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String title_after_Rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title has been changed after rotation",
                title_before_Rotation,
                title_after_Rotation
        );
        this.rotateScreenLandscape();
        String title_after_second_Rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title has been changed after rotation",
                title_before_Rotation,
                title_after_second_Rotation
        );
    }
}