package pages;

import base.Config;
import com.microsoft.playwright.Page;

public class PlaywrightHomePage {
    private final Page page;
    private final String heroTitle = "h1";

    public PlaywrightHomePage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate(Config.get("baseUrl"));
    }

    public String getHeroTitle() {
        return page.locator(heroTitle).textContent();
    }
}
