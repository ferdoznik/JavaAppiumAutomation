package Tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class HW_L7 extends CoreTestCase
{
    private static final String name_of_folder = "Video game series and multimedia franchise";
    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Mortal Kombat");
        SearchPageObject.clickByArticleWithSubstring("Video game series and multimedia franchise");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
            }else {
            ArticlePageObject.addToMySavedAndClearInput(name_of_folder);
            }

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Tekken");
        SearchPageObject.clickByArticleWithSubstring("Fighting video game series");

        ArticlePageObject.waitForTitleElement();

            if (Platform.getInstance().isAndroid()){
                ArticlePageObject.addArticleToMyList(name_of_folder);
            }else {
                ArticlePageObject.addToMySavedAndCancel(name_of_folder);
            }

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickSavedAndClose();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

            if (Platform.getInstance().isAndroid()) {
                MyListsPageObject.openFolderByName(name_of_folder);
            }

        MyListsPageObject.holdArticleToDelete(article_title);
        MyListsPageObject.deleteSavedArticle();
        MyListsPageObject.holdArticleToDelete(article_title);
        SearchPageObject.checkIfArticleIsDeleted();
        }
}
