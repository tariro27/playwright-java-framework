package pages;

import com.microsoft.playwright.Page;

public class DocsSearchComponent {
    private final Page page;

    private final String searchButton = "button[aria-label*='Search'], button.DocSearch-Button";
    private final String searchInput = "input[placeholder*='Search'], input.DocSearch-Input";
    private final String firstResult = ".DocSearch-Hit-title, .DocSearch-Hit a";

    public DocsSearchComponent(Page page) {
        this.page = page;
    }

    public void openSearch() {
        page.locator(searchButton).first().click();
        page.locator(searchInput).first().waitFor();
    }

    public void searchFor(String text) {
        page.locator(searchInput).first().fill(text);
    }

    public boolean hasAnyResult() {
        return page.locator(firstResult).first().isVisible();
    }
}

