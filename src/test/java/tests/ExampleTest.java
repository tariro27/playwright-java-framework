package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @BeforeMethod
    public void init() {
        setup();
    }

    @Test
    public void verifyExampleDomainTitle() {
        page.navigate("https://example.com");
        Assert.assertEquals(page.title(), "Example Domain");
    }

    @AfterMethod
    public void cleanup() {
        tearDown();
    }
}
