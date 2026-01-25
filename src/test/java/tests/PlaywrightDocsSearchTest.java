package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.PlaywrightHomePage;
import pages.PlaywrightDocsPage;
import pages.DocsSearchComponent;

public class PlaywrightDocsSearchTest extends BaseTest {

    private PlaywrightHomePage homePage;
    private PlaywrightDocsPage docsPage;
    private DocsSearchComponent search;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        setup();
        homePage = new PlaywrightHomePage(page);
        docsPage = new PlaywrightDocsPage(page);
        search = new DocsSearchComponent(page);
    }

    @Test(groups = {"smoke"})
    public void verifyDocsSearchReturnsResults() {
        homePage.navigate();
        homePage.goToDocs();

        Assert.assertTrue(docsPage.getUrl().contains("/docs"), "Should be on docs page");

        search.openSearch();
        search.searchFor("trace");

        Assert.assertTrue(search.hasAnyResult(), "Search should return at least one result");
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        tearDown();
    }
}

