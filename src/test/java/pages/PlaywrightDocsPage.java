package pages;

import com.microsoft.playwright.Page;

public class PlaywrightDocsPage {

    private final Page page;

    // The docs page main heading (Docusaurus usually uses h1)
    private final String heading = "main h1";

    public PlaywrightDocsPage(Page page) {
        this.page = page;
    }

    public String getHeading() {
        page.locator(heading).first().waitFor(); // waits for the element to exist/be attached
        String text = page.locator(heading).first().textContent();
        return text == null ? "" : text.trim();
    }

    public String getUrl() {
        return page.url();
    }
}
