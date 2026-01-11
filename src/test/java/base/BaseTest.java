package base;

import com.microsoft.playwright.*;

import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected Properties props;

    protected void setup() {
        props = new Properties();
        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("playwright.properties")) {
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Could not load properties", e);
        }

        boolean headless = Config.getBool("headless"); //?

        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(headless)
        );

        context = browser.newContext();
        page = context.newPage();
    }

    protected void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
