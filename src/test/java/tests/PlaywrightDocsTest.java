package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlaywrightDocsTest extends BaseTest {

    @BeforeMethod
    public void init() {
        setup();
    }

    @Test
    public void verifyPlaywrightDocsTitle() {
        page.navigate("https://playwright.dev");
        Assert.assertTrue(
                page.title().contains("Playwright"),
                "Page title should contain 'Playwright'"
        );
    }

    @AfterMethod
    public void cleanup() {
        tearDown();
    }
}
