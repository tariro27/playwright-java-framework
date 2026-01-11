package base;

import com.microsoft.playwright.*;

public class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext context;
    protected Page page;

    protected void setup() {
        boolean headless = Config.getBool("headless");
        String browserName = Config.get("browser"); // chromium | firefox | webkit

        playwright = Playwright.create();

        BrowserType browserType;
        switch (browserName == null ? "chromium" : browserName.toLowerCase()) {
            case "firefox":
                browserType = playwright.firefox();
                break;
            case "webkit":
                browserType = playwright.webkit();
                break;
            default:
                browserType = playwright.chromium();
        }

        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
        context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(java.nio.file.Paths.get("target/videos")));
        page = context.newPage();

        // Trace for every test
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true)
        );
    }

    protected void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}