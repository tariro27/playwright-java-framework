package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PlaywrightDocsPage;
import pages.PlaywrightHomePage;

public class PlaywrightDocsTest extends BaseTest {

    private PlaywrightHomePage homePage;
    private PlaywrightDocsPage docsPage;

    @BeforeMethod
    public void init() {
        setup();
        homePage = new PlaywrightHomePage(page);
        docsPage = new PlaywrightDocsPage(page);
    }

    @Test
            //(groups = {"smoke"})
    public void verifyDocsNavigationAndHeading() {
        homePage.navigate();
        Assert.assertTrue(homePage.getHeroTitle().contains("Playwright"));

        homePage.goToDocs();

        Assert.assertTrue(
                docsPage.getUrl().contains("/docs"),
                "URL should contain /docs after navigation"
        );

        Assert.assertFalse(
                docsPage.getHeading().isBlank(),
                "Docs page heading should not be blank"
        );
    }

    @AfterMethod
    public void cleanup() {
        tearDown();
    }
}
