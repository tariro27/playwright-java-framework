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
        String text = page.locator(heroTitle).first().textContent();
        return text == null ? "" : text.trim();
    }

    // Locator for the Docs link in the top nav
    private final String docsLink = "a.navbar__item[href^='/docs']";

    public void goToDocs() {
        page.locator(docsLink).first().click();
        page.waitForURL("**/docs/**");
    }
}
