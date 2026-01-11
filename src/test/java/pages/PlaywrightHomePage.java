package pages;

import com.microsoft.playwright.Page;

public class PlaywrightHomePage {

    private final Page page;

    // Locators
    private final String heroTitle = "h1";

    public PlaywrightHomePage(Page page) {
        this.page = page;
    }

    // Actions
    public void navigate() {
        page.navigate("https://playwright.dev");
    }

    public String getHeroTitle() {
        return page.locator(heroTitle).textContent();
    }
}
