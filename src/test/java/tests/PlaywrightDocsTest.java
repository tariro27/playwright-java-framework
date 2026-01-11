package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PlaywrightHomePage;

public class PlaywrightDocsTest extends BaseTest {

    private PlaywrightHomePage homePage;

    @BeforeMethod
    public void init() {
        setup();
        homePage = new PlaywrightHomePage(page);
    }

    @Test
    public void verifyPlaywrightHomePageTitle() {
        homePage.navigate();
        Assert.assertTrue(
                homePage.getHeroTitle().contains("Playwright"),
                "Hero title should contain 'Playwright'"
        );
    }

    @AfterMethod
    public void cleanup() {
        tearDown();
    }
}

